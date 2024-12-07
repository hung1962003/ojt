# Practice with JDBC

In this exercise, we want to practice how to make a JDBC connection and query.

### Part 1: Make Connection

First, we need to implement three method, in this case `getConnection` and `insertTable` and `insertUser`.

**You have the following tasks:**

1. [task][Implement Get Connection](testCreateTable())
Implement the method `getConnection()` in the class `ConnectionUtils`. Make sure have exactly connection.

2. [task][Implement Insert Table](testCreateTable())
Implement the method `insertTable(Connection)` in the class `Exercise`. Make sure to create table

3. [task][Implement Insert User](testCreateTable())
Implement the method `insertUser(String,String,String,String,String,Connection)` in the class `Exercise`. Make sure to create table

### Part 2: Pratice with simple query

We want the application to use the query for jdbc correct

**You have the following tasks:**

1. [task][Select User By Name](testSelectUserByName())
Write your code in method `selectUserByName(String, Connection)` in class `Exercise` make sure that will return User with sample format:  
"ID: 1, Name: Alice Cooper, Address: 101 Orchid Way, Phone Number: 555-0001, Email: alicecooper@example.com, Zip Code: 10001"

2. [task][Update Name By Id](testDeleteUserById())
Write your code in method `deleteUser(Integer, Connection)` in class `Exercise` make sure that will delete the user by id



