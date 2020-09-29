# SQL Injection (intro 9-13)

## 9. Try It! String SQL injection

The query in the code builds a dynamic query as seen in the previous example. The query is build by concatenating strings making it susceptible to string SQL injection:

```
"SELECT * FROM user_data WHERE first_name = 'John' AND last_name = '" + lastName + "'";
```

Using the form below **try to retrieve all the users** from the users table. You shoud not need to know any specific user name to get the complete list.

------

자아 우리는 여기서 마지막에 쿼리스트링을 채웁니다

마지막에 보면 `last_name="` 하고 따옴표가 오기 때문에! 우리는 string injection을 해줘야 해요^^

자 쉬워요 쉬워요~ 우리는 `or` 구문을 이용해서 우회할 것입니다.

저 뒤에 아무거나 써줘도 돼요. 왜냐면  false가 돼도 상관이 없거든요.

그래서 이렇게 입력해주면 돼요

```sql
'가용' or '1'='1
```

이렇게 넣으면 `lastName` 에 우리가 입력한 값이 들어가기 때문에 

```sql
SELECT * FROM user_data WHERE first_name = 'John' AND last_name = '가용' or '1'='1'
```

이 쿼리가 실행됩니다. 아직도 모르시겠다면>< 대답해드리는 게 인지상정!

지금 완성된 쿼리문을 보면 WHERE 절이

`false AND false or true` 의 형태를 띠고 있죠? 이 때, 연산 순서는 and가 먼저이므로 and 실행 후 `false or true`가 되고, 이는 무조건 `true`가 되어요.

이 문제처럼 적절한 상황에서  `or [true가 되는 문장]` 의 형태로 마지막에 넣어주면 우회할 수 있어용 아주 쉽죠?

## 10. Try It! Numeric SQL injection

The query in the code builds a dynamic query as seen in the previous example. The query in the code builds a dynamic query by concatenating a number making it susceptible to Numeric SQL injection:

```
"SELECT * FROM user_data WHERE login_count = " + Login_Count + " AND userid = " + User_ID;
```

Using the two Input Fields below, try to retrieve all the data from the users table.

Warning: Only one of these fields is susceptible to SQL Injection. You need to find out which, to successfully retrieve all the data.

------

얘도 마찬가지로 맨 뒤에서 `or [true가 되는 문장] ` 을 추가해주면 끝입니다.

<img src="./img/sqliIntro9-1.png" width="80%">

<img src="./img/sqliIntro9-2.png" width="80%">

이런 식으로 하면 끝납니다요.

ㅎㅎ 일 단 끄 읏~

더씁니당