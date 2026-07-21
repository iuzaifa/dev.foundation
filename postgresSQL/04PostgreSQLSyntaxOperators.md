# PostgreSQL Syntax & Operators — Notes

## Operators Reference Table

| Operator | Why Use | Query | Expected Result |
|----------|---------|-------|------------------|
| `=` | Exact match equality | `SELECT * FROM users WHERE id = 1;` | Returns the row where `id` is exactly 1. |
| `!=` or `<>` | Not equal to | `SELECT * FROM users WHERE status != 'inactive';` | Returns all rows where `status` is not `'inactive'`. |
| `>` | Greater than | `SELECT * FROM products WHERE price > 100;` | Returns products with price greater than 100. |
| `<` | Less than | `SELECT * FROM products WHERE price < 50;` | Returns products with price less than 50. |
| `>=` | Greater than or equal | `SELECT * FROM orders WHERE total >= 1000;` | Returns orders with total ≥ 1000. |
| `<=` | Less than or equal | `SELECT * FROM orders WHERE total <= 500;` | Returns orders with total ≤ 500. |
| `BETWEEN` | Range check | `SELECT * FROM employees WHERE salary BETWEEN 30000 AND 50000;` | Returns employees with salary between 30k and 50k (inclusive). |
| `LIKE` | Pattern matching (case-sensitive) | `SELECT * FROM customers WHERE name LIKE 'A%';` | Returns customers whose name starts with 'A'. |
| `ILIKE` | Pattern matching (case-insensitive) | `SELECT * FROM customers WHERE name ILIKE 'a%';` | Same as LIKE but ignores case. |
| `IN` | Match any value in a list | `SELECT * FROM products WHERE category IN ('Electronics', 'Books');` | Returns products in either Electronics or Books category. |
| `IS NULL` | Check for NULL values | `SELECT * FROM users WHERE email IS NULL;` | Returns users who have no email address. |
| `AND` | Combine conditions (both true) | `SELECT * FROM orders WHERE total > 500 AND status = 'shipped';` | Returns shipped orders with total > 500. |
| `OR` | Combine conditions (at least one true) | `SELECT * FROM products WHERE price < 10 OR stock > 100;` | Returns products that are cheap OR have high stock. |
| `NOT` | Negate a condition | `SELECT * FROM users WHERE NOT status = 'banned';` | Returns all users who are not banned. |

---

## Full `employees` Table (baseline — 10 rows)

```sql
SELECT * FROM employees;
```

| emp_id | name | department | city | salary | age | email |
|--------|------|-----------|------|--------|-----|-------|
| 5 | Abu Huzaifa | IT | Delhi | 45000 | 23 | abu@example.com |
| 6 | Rahul Sharma | HR | Noida | 32000 | 28 | rahul@example.com |
| 7 | Priya Singh | IT | Gurugram | 60000 | 26 | priya@example.com |
| 8 | Fajlurrahman | IT | Delhi | 45000 | 22 | psing@gmail.com |
| 9 | Sneha Verma | Sales | Noida | 28000 | 24 | sneha@example.com |
| 10 | Amit Kumar | HR | Gurugram | 39000 | 31 | amit@example.com |
| 11 | Neha Gupta | IT | Delhi | 52000 | 27 | neha@example.com |
| 12 | Vikas Yadav | Sales | Noida | 25000 | 35 | vikas@gmail.com |
| 13 | Anjali Mehta | Finance | Gurugram | 47000 | 29 | anjali@example.com |
| 14 | Karan Malhotra | Finance | Delhi | 41000 | 33 | karan@example.com |

