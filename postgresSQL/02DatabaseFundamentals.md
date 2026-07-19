# PostgreSQL CRUD Basics

## 1. Create Database

```sql
CREATE DATABASE dbname;
```

---

## 2. Connect to Database

```bash
\c dbname
```

> `\c` is a PostgreSQL terminal (`psql`) command used to connect to a database.

---

## 3. Create Table

```sql
CREATE TABLE users (
    id SERIAL PRIMARY KEY,
    fullname VARCHAR(255) NOT NULL,
    email VARCHAR(255) NOT NULL UNIQUE,
    password VARCHAR(255) NOT NULL,
    is_active BOOLEAN NOT NULL DEFAULT FALSE
);
```

---

## 4. Insert Data

```sql
INSERT INTO users (fullname, email, password, is_active)
VALUES ('huzaifa', 'huzaifa@gmail.com', 'huzaifa#123', FALSE);
```

---

# PostgreSQL SELECT (Fetch Data)

## 1. Fetch All Records

```sql
SELECT * FROM users;
```

**Output**

```text
 id |    fullname    |          email           |  password   | is_active
----+----------------+--------------------------+-------------+-----------
  1 | huzaifa        | huzaifa@gmail.com        | huzaifa#123 | f
  2 | Aarav Sharma   | aarav.sharma@gmail.com   | Aarav@123   | t
  3 | Vihaan Patel   | vihaan.patel@gmail.com   | Vihaan@123  | t
  4 | Aditya Singh   | aditya.singh@gmail.com   | Aditya@123  | f
```

---

## 2. Fetch Specific Columns

```sql
SELECT fullname, email
FROM users;
```

**Output**

```text
    fullname    |          email
----------------+--------------------------
 huzaifa        | huzaifa@gmail.com
 Aarav Sharma   | aarav.sharma@gmail.com
 Vihaan Patel   | vihaan.patel@gmail.com
 Aditya Singh   | aditya.singh@gmail.com
```

---

## 3. Fetch User by ID

```sql
SELECT *
FROM users
WHERE id = 2;
```

**Output**

```text
 id |   fullname   |         email          | password  | is_active
----+--------------+------------------------+-----------+-----------
  2 | Aarav Sharma | aarav.sharma@gmail.com | Aarav@123 | t
```

---

## 4. Fetch User by Email

```sql
SELECT *
FROM users
WHERE email = 'huzaifa@gmail.com';
```

**Output**

```text
 id | fullname |       email       |  password   | is_active
----+----------+-------------------+-------------+-----------
  1 | huzaifa  | huzaifa@gmail.com | huzaifa#123 | f
```

---

# PostgreSQL UPDATE

## Update User Name

```sql
UPDATE users
SET fullname = 'Abu Huzaifa'
WHERE id = 1;
```

**Output**

```text
UPDATE 1
```

Verify the update:

```sql
SELECT *
FROM users
WHERE id = 1;
```

**Output**

```text
 id |  fullname   |       email       |  password   | is_active
----+-------------+-------------------+-------------+-----------
  1 | Abu Huzaifa | huzaifa@gmail.com | huzaifa#123 | f
```

---

# PostgreSQL DELETE

## Delete a User

```sql
DELETE FROM users
WHERE id = 23;
```

**Output**

```text
DELETE 1
```

Remaining records:

```text
 24 | Vivek Kumar    | vivek.kumar@gmail.com    | Vivek@123   | t
 25 | Saurabh Pandey | saurabh.pandey@gmail.com | Saurabh@123 | f
```

---

# PostgreSQL DROP TABLE

## Delete the Entire Table

```sql
DROP TABLE users;
```

**Output**

```text
DROP TABLE
```

> **Warning:** `DROP TABLE` permanently removes the table and all its data.

---

# CRUD Summary

| Operation | SQL Command |
|-----------|-------------|
| Create Database | `CREATE DATABASE dbname;` |
| Connect Database | `\c dbname` |
| Create Table | `CREATE TABLE users (...);` |
| Insert Data | `INSERT INTO users ...` |
| Read Data | `SELECT ...` |
| Update Data | `UPDATE users SET ... WHERE ...` |
| Delete Record | `DELETE FROM users WHERE ...` |
| Delete Table | `DROP TABLE users;` |