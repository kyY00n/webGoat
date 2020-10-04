# SQL Injection (intro 1-8)

## Concept

This lesson describes what is Structured Query Language and how it can be manipulated to perform tasks that were not the original intent of the developer.

### Goals

- The user will have a basic understanding of how SQL works and what it is used for
- The user will have a basic understanding of what SQL injections are and how they work
- The user will demonstrate knowledge on:
  - DML, DDL and DCL
  - String SQL injection
  - Numeric SQL injection
  - violation of the CIA triad

## What is SQL?

SQL is a standardized programming language which is used for managing relational databases and performing various operations on the data in them.

A database is a collection of data. Data is organized into rows, columns and tables, and it is indexed to make it easier to find relevant information.

Example SQL table with employees, the name of the table is 'employees':

Employees Table

| userid | first_name | last_name | department  | salary  | auth_tan |      |
| :----- | :--------- | :-------- | :---------- | :------ | :------- | :--- |
| 32147  | Paulina    | Travers   | Accounting  | $46.000 | P45JSI   |      |
| 89762  | Tobi       | Barnett   | Development | $77.000 | TA9LL1   |      |
| 96134  | Bob        | Franco    | Marketing   | $83.700 | LO9S2V   |      |
| 34477  | Abraham    | Holman    | Development | $50.000 | UU2ALK   |      |
| 37648  | John       | Smith     | Marketing   | $64.350 | 3SL99A   |      |

A company saves the following information of an employee in their databases.

One row represents one employee of the company.

By using SQL queries you can modify a database table and its index structures, add, update and delete rows of data.

There are three types of SQL commands in the SQL database language: Each type of command carries the danger of violating different protection goals if an intruder attacks your database system.