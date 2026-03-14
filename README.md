# Smart Crypto Currency Fraud Detection & Transaction Intelligence System

This is my midterm project for Web Technology and Internet. The idea behind it is a system that monitors cryptocurrency transactions to catch fraud and suspicious activity. It tracks wallet behavior, manages users with different roles, and organizes everything by geographic location following Rwanda's administrative structure.

## Entity Relationship Diagram (ERD)

### Location Hierarchy (One-to-Many Relationships)
```
Province (code PK, name)
    ↓ (1:N)
District (code PK, name, province_code FK)
    ↓ (1:N)
Sector (code PK, name, district_code FK)
    ↓ (1:N)
Cell (code PK, name, sector_code FK)
    ↓ (1:N)
Village (code PK, name, cell_code FK)
```

### Main System Tables
```
User (id PK, name, email, village_code FK → Village)
    ↓ (1:N)
Wallet (address PK, type, user_id FK → User)
    ↓ (1:N)
Transaction (id PK, amount, timestamp, wallet_address FK → Wallet)

User (id PK)
    ↓ (1:1)
UserProfile (id PK, bio, avatar_url, user_id FK → User)

User (id PK)
    ↔ (N:M)
Role (id PK, name)
    (via user_role join table)
```

### Key Relationships Explained
- **Location Chain**: Province → District → Sector → Cell → Village (Hierarchical One-to-Many).
- **User Links**: User belongs to Village (Many-to-One), has Profile (One-to-One), owns Wallets (One-to-Many), has Roles (Many-to-Many).
- **Transactions**: Linked to Wallets (Many-to-One).
- **Total Tables**: 10 (Province, District, Sector, Cell, Village, User, UserProfile, Role, Wallet, Transaction).

This ERD ensures efficient querying of users by location and tracking of crypto activities.

## Saving Location

I created a POST endpoint at /api/provinces in ProvinceController. When a request comes in with a Province JSON object in the body, it hits ProvinceService which calls provinceRepository.save(). This is a built-in JPA method that does an INSERT into the province table. The province has code as its primary key and name as a regular column. Other location entities like District reference Province through foreign keys, so saving a Province first makes sure those references will work later.

## Sorting and Pagination

For this I used Pageable and Sort from Spring Data JPA. In UserController there's a GET endpoint at /api/users that takes three optional parameters: page (defaults to 0), size (defaults to 10), and sortBy (defaults to "id"). I pass these into PageRequest.of(page, size, Sort.by(sortBy)) which creates a Pageable object. Then the repository's findAll(pageable) method only fetches that specific page of results from the database instead of loading everything. The response comes back as a Page object which includes the data plus metadata like total pages and total elements. This matters for performance because if there are thousands of users, we don't want to load them all into memory at once. Pagination splits it into manageable chunks.

## Many-to-Many Relationship (User - Role)

A user can have several roles like ADMIN or ANALYST, and a single role can be shared by many users. I mapped this with @ManyToMany on the roles field in User and used @JoinTable to define the join table. The join table is called user_role and it has two columns: user_id and role_id, both acting as foreign keys. On the Role side, I put @ManyToMany(mappedBy = "roles") so that User is the owning side and Role is the inverse. JPA handles creating and maintaining the join table automatically.

## One-to-Many Relationship (Province - User)

One Province can have many Users, but each User only belongs to one Province. In the Province entity I used @OneToMany(mappedBy = "province") for the list of users. In User I used @ManyToOne with @JoinColumn(name = "province_code") which creates the foreign key column in the users table pointing to the province's code. Province is the parent side and User is the child side that holds the actual foreign key.

## One-to-One Relationship (User - UserProfile)

Each user has exactly one profile and each profile belongs to exactly one user. UserProfile is the owning side because it has the foreign key. I put @OneToOne and @JoinColumn(name = "user_id") on the user field in UserProfile. On the User side, I used @OneToOne(mappedBy = "user") to mark it as the non-owning side. I separated profile data from the user table because not every query needs the bio and avatar info, so keeping them in different tables is cleaner.

## existBy() Method

In UserRepository I defined a method called existsByEmail(String email). Spring Data JPA reads the method name and automatically generates a query like SELECT COUNT(*) FROM users WHERE email = ?. It returns a boolean, true if a user with that email exists and false otherwise. The controller exposes this through GET /api/users/exists?email=someone@email.com. The nice thing about existsBy is that it doesn't load the full entity into memory, it just checks if a record is there, which is faster.

## Retrieving Users by Province

I made two methods in UserRepository: findByProvinceCode(String code) and findByProvinceName(String name). Spring Data JPA figures out the query from the method name. findByProvinceCode generates a query that joins User with Province and filters where province.code matches. findByProvinceName does the same but filters by province.name instead. The controller has two separate endpoints for these:
- GET /api/users/province/code/{code} for searching by province code
- GET /api/users/province/name/{name} for searching by province name

Both return a list of users that belong to the given province.
