Here's the complete list — **psql terminal commands** to **full SQL commands**, organized start to end.

# 1. psql Terminal Login & Meta-Commands

## Login/Connection
```bash
sudo -i -u postgres          # switch to the postgres user
psql                         # open the psql shell
psql -U username -d dbname   # connect with a specific user/database
psql -h hostname -p 5432 -U username -d dbname   # connect to a remote server
```

## Meta-Commands (inside the psql shell, start with backslash `\`)

| Command | Purpose |
|---|---|
| `\l` or `\list` | List all databases |
| `\c dbname` | Connect to a specific database |
| `\dt` | List all tables in the current database |
| `\d tablename` | Show table structure (columns, types, constraints) |
| `\d+ tablename` | Show detailed table structure (size, storage too) |
| `\du` | List all users/roles |
| `\dn` | List all schemas |
| `\df` | List all functions |
| `\dv` | List all views |
| `\di` | List all indexes |
| `\x` | Toggle extended display (rows instead of columns — useful for wide tables) |
| `\timing` | Toggle query execution time display on/off |
| `\e` | Open query in editor (external editor) |
| `\i filepath.sql` | Execute an SQL file |
| `\o output.txt` | Save query output to a file |
| `\copy table TO 'file.csv' CSV HEADER` | Export table data to CSV |
| `\copy table FROM 'file.csv' CSV HEADER` | Import data from CSV into table |
| `\password username` | Set/change a user's password |
| `\conninfo` | Show current connection info (host, db, user) |
| `\h COMMAND` | Show help for an SQL command (e.g., `\h CREATE TABLE`) |
| `\?` | List all psql meta-commands |
| `\q` | Exit psql |
|`\! clear` | Clear terminal screen
|`\! pwd` | Current directory dikhao (shell command chalao)
|`\! ls` | Directory contents list karo (bina psql exit kiye)
