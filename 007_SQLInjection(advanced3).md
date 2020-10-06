# SQL Injection (advanced3)

### Now it is time for a quiz!

It is recommended to do all SQL injection lessons before trying the quiz. Answer all questions correctly to complete the  assignment.

------

#### 1. What is the difference between a prepared statement and a statement?

​	1) Prepared statements are statements with hard-coded parameters.

​	: **아니다.** prepared statement는 항상 place holder를 사용하고, 그 상태에서 precompile이 진행된다. 후에 사용자 입력을 받아 집어넣고 다시 컴파일한다. hard-coding은 매개변수의 값이 처음부터 정해져있는 것이므로 틀린말이다. 

​	2) Prepared statements are not stored in the database.

​	: 아니다. 개소리다

​	3) A statement is faster: 아니다. prepared statement는 precompile되기 때문에 더 빠름.

​	4) **A statement has got values instead of a prepared statement.**

​	: 정답! 

------

#### 2. Which one of the following characters is a placeholder for variables?

​	1) *

​	2) =

​	3) ? :얘가 place holder로 쓰이는 애다.

​	4) !

------

#### 3. How can prepared statements be faster than statements?

​	1) They are not static so they can compile better written code than statements.

​	2) **Prepared statements are compiled once by the database management system waiting for input and are pre-compiled this way.**

​	3) Prepared statements are stored and wait for input it raises performance considerably.

​	4) Oracle optimized prepared statements. Because of the minimal use of the databases resources it is faster.

자바 예제)

```java
String query = "select * from member where id=?";

//precompile 진행, 이후에는 따로 이 쿼리를 컴파일 하지 않는다.
pstmt = conn.prepareStatement(query); 

//문장 자체는 컴파일되어 기계어로 메모리에 이미 올라가 있기 때문에 유저 변수만 binding 처리를 한다.
//statement는 매번 컴파일을 해야한다. 그래서 pstmt가 더 빠른 것이다!

pstmt.setString(1, userid); //binding
```

------

#### 4. How can a prepared statement prevent SQL-Injection?

​	1) Prepared statements have got an inner check to distinguish between input and logical errors.

​	: pstmt는 sql injection을 막기 위해 만들어진건 아니다(?) 그냥 성능 좋으라고 만든 것..? (근데 뇌피셜이래..)

​	2) Prepared statements use the placeholders to make rules what input is allowed to use.

​	3) **Placeholders can prevent that the users input gets attached to the SQL query resulting in a seperation of code and data.**

​	: 코드와 데이터가 분리되는 것을 방지할 수 있다. => injection에서는 싱글쿼터나 다른 문자들을 이용해서 코드와 데이터를 분리.

​	4) Prepared statements always read inputs literally and never mixes it with its SQL commands.

​	: 아니다. 애초에 pstmt가 취약한 문장으로 컴파일되면 당연히 취약하다.

```java
String query = "select * from member where id ='" + userid +"'";
pstmt = conn.prepareStatement(query);
```

이렇게 precompile되면 당연히 얘도 취약하다...

------

#### 5. What happens if a person with malicious intent writes into a register form: Robert); DROP TABLE Students;-- that has a prepared statement?

​	1) The table Students and all of its content will be deleted.

​	: 아니다. 삭제되지 않는다.

​	2) The input deletes all students with the name Robert.

​	: 아니다.

​	3) The database registers 'Robert' and deletes the table afterwards.

​	: 아니다.

​	4) **The database registers 'Robert' ); DROP TABLE Students;--'.**

​	: 맞다. 사용자 입력값이 그대로 데이터가 된다.

