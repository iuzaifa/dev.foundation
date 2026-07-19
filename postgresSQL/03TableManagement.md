# 3. Table Management (DDL)

## PostgreSQL CREATE TABLE

```sql
CREATE TABLE users (
    id SERIAL PRIMARY KEY,
    fullname VARCHAR(255) NOT NULL,
    email VARCHAR(255) NOT NULL UNIQUE,
    password VARCHAR(255) NOT NULL,
    is_active BOOLEAN NOT NULL DEFAULT FALSE
);
```

### Verify Table

List all tables:

```bash
\dt
```

**Output**

```text
          List of tables
 Schema | Name  | Type  |  Owner
--------+-------+-------+----------
 public | users | table | postgres
(1 row)
```

Describe the table:

```bash
\d users
```

**Output**

```text
                                     Table "public.users"
  Column   |          Type          | Collation | Nullable |              Default
-----------+------------------------+-----------+----------+-----------------------------------
 id        | integer                |           | not null | nextval('users_id_seq'::regclass)
 fullname  | character varying(255) |           | not null |
 email     | character varying(255) |           | not null |
 password  | character varying(255) |           | not null |
 is_active | boolean                |           | not null | false

Indexes:
    "users_pkey" PRIMARY KEY, btree (id)
    "users_email_key" UNIQUE CONSTRAINT, btree (email)
```

---

# PostgreSQL ADD COLUMN

Add a new `phone` column with a `UNIQUE` constraint.

```sql
ALTER TABLE users
ADD COLUMN phone VARCHAR(15) UNIQUE;
```

**Output**

```text
ALTER TABLE
```

### Verify

```bash
\d users
```

**Output**

```text
                                     Table "public.users"
  Column   |          Type          | Collation | Nullable |              Default
-----------+------------------------+-----------+----------+-----------------------------------
 id        | integer                |           | not null | nextval('users_id_seq'::regclass)
 fullname  | character varying(255) |           | not null |
 email     | character varying(255) |           | not null |
 password  | character varying(255) |           | not null |
 is_active | boolean                |           | not null | false
 phone     | character varying(15)  |           |          |

Indexes:
    "users_pkey" PRIMARY KEY, btree (id)
    "users_email_key" UNIQUE CONSTRAINT, btree (email)
    "users_phone_key" UNIQUE CONSTRAINT, btree (phone)
```

---

# PostgreSQL ALTER COLUMN

## Change Column Data Type

Change the size of the `password` column.

```sql
ALTER TABLE users
ALTER COLUMN password TYPE VARCHAR(20);
```

**Output**

```text
ALTER TABLE
```

### Verify

```bash
\d users
```

**Output**

```text
                                     Table "public.users"
  Column   |          Type          | Collation | Nullable |              Default
-----------+------------------------+-----------+----------+-----------------------------------
 id        | integer                |           | not null | nextval('users_id_seq'::regclass)
 fullname  | character varying(255) |           | not null |
 email     | character varying(255) |           | not null |
 password  | character varying(20)  |           | not null |
 is_active | boolean                |           | not null | false
 phone     | character varying(15)  |           |          |
```

---

## Rename a Column

Rename `fullname` to `full_name`.

```sql
ALTER TABLE users
RENAME COLUMN fullname TO full_name;
```

**Output**

```text
ALTER TABLE
```

### Verify

```bash
\d users
```

**Output**

```text
                                     Table "public.users"
  Column    |          Type          | Collation | Nullable |              Default
------------+------------------------+-----------+----------+-----------------------------------
 id         | integer                |           | not null | nextval('users_id_seq'::regclass)
 full_name  | character varying(255) |           | not null |
 email      | character varying(255) |           | not null |
 password   | character varying(20)  |           | not null |
 is_active  | boolean                |           | not null | false
 phone      | character varying(15)  |           |          |

Indexes:
    "users_pkey" PRIMARY KEY, btree (id)
    "users_email_key" UNIQUE CONSTRAINT, btree (email)
    "users_phone_key" UNIQUE CONSTRAINT, btree (phone)
```

---

# PostgreSQL DROP COLUMN

Remove the `phone` column.

```sql
ALTER TABLE users
DROP COLUMN phone;
```

**Output**

```text
ALTER TABLE
```

### Verify

```bash
\d users
```

**Output**

```text
                                     Table "public.users"
  Column    |          Type          | Collation | Nullable |              Default
------------+------------------------+-----------+----------+-----------------------------------
 id         | integer                |           | not null | nextval('users_id_seq'::regclass)
 full_name  | character varying(255) |           | not null |
 email      | character varying(255) |           | not null |
 password   | character varying(20)  |           | not null |
 is_active  | boolean                |           | not null | false
```

---

# PostgreSQL DROP TABLE

Delete the entire table.

```sql
DROP TABLE users;
```

**Output**

```text
DROP TABLE
```

### Verify

```bash
\dt
```

**Output**

```text
Did not find any relations.
```

> **Warning:** `DROP TABLE` permanently removes the table and all its data.