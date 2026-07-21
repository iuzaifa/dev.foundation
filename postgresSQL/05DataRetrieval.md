1️⃣ SELECT Statement
- Purpose: Retrieve specific columns from a tabl
# 1.1 Select All Columns (*)
```sql test_db=# select * from employees;```
```
 emp_id |      name      | department |   city   | salary | age |       email        
--------+----------------+------------+----------+--------+-----+--------------------
      5 | Abu Huzaifa    | IT         | Delhi    |  45000 |  23 | abu@example.com
      6 | Rahul Sharma   | HR         | Noida    |  32000 |  28 | rahul@example.com
      7 | Priya Singh    | IT         | Gurugram |  60000 |  26 | priya@example.com
      8 | Fajlurrahman   | IT         | Delhi    |  45000 |  22 | psing@gmail.com
      9 | Sneha Verma    | Sales      | Noida    |  28000 |  24 | sneha@example.com
     10 | Amit Kumar     | HR         | Gurugram |  39000 |  31 | amit@example.com
     11 | Neha Gupta     | IT         | Delhi    |  52000 |  27 | neha@example.com
     12 | Vikas Yadav    | Sales      | Noida    |  25000 |  35 | vikas@gmail.com
     13 | Anjali Mehta   | Finance    | Gurugram |  47000 |  29 | anjali@example.com
     14 | Karan Malhotra | Finance    | Delhi    |  41000 |  33 | karan@example.com
     15 | Ali            | Devloper   |          |  89000 |  34 | ali@gmail.com
(11 rows)

```
---
# 1.2 Select Specific Columns
test_db=# select name , city , age from employees; 
      name      |   city   | age 
----------------+----------+-----
 Abu Huzaifa    | Delhi    |  23
 Rahul Sharma   | Noida    |  28
 Priya Singh    | Gurugram |  26
 Fajlurrahman   | Delhi    |  22
 Sneha Verma    | Noida    |  24
 Amit Kumar     | Gurugram |  31
 Neha Gupta     | Delhi    |  27
 Vikas Yadav    | Noida    |  35
 Anjali Mehta   | Gurugram |  29
 Karan Malhotra | Delhi    |  33
 Ali            |          |  34
(11 rows)

# 1.3 Select with Column Alias (Renaming)
test_db=# select name as "Employee Name", age as "Age Year", salary as "Monthly Salary" from employees ;  
 Employee Name  | Age Year | Monthly Salary 
----------------+----------+----------------
 Abu Huzaifa    |       23 |          45000
 Rahul Sharma   |       28 |          32000
 Priya Singh    |       26 |          60000
 Fajlurrahman   |       22 |          45000
 Sneha Verma    |       24 |          28000
 Amit Kumar     |       31 |          39000
 Neha Gupta     |       27 |          52000
 Vikas Yadav    |       35 |          25000
 Anjali Mehta   |       29 |          47000
 Karan Malhotra |       33 |          41000
 Ali            |       34 |          89000
(11 rows)

# 1.4 Select with Computed Columns
test_db=# select name, salary , salary * 12 as "Anual Salary ", salary / 30 as "Daily Rate" from employees; 
      name      | salary | Anual Salary  | Daily Rate 
----------------+--------+---------------+------------
 Abu Huzaifa    |  45000 |        540000 |       1500
 Rahul Sharma   |  32000 |        384000 |       1066
 Priya Singh    |  60000 |        720000 |       2000
 Fajlurrahman   |  45000 |        540000 |       1500
 Sneha Verma    |  28000 |        336000 |        933
 Amit Kumar     |  39000 |        468000 |       1300
 Neha Gupta     |  52000 |        624000 |       1733
 Vikas Yadav    |  25000 |        300000 |        833
 Anjali Mehta   |  47000 |        564000 |       1566
 Karan Malhotra |  41000 |        492000 |       1366
 Ali            |  89000 |       1068000 |       2966
(11 rows)

# 1.5 Select with String Concatenation
test_db=# select name || 'work in ' ||  department as "employees details", email  from employees;   
       employees details       |       email        
-------------------------------+--------------------
 Abu Huzaifawork in IT         | abu@example.com
 Rahul Sharmawork in HR        | rahul@example.com
 Priya Singhwork in IT         | priya@example.com
 Fajlurrahmanwork in IT        | psing@gmail.com
 Sneha Vermawork in Sales      | sneha@example.com
 Amit Kumarwork in HR          | amit@example.com
 Neha Guptawork in IT          | neha@example.com
 Vikas Yadavwork in Sales      | vikas@gmail.com
 Anjali Mehtawork in Finance   | anjali@example.com
 Karan Malhotrawork in Finance | karan@example.com
 Aliwork in Devloper           | ali@gmail.com
(11 rows)

# SELECT Practice Exercises
1. Write a query to select only employee names and their cities
```sql
select name ,city from employees ;
```
2. Write a query to show employees with column aliases: "Employee Name" and "Department"
```sql
select name as "Employee Name", department as "Department" from employees ;
```
3. Create a computed column showing salary as "Monthly Income" and age as "Age"
```sql
select salary as "Monthly Income" , age as "Age" from employees;
```