*(Row 15 "Ali" shows up later in the NULL-check query — so it must've been inserted in between.)*

---

## Query Practice Log — every query with its full result table

### 1. `=` — Filter by department
```sql
SELECT * FROM employees WHERE department = 'IT';
```

| emp_id | name | **department** | city | salary | age | email |
|--------|------|-----------|------|--------|-----|-------|
| 5 | Abu Huzaifa | **IT** | Delhi | 45000 | 23 | abu@example.com |
| 7 | Priya Singh | **IT** | Gurugram | 60000 | 26 | priya@example.com |
| 8 | Fajlurrahman | **IT** | Delhi | 45000 | 22 | psing@gmail.com |
| 11 | Neha Gupta | **IT** | Delhi | 52000 | 27 | neha@example.com |

`(4 rows)` — only exact `IT` matches highlighted.

---

### 2. `!=` — Exclude a city
```sql
SELECT * FROM employees WHERE city != 'Noida';
```

| emp_id | name | department | **city** | salary | age | email |
|--------|------|-----------|------|--------|-----|-------|
| 5 | Abu Huzaifa | IT | **Delhi** | 45000 | 23 | abu@example.com |
| 7 | Priya Singh | IT | **Gurugram** | 60000 | 26 | priya@example.com |
| 8 | Fajlurrahman | IT | **Delhi** | 45000 | 22 | psing@gmail.com |
| 10 | Amit Kumar | HR | **Gurugram** | 39000 | 31 | amit@example.com |
| 11 | Neha Gupta | IT | **Delhi** | 52000 | 27 | neha@example.com |
| 13 | Anjali Mehta | Finance | **Gurugram** | 47000 | 29 | anjali@example.com |
| 14 | Karan Malhotra | Finance | **Delhi** | 41000 | 33 | karan@example.com |

`(7 rows)` — every city except Noida is kept.

---

### 3. `>` — Salary greater than 40000
```sql
SELECT * FROM employees WHERE salary > 40000;
```

| emp_id | name | department | city | **salary** | age | email |
|--------|------|-----------|------|--------|-----|-------|
| 5 | Abu Huzaifa | IT | Delhi | **45000** | 23 | abu@example.com |
| 7 | Priya Singh | IT | Gurugram | **60000** | 26 | priya@example.com |
| 8 | Fajlurrahman | IT | Delhi | **45000** | 22 | psing@gmail.com |
| 11 | Neha Gupta | IT | Delhi | **52000** | 27 | neha@example.com |
| 13 | Anjali Mehta | Finance | Gurugram | **47000** | 29 | anjali@example.com |
| 14 | Karan Malhotra | Finance | Delhi | **41000** | 33 | karan@example.com |

`(6 rows)`

---

### 4. `<` — Salary less than 40000
```sql
SELECT * FROM employees WHERE salary < 40000;
```

| emp_id | name | department | city | **salary** | age | email |
|--------|------|-----------|------|--------|-----|-------|
| 6 | Rahul Sharma | HR | Noida | **32000** | 28 | rahul@example.com |
| 9 | Sneha Verma | Sales | Noida | **28000** | 24 | sneha@example.com |
| 10 | Amit Kumar | HR | Gurugram | **39000** | 31 | amit@example.com |
| 12 | Vikas Yadav | Sales | Noida | **25000** | 35 | vikas@gmail.com |

`(4 rows)`

---

### 5. `>=` — Salary ≥ 45000
```sql
SELECT * FROM employees WHERE salary >= 45000;
```

| emp_id | name | department | city | **salary** | age | email |
|--------|------|-----------|------|--------|-----|-------|
| 5 | Abu Huzaifa | IT | Delhi | **45000** | 23 | abu@example.com |
| 7 | Priya Singh | IT | Gurugram | **60000** | 26 | priya@example.com |
| 8 | Fajlurrahman | IT | Delhi | **45000** | 22 | psing@gmail.com |
| 11 | Neha Gupta | IT | Delhi | **52000** | 27 | neha@example.com |
| 13 | Anjali Mehta | Finance | Gurugram | **47000** | 29 | anjali@example.com |

`(5 rows)` — note `45000` is included since it's `>=`.

---

### 6. `<=` — Salary ≤ 45000
```sql
SELECT * FROM employees WHERE salary <= 45000;
```

| emp_id | name | department | city | **salary** | age | email |
|--------|------|-----------|------|--------|-----|-------|
| 5 | Abu Huzaifa | IT | Delhi | **45000** | 23 | abu@example.com |
| 6 | Rahul Sharma | HR | Noida | **32000** | 28 | rahul@example.com |
| 8 | Fajlurrahman | IT | Delhi | **45000** | 22 | psing@gmail.com |
| 9 | Sneha Verma | Sales | Noida | **28000** | 24 | sneha@example.com |
| 10 | Amit Kumar | HR | Gurugram | **39000** | 31 | amit@example.com |
| 12 | Vikas Yadav | Sales | Noida | **25000** | 35 | vikas@gmail.com |
| 14 | Karan Malhotra | Finance | Delhi | **41000** | 33 | karan@example.com |

`(7 rows)`

---

### 7. `BETWEEN` — Salary between 30000 and 50000
```sql
SELECT * FROM employees WHERE salary BETWEEN 30000 AND 50000;
```

| emp_id | name | department | city | **salary** | age | email |
|--------|------|-----------|------|--------|-----|-------|
| 5 | Abu Huzaifa | IT | Delhi | **45000** | 23 | abu@example.com |
| 6 | Rahul Sharma | HR | Noida | **32000** | 28 | rahul@example.com |
| 8 | Fajlurrahman | IT | Delhi | **45000** | 22 | psing@gmail.com |
| 10 | Amit Kumar | HR | Gurugram | **39000** | 31 | amit@example.com |
| 13 | Anjali Mehta | Finance | Gurugram | **47000** | 29 | anjali@example.com |
| 14 | Karan Malhotra | Finance | Delhi | **41000** | 33 | karan@example.com |

`(6 rows)` — inclusive on both ends (30000 & 50000 would also qualify if present).

---

### 8. ⚠️ `LIKE` — wrong syntax (common mistake)
```sql
SELECT * FROM employees WHERE name LIKE = 'A%';
```
```
ERROR:  syntax error at or near "="
LINE 1: select * from employees where name like = 'A%';
                                                ^
```
> **Fix:** `LIKE` is not a comparison operator like `=` — never put `=` before it. Correct form: `... LIKE 'A%'`.

---

### 9. `LIKE` — correct usage (case-sensitive)
```sql
SELECT * FROM employees WHERE name LIKE 'A%';
```

| emp_id | **name** | department | city | salary | age | email |
|--------|------|-----------|------|--------|-----|-------|
| 5 | **Abu Huzaifa** | IT | Delhi | 45000 | 23 | abu@example.com |
| 10 | **Amit Kumar** | HR | Gurugram | 39000 | 31 | amit@example.com |
| 13 | **Anjali Mehta** | Finance | Gurugram | 47000 | 29 | anjali@example.com |

`(3 rows)`

```sql
SELECT * FROM employees WHERE name LIKE 'a%';
```

| emp_id | name | department | city | salary | age | email |
|--------|------|-----------|------|--------|-----|-------|
| *(no rows)* | | | | | | |

`(0 rows)` — 🔴 lowercase `a%` matches nothing because `LIKE` is **case-sensitive** in PostgreSQL.

---

### 10. `ILIKE` — case-insensitive version
```sql
SELECT * FROM employees WHERE name ILIKE 'a%';
```

| emp_id | **name** | department | city | salary | age | email |
|--------|------|-----------|------|--------|-----|-------|
| 5 | **Abu Huzaifa** | IT | Delhi | 45000 | 23 | abu@example.com |
| 10 | **Amit Kumar** | HR | Gurugram | 39000 | 31 | amit@example.com |
| 13 | **Anjali Mehta** | Finance | Gurugram | 47000 | 29 | anjali@example.com |

`(3 rows)` — ✅ same result as `LIKE 'A%'`, but works with lowercase `a%` too.

---

### 11. `IN` — Match from a list
```sql
SELECT * FROM employees WHERE department IN ('IT', 'HR');
```

| emp_id | name | **department** | city | salary | age | email |
|--------|------|-----------|------|--------|-----|-------|
| 5 | Abu Huzaifa | **IT** | Delhi | 45000 | 23 | abu@example.com |
| 6 | Rahul Sharma | **HR** | Noida | 32000 | 28 | rahul@example.com |
| 7 | Priya Singh | **IT** | Gurugram | 60000 | 26 | priya@example.com |
| 8 | Fajlurrahman | **IT** | Delhi | 45000 | 22 | psing@gmail.com |
| 10 | Amit Kumar | **HR** | Gurugram | 39000 | 31 | amit@example.com |
| 11 | Neha Gupta | **IT** | Delhi | 52000 | 27 | neha@example.com |

`(6 rows)`

---

### 12. `IS NULL` — Check for missing city
```sql
SELECT * FROM employees WHERE city IS NULL;
```

| emp_id | name | department | **city** | salary | age | email |
|--------|------|-----------|------|--------|-----|-------|
| 15 | Ali | Devloper | **(null)** | 89000 | 34 | ali@gmail.com |

`(1 row)` — 🔴 city column is empty for Ali.

---

### 13. `AND` — Combine two conditions
```sql
SELECT * FROM employees WHERE city = 'Delhi' AND department = 'HR';
```

| emp_id | name | department | city | salary | age | email |
|--------|------|-----------|------|--------|-----|-------|
| *(no rows)* | | | | | | |

`(0 rows)` — no one is both Delhi + HR.

```sql
SELECT * FROM employees WHERE city = 'Noida' AND department = 'HR';
```

| emp_id | name | **department** | **city** | salary | age | email |
|--------|------|-----------|------|--------|-----|-------|
| 6 | Rahul Sharma | **HR** | **Noida** | 32000 | 28 | rahul@example.com |

`(1 row)` — ✅ both conditions match for Rahul.

---

### 14. `OR` — Combine two conditions
```sql
SELECT * FROM employees WHERE city = 'Delhi' OR department = 'HR';
```

| emp_id | name | **department** | **city** | salary | age | email |
|--------|------|-----------|------|--------|-----|-------|
| 5 | Abu Huzaifa | IT | **Delhi** | 45000 | 23 | abu@example.com |
| 6 | Rahul Sharma | **HR** | Noida | 32000 | 28 | rahul@example.com |
| 8 | Fajlurrahman | IT | **Delhi** | 45000 | 22 | psing@gmail.com |
| 10 | Amit Kumar | **HR** | Gurugram | 39000 | 31 | amit@example.com |
| 11 | Neha Gupta | IT | **Delhi** | 52000 | 27 | neha@example.com |
| 14 | Karan Malhotra | Finance | **Delhi** | 41000 | 33 | karan@example.com |

`(6 rows)` — kept if *either* condition matches (highlighted column shows which one).

---

### 15. `NOT` — Negate a condition
```sql
SELECT * FROM employees WHERE NOT department = 'IT';
```

| emp_id | name | **department** | city | salary | age | email |
|--------|------|-----------|------|--------|-----|-------|
| 6 | Rahul Sharma | **HR** | Noida | 32000 | 28 | rahul@example.com |
| 9 | Sneha Verma | **Sales** | Noida | 28000 | 24 | sneha@example.com |
| 10 | Amit Kumar | **HR** | Gurugram | 39000 | 31 | amit@example.com |
| 12 | Vikas Yadav | **Sales** | Noida | 25000 | 35 | vikas@gmail.com |
| 13 | Anjali Mehta | **Finance** | Gurugram | 47000 | 29 | anjali@example.com |
| 14 | Karan Malhotra | **Finance** | Delhi | 41000 | 33 | karan@example.com |
| 15 | Ali | **Devloper** | *(null)* | 89000 | 34 | ali@gmail.com |

`(7 rows)` — everyone whose department is NOT `IT`.

---

## Key Takeaways
- `LIKE` is **case-sensitive**; `ILIKE` is **case-insensitive** — use `ILIKE` when case shouldn't matter.
- `LIKE`/`ILIKE` never take `=` before the pattern — that's a syntax error.
- `IS NULL` / `IS NOT NULL` must be used for NULL checks — `= NULL` doesn't work in SQL.
- `BETWEEN x AND y` is **inclusive** on both ends.
- `AND` narrows results (all conditions must match), `OR` widens results (any condition matches).