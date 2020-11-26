# Insecure Deserialization

안전하지 않은 **역직렬화** - 2015년부터 본격적으로 알려지기 시작함.

- Java library 에서 발생할 수 있음.
- library의 사용 위치, 사용 빈도에 따라 심각성이 달라짐.

- 역직렬화는 일반적인 웹사이트에서는 보기 힘들다 -> 일반적인 취약점은 아님.
- 자세히는 하지 않겠음

------

## 역직렬화 (Deserialization)

자바에서는 인스턴스를 객체(Object) 형태로 메모리에 저장함. 이때 Object를 Byte Code형태로 변환하는 과정을 직렬화라고 하는 것이다.

이때, 반대로 **Byte Code를 Object로 변환**하는 과정을 역직렬화(Deserialization)라고 한다.

직렬화와 역직렬화는 서로 다른 두 시스템이 **객체에 대한 데이터**를 Byte Code로 전달하고, 각 시스템 내에서는 Object로 사용할 수 있도록 하는 과정에 쓰이게 된다.

### 직렬화와 역직렬화 예제

직렬화 & 역직렬화 대상 메소드 예시 - User.class

```java
...
//User 객체 정의
public class User implements Seerializable {
	private String name;
  private String email;
  private String city;
  public User(String name, String email, String city) {
    this.name = name;
    this.email = email;
    this.city = city;
  }
  public String toPrint() {
    return String.format("name : '%s', email : '%s', city : '%s'", name, email, city);
  }
}
```

```java
...
//직렬화
	User user = new User("김직렬", "serial@lorem.com", "서울");
	byte[] serializedUser;

	ByteArrayOutputStream baos = new ByteArrayOutputStream();
	ObjectOutputStream oos = new ObjectOutputStream(baos);
	oos.writeObject(User); //oos가 baos변수에 Byte형태로 변환된 User 객체를 담는다.

	serializedUser = baos.toByteArray();
	String base64User = Base64.getEncoder().encodeToString(serializedUser)
...
```

```java
...
//역직렬화
	byte[] serializedUser = Base64.getDecoder().decode(base64User); //바이트코드로 변환
	ByteArrayInputSystem bais = new ByteArrayInputSystem(serializedUser);
	ObjectInputStream ois = new ObjectInputStream(bais); //객체로 다시 변환하기 위해 ois를 사용
	Object objectUser = ois.readObject();
	User user = (User) objectUser; //다운
...
```

