> 기본 데이터 타입 (Primitive Type) 

<img src="./img/java001.PNG"><br>

byte (1Byte = 8bit) : 2<sup>8</sup> = 256 = -128 ~ +127 

short (2Byte = 16bit) : 2<sup>16</sup> = 65536 = -32768 ~ +32767 

int (4Byte = 32bit) : 2<sup>32</sup> = 약 -21억 ~ +21억, 정수의 기본형 

long (8Byte = 64bit) : 2<sup>64</sup> = 약 -922경 ~ +922경

 <br>

2진수 : 0, 1 사용, 접두사 0b

8진수 : 0 ~ 7 사용, 접두사 0

16진수 : 0 ~ 9, A ~ F(10 ~ 15) 사용, 접두사 0x

<br>

char : 정수형 데이터로 처리, 0~65535 값 가짐

&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;유니코드 표현 방법 사용 \uXXXX

ASCII : 미국 표준 문자 코드 

&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;'A' = 65, 'a' = 97, '0' = 48

<br>

> 자동 형변환

작은 데이터 타입 → 큰 데이터 타입

자바 컴파일러에 의해 자동으로 형변환

byte < short < int < long < float < double

char → int, long, float, double 자동 형변환 가능

(      char      )

<br>

> 강제 형변환

큰 데이터 타입 → 작은 데이터 타입

오버플로우 발생 가능

char ←→ byte, short 강제 형변환 필수

```java
int i = 100;
double d = 3.14;
//작은 데이터 타입 = (작은 데이터 타입) 큰 데이터 타입;
i = (int)d; //3 저장됨 (오버플로우)

byte b = 100;
char ch = (char)b;
```

<br>

> 산술 연산 형변환

피연산자끼리 데이터 타입을 일치시킨 후 연산 수행

int 보다 작은 타입 (byte, short, char) 끼리의 연산은 모두 int 타입으로 변환 후 연산

int 보다 큰 타입 (long, float, double)과의 연산은 큰 타입으로 변환 후 연산

→ 결과값 데이터는 큰 타입이 됨

리터럴 연산시에는 자동 형변환이 일어나지 않음

```java
byte b1 = 10;
byte b2 = 20;
//byte + byte = int + int = int
//int형 데이터를 byte 변수에 저장 → 오류
byte b3 = b1 + b2; 

//1. 연산 결과를 강제 형변환
byte b3 = (byte)(b1 + b2);
//2. 연산 결과와 같은 데이터 타입 변수에 저장
int b3 = b1 + b2;

byte b4 = 10 + 20; //리터럴 연산

//===============================================================

float f = 0.1f;
double d = 0.1;
//float + double = double + double = double 
//근사치 표현에 의해 잘못된 결과 발생 가능성

//1. double→float 강제 형변환 후 연산
System.out.println(f + (float)d);
//2. 두 실수를 정수 변환하여 연산 수행 후 실수로 변환
System.out.println(((int)(f * 10) + (int)(d * 10)) / 10.0);
```

<br>

> 연결 연산자 +

문자열 + 문자열 = 문자열문자열

문자열 + 숫자 = 문자열숫자

문자열 + 숫자 + 숫자 = 문자열숫자숫자

숫자 + 문자열 = 숫자문자열

숫자 + 숫자 + 문자열 = 산술연산된숫자문자열

<br>

> 확장 대입 연산자

+=   -=   *=   /=   %=

```java
char ch = 'A';

ch = ch + 3; //에러

//1. 강제형변환
ch = (char)(ch + 3)
//2. 확장대입연산자 사용
ch += 3;
```

<br>

> 비교 연산자

==  !=  >   >=   <   <=

true / false 리턴

```java
//char 타입끼리 비교 시 int 타입으로 변환 후 유니코드 값 비교
System.out.println('A' > 'B'); //false
System.out.println('A' == 65); //true

//double 타입과 float 타입 비교 시 실수 근사치 표현에 의해 잘못된 연산 결과 발생 가능
System.out.println(0.1 == 0.1f); //false
System.out.println((float)0.1 == 0.1f) //true
```

<br>

> 논리 연산자

&&  ||  ^   !

true / false 리턴

<img src="./img/java002.PNG"><br>

<br>

> 증감 연산자

해당 피연산자 값을 1만큼 증가 / 감소

- 선행연산자 (전위연산자) ++a / --a

  피연산자의 값을 먼저 증감시킨 후 다른 연산 수행

- 후행연산자 (후위연산자) a++ / a--

  다른 연산 수행 후 피연산자의 값 증감

<br>

> 삼항 연산자 (조건 연산자)

피연산자가 3개

조건식 ? 값1(true) : 값2(false);

<br>

> 조건문 if

```java
//다중if문
if(조건식1) {
	//조건식1 true
} else if(조건식2) {
	//조건식1 false, 조건식2 true
} else {
	//조건식1,2 false
}

//중첩if문
if(조건식1) {
    if(조건식2) {
        //조건식1,2 true 
    } else {
        //조건식1 true, 조건식2 false
    }
} else {
    //조건식1 false
}
```

<br>

> 조건문 switch

값에 대한 동등 비교만 가능

break문을 만나면 switch문을 빠져나감

break문이 없으면 break문을 만나거나 switch문이 종료될때까지 아래 모든 실행문 수행

조건식 연산 결과 : 정수 / 문자열 타입

```java
switch(조건식) {
	case 값1 :
		//조건식 결과 = 값1
		[break;]
	case 값2 :
		//조건식 결과 = 값2
		[break;]
	[default : //일치하는 값이 없을 경우 ]
}
```

<br>

> 반복문 for

반복 횟수가 정해져 있는 경우

```java
for(초기식; 조건식; 증감식) {
	//조건식 결과가 true일때 반복 실행
}
```

<br>

> 반복문 while

```java
//while문
while(조건식) {
	//조건식 결과가 true일때 반복 실행
}

//do~while문
//일단 반복문을 실행한 후 조건 검사
do {
    //반복 실행
} while(조건식);
```

break : 반복문을 종료하는 용도

continue : 반복문의 다음 문장 실행을 생략하고 다음 반복 진행

<br>

> Label

반복문 앞에 위치

break / continue 동작 지점 지정

중첩 반복문에서 반복문을 한꺼번에 빠져나가기 위해 사용

```java
LABELNAME:
반복문() {
	반복문() {
		if(조건식) {
			continue LABELNAME;
		}
        if(조건식) {
		break LABELNAME;
		}
    }
}
```

<br>

> 비트 단위 

- 논리 연산자  &   |   ~    ^

  정수에 대한 2진수 연산 수행

- 쉬프트 연산자  <<   >>

  - n << x 

    2진수 비트를 좌측으로 x 비트만큼 이동

    맨 좌측에서 탈락하는 비트는 맨 우측으로 이동됨

    연산 결과 = n * 2<sup>x 

  - n >> x

    2진수 비트를 우측으로 x 비트만큼 이동

    맨 우측에서 탈락하는 비트는 버려짐

    연산 결과 = n * (1/2)<sup>x 

<br>

> 배열

같은 타입 데이터만 저장 가능

메모리 공간이 연속된 공간에 차례대로 생성

인덱스 자동 부여, 0~(배열크기-1) 

한번 생성된 배열은 크기 변경 불가

배열 데이터 타입 기본값으로 자동 초기화

byte, short, int → 0

long → 0L, float → 0.0f, double → 0.0

char → \u0000, 0 

boolean → false

String → null

```java
//데이터타입[] 변수명 = {데이터1, 데이터2, …, 데이터n};
int[] arr = {1, 2, 3, 4, 5};

//데이터타입[] 변수명;
int[] arr;
//변수명 = new 데이터타입[배열크기];
arr = new int[5];
//초기화
arr = new int[]{1, 2, 3, 4, 5};
```

<br>

> 2차원 배열

행을 먼저 생성한 후 별도로 열 생성 가능

행 크기 : 변수명.length

열 크기 : 변수명[행 인덱스].length

```java
/*
데이터타입[][] 변수명 = {
    {데이터1, 데이터2, …, 데이터n}, //0행
	            …		
	{데이터1, 데이터2, …, 데이터n}  //m행
};
*/

//데이터타입[][] 변수명 = new 데이터타입[행크기][열크기];
int[][] arr = new int[3][];
arr[0] = new int[3];
arr[1] = new int[2];
arr[2] = new int[4];

for(int i=0; i<arr.length; i++) {
    for(int j=0; j<arr[i].length; j++) {
    	System.out.print(arr[i][j] + " ");
    }
    System.out.println();
}
```

<br>

> 메서드 Method

호출되어야만 실행, 작업 수행 후 호출 위치로 되돌아감

main() 메서드는 프로그램 실행 시점에서 자동으로 호출됨

전달인자(Argument) : 메서드에 전달하는 값

매개변수(Parameter) : 전달인자를 전달받아 저장하는 변수

메서드 호출 시 매개변수와 일치하는 타입과 개수의 데이터 전달 필수

리턴값 : 호출한 곳으로 전달하는 값

리턴타입을 명시한 경우 반드시 return문을 사용

→ 리턴타입 void인 경우 생략 가능, 리턴값 없이 return; 만 기술

```java
//메서드 정의
[접근제한자] 리턴타입 메서드명([매개변수…]) {
	//수행할 코드
	[return [리턴값];]
}

//메서드 호출
//1.리턴값이 없는 경우
메서드명([데이터…]);
//2. 리턴값이 있는 경우
데이터타입 변수명 = 메서드명([데이터…]); //변수에 저장
System.out.println(메서드명([데이터…])); //출력
```

<br>

> 클래스 Class

하나의 java 파일 내에 여러 클래스 정의 가능

파일명과 동일한 이름의 클래스 외에는 public 키워드 사용 불가

인스턴스(Instance) : 클래스를 사용하여 메모리에 생성된 객체

인스턴스의 주소를 담고 있는 참조변수를 통해 클래스 멤버변수, 메서드 호출

```java
//클래스 정의
[접근제한자] class 클래스명 {
	//멤버변수 선언
	//생성자 정의
	//메서드 정의
}

//인스턴스 생성
클래스명 변수명 = new 생성자명([데이터…]);
변수명.멤버변수 = "초기화할 값";
변수명.메서드();
```

<br>

> 접근제한자

(넓음) public > protected > default > private (좁음)

- private

  외부 클래스에서 접근(값 변경) 불가

  자신의 클래스 내에서만 접근 가능

- default

  접근제한자를 생략할 경우 적용, 기본 접근제한자

  같은 패키지에서만 접근 가능

- protected

  같은 패키지, 다른 패키지의 서브클래스에서 접근 가능

  서브클래스에서 슈퍼클래스의 인스턴스 생성 후 참조변수를 통한 접근 

  → is - a (상속) 관계가 아닌 has - a (포함) 관계로 취급되므로 protected 접근 불가

- public

  모든 패키지, 모든 클래스에서 접근 가능

<br>

> Getter / Setter

클래스 내에서 private 접근제한자로 선언된 멤버변수 등에 접근하기 위해 클래스 내에서 제공하는 메서드

public 접근제한자 사용

`Alt` `Shift` `S` + `R`

- Getter 

  내부 멤버변수의 값을 외부로 리턴

  파라미터 X, 리턴값 O

  getXXX() 형식의 이름 정의, 접근할 멤버변수 이름 사용

- Setter

  외부로부터 값을 전달받아 내부 멤버변수에 저장

  파라미터 O, 리턴값 X

  setXXX() 형식의 이름 정의, 접근할 멤버변수 이름 사용

```java
public class Person {
	private String name;
	//Getter
	public String getName() {
		return name;
	}
	//Setter
	public void setName(String name) {
		this.name = name;
	}
}
```

<br>

> 생성자 Constructor

클래스를 사용하여 인스턴스를 생성할 때 호출

별도 호출 불가, new 키워드 뒤에서만 사용 가능

선언부에 리턴타입 기술 X, 클래스 이름과 동일

클래스 정의 시 생성자를 정의하지 않으면 컴파일러에 의해 자동으로 기본 생성자가 생성됨

→ 파라미터 생성자를 하나라도 정의할 경우 기본 생성자 자동 생성 X

- 기본 생성자 

  클래스와 접근제한자가 같음

  매개변수 없음

  수행할 코드 없음

- 파라미터 생성자

  생성자 호출 시점에 전달해야할 데이터가 있는 경우 → 인스턴스 변수 초기화

  객체마다 다른 데이터를 가진 인스턴스 생성

  `Alt` `Shift` `S` + `O`

```java
//기본 생성자
[접근제한자] 클래스명() {}

//파라미터 생성자
[접근제한자] 클래스명([매개변수…]) {
    인스턴스변수명 = 데이터; //초기화
}
```

<br>

> 메서드 오버로딩 Method Overloading

동일한 이름, 다른 파라미터의 메서드를 여러번 정의

메서드 이름, 리턴타입, 접근제한자 동일하게 정의

전달되는 데이터(파라미터)만으로 각 메서드가 구분됨

```java
public void add(int num1, int num2) {
	System.out.println(num1 + num2);
}
//파라미터 데이터 타입이 다름
public void add(double num1, double num2) {
    System.out.println(num1 + num2);
}
//파라미터 갯수가 다름
public void add(int num1, int num2, int num3) {
    System.out.println(num1 + num2 + num3);
}
```



<br>

> 생성자 오버로딩 Constructor Overloading

생성자 호출 시 다양한 형태의 파라미터를 전달하여 객체를 다양하게 초기화

```java
public Person() {}

public Person(String name, String ssn) {
    this.Person("대한민국", name, ssn); //코드의 재사용
}

public Person(String nation, String name, String ssn) {
	this.nation = nation;
    this.name = name;
    this.ssn = ssn;
}
```

<br>

> 키워드 this 

자신의 인스턴스 주소값을 저장하는 참조 변수 (자바에 의해 자동 생성)

모든 인스턴스 내에 this 존재

- 레퍼런스 this

  자신의 인스턴스 내의 멤버변수 / 멤버메서드에 접근

  자신의 클래스 내의 생성자 / 메서드 내에서 this.멤버변수 / this.메서드() 형태로 접근

  로컬변수와 인스턴스(멤버)변수의 이름이 같을 때 인스턴스 변수를 지정하는 용도

- 생성자 this

  자신의 생성자 내에서 자신의 또 다른 생성자를 호출

  자신의 인스턴스에 접근하여 다른 오버로딩 생성자를 호출 → 초기화 코드 중복 제거

  생성자 첫번째 라인에서 호출, 다른 실행 코드보다 먼저 실행

<br>

> 가변형 인자 Variable Arguments, VARARGS

메서드 파라미터를 하나의 인자만 사용하여 다양하게 전달받음

동일한 타입의 파라미터를 0 ~ 무한대로 전달받아 배열로 관리

→ 전달받는 데이터의 갯수에 따라 자동으로 배열 생성

데이터 타입 뒤에 `...` 표기

다른 파라미터와 가변 인자 조합 가능

가변인자는 마지막 파라미터로 단 한번만 지정 가능

```java
public void print(String...names) { … }
public void print2(int num, String...names) { … }
```

<br>

> 값 전달 방식

- Pass by value 값에 의한 전달

  메서드 호출 시 기본 데이터타입 데이터를 전달하는 경우

  실제 값을 복사해서 전달

  호출된 메서드 내에서 전달받은 값을 변경해도 원본 데이터에는 영향 X

- Pass by reference 참조에 의한 전달

  메서드 호출 시 참조 데이터타입 데이터를 전달하는 경우

  실제 값이 있는 공간의 주소 값을 복사해서 전달

  호출된 메서드 내에서 전달받은 값에 접근하여 변경하는 경우 원본 데이터에 영향 O

  → 원본 데이터도 동일한 주소값 참조하기 때문

<br>

> 패키지 package

자바의 클래스 파일들을 모아놓는 공간

서로 다른 패키지에서 같은 이름의 다른 클래스 존재 가능

특정 클래스 파일은 하나의 패키지에만 소속됨

클래스명 앞에 패키지명 기술 → 상위패키지명.하위패키지명.클래스명 

클래스 파일 첫 번째 라인에 해당 클래스가 소속된 패키지명 명시 → package 패키지명;

<br>

특정 패키지를 자주 사용하는 경우 import문 사용

- import 패키지명.클래스명; 

- import 패키지명.*;
- import [패키지명.]클래스명; (같은 패키지일 때 생략 가능)

클래스명 대신 * 지정시 해당 패키지 내의 모든 클래스를 포함

java.lang 패키지는 import문 생략 가능

패키지명 보다 아래, 클래스 선언부보다 위에 위치, 여러번 작성 가능

`Ctrl` `Shift` `O`

<br>

> 자바 프로그램 실행 과정

1. 클래스 로딩

   static 변수 및 메서드가 메모리에 로딩됨

2. main() 메서드 호출

3. 인스턴스 생성

   인스턴스 변수 및 메서드가 메모리에 로딩됨

4. 인스턴스 메서드 호출

   로컬 변수가 메모리에 로딩됨

5. 결과 출력

6. 프로그램 종료

<br>

> 키워드 static

클래스, 메서드, 변수 제한자

클래스가 로딩되는 시점에 메모리에 로딩됨

(일반 메서드, 변수는 인스턴스가 생성되는 시점에 메모리에 로딩됨)

참조변수(인스턴스 생성) 없이 클래스명만으로 접근 가능

→ 클래스명.변수명 / 클래스.메서드명() 형태로 접근

- static 변수

  클래스(정적) 멤버로 취급됨

  모든 인스턴스에서 하나의 변수를 공유

  클래스 당 하나만 생성됨 (클래스 영역 Method Area에 생성됨)

- static 메서드

  리턴타입 앞에 static 키워드를 붙임

  인스턴스 변수, 메서드 사용 불가 

  → 인스턴스 생성 시점에 로딩되므로 static 메서드 로딩 시점에 존재하지 않음

  레퍼런스 this / super 사용 불가

  → 인스턴스 생성 시점에 로딩되므로 static 메서드 로딩 시점에 존재하지 않음

  → 클래스명.XXX 형식으로 접근

  메서드 오버라이딩 불가

  파라미터, 리턴값 없음

<br>

> 싱글톤 디자인 패턴 Singleton Design Pattern

단 하나의 유일한 인스턴스를 생성하여 공유

외부에서 인스턴스 생성을 하지 못하도록 차단

클래스 내에서 직접 인스턴스를 생성한 후 외부로 리턴

1. 생성자에 private 접근제한자를 선언하여 외부에서 인스턴스 생성이 불가능하게 함

2. 자신의 클래스에서 직접 인스턴스를 생성하여 참조변수에 저장

   → 외부에서 인스턴스 생성 없이 접근 가능하도록 static 키워드 사용

   → 외부에서 접근하지 못하도록 private 접근제한자 선언

3. 생성된 인스턴스를 외부로 리턴하는 Getter 메서드 정의

   → private 접근제한자로 선언된 멤버변수 인스턴스에 접근하여 생성된 인스턴스를 리턴

   → 인스턴스 생성 없이 접근 가능하도록 static 키워드 사용

```java
class SingletonClass {
	//인스턴스 생성
    private static SingletonClass instance = new SingletonClass();
    //기본 생성자 정의
    private SingletonClass() {}
    //Getter 정의
    public static SingletonClass getInstance() {
		return instance;
	}
}
//-----------------------------------------------------------------------
SingletonClass sc = SingletonClass.getInstance();
SingletonClass sc2 = SingletonClass.getInstance();
//두 인스턴스 sc, sc2는 같음
//리턴받은 인스턴스를 통해 멤버변수, 메서드에 접근 가능
```

<br>

> 상속 Inheritance

is - a 관계, 단일 상속

슈퍼클래스의 모든 멤버를 서브클래스에서 물려받아 선언없이 사용

private 접근제한자가 지정된 멤버는 상속 대상에서 제외

생성자는 상속 대상에서 제외 → 자신의 클래스 이름과 생성자 이름이 다르기 때문

서브클래스 생성자 호출 시 슈퍼클래스의 인스턴스를 먼저 생성한 후 서브클래스의 인스턴스가 생성됨

별도로 상속 대상을 지정하지 않은 경우 java.lang.Object 클래스를 자동으로 상속받음

코드 재사용성 증가, 유지보수 용이

```java
class 서브클래스명 extends 슈퍼클래스명 {}
```

<br>

> 포함

has - a 관계

일반적인 객체간의 관계

특정 클래스 내에서 다른 클래스의 인스턴스를 생성하여 해당 인스턴스를 다룸

<br>

> 메서드 오버라이딩 Method Overriding

슈퍼클래스로부터 상속받은 메서드를 서브클래스에서 재정의 @Override

슈퍼클래스의 메서드는 은닉됨

1. 상속 관계 필수

2. 메서드명, 리턴타입, 파라미터 일치해야 함

   → 리턴타입은 슈퍼클래스 / 서브클래스 타입으로 변경 가능

3. 접근제한자는 같거나 넓은 범위로만 변경 가능

`Alt` `Shift` `S` + `V`

<br>

> 키워드 super

오버라이딩 시 슈퍼클래스의 멤버변수와 메서드는 은닉되어 보이지 않음

→ 서브클래스의 인스턴스를 통해 슈퍼클래스 멤버에 접근 불가

메서드 내에서 접근 순서 : 로컬변수 → 멤버변수 → 슈퍼클래스의 멤버변수 → … → Object 멤버변수

- 레퍼런스 super

  은닉된 슈퍼클래스의 멤버에 접근하기 위한 키워드

  서브클래스 인스턴스를 생성할 때 생성됨

  자동으로 생성되는 슈퍼클래스의 인스턴스 주소를 저장하는 변수

  super.슈퍼클래스멤버변수 / super.슈퍼클래스메서드()

- 생성자 super

  서브클래스 인스턴스 생성 시 자동으로 슈퍼클래스 인스턴스를 먼저 생성한 후 서브클래스 인스턴스 생성

  서브클래스 생성자에서 슈퍼클래스 기본생성자를 자동 호출

  슈퍼클래스에 파라미터 생성자만 존재할 경우 서브클래스 생성자에서 컴파일 에러 발생

  슈퍼클래스의 생성자를 명시적으로 호출할 때 사용

  반드시 생성자의 첫 문장에서 실행 → super(), this() 동시 사용 불가

<br>

> 키워드 final

대상의 변경이 불가능하도록 지정

- final 변수

  변수 값 변경 불가

  상수로 취급됨 → 일반 변수와 구별하기 위해 이름을 대문자로 지정, 단어 구분 `_` 사용

  초기화 필수 

  - blank final 상수

    초기화를 수행하지 않은 상수

    생성자를 통해 초기화하여 사용 → 객체마다 다른 상수 값을 가짐

- final 메서드

  오버라이딩 금지

- final 클래스

  상속 금지

```java
class FinalMember {
    
	final int blankFinalMember;
	
	public FinalMember(int blankFinalMember) {
		super();
		this.blankFinalMember = blankFinalMember;
	}
    
}
```

<br>

> 레퍼런스 형변환

어떤 인스턴스를 다른 타입으로 변환하는 것

참조형 데이터타입간의 변환

반드시 상속 관계

슈퍼클래스타입 ←→ 서브클래스타입

업캐스팅

다운캐스팅

<br>

> 업캐스팅 Up Casting

슈퍼클래스 타입 레퍼런스가 서브클래스 인스턴스를 참조

하나의 슈퍼클래스 타입으로 여러 서브클래스 인스턴스 참조 가능

서브클래스의 인스턴스를 슈퍼클래스 타입으로 형변환

컴파일러에 의해 자동 형변환

슈퍼클래스로부터 상속된 멤버만 접근 가능 → 참조 가능한 영역이 축소됨 

```java
//서브클래스 Child → 슈퍼클래스 Parent 타입 형변환
Parent p = new Child();
```

<br>

> 다운캐스팅 Down Casting

서브클래스 타입 레퍼런스가 슈퍼클래스 인스턴스를 참조

슈퍼클래스 인스턴스를 서브클래스 타입으로 형변환

명시적(강제) 형변환 필요

참조 가능한 영역이 확대됨

기본적으로 다운캐스팅은 허용되지 않음 → 존재하지 않는 영역에 대한 참조 위험성

이미 업캐스팅 된 인스턴스를 다시 다운캐스팅하는 경우에만 가능

```java
Child c = new Parent(); //컴파일 오류
Child c = (Child)(new Parent()); //실행 시 다운캐스팅 시점에서 오류

//===================================================================================

Parent p = new Child(); //자동 형변환
Child c = (Child)p; //다운캐스팅
```

<br>

> instanceof

좌변의 객체가 우변의 클래스 타입인지 판별하는 연산자

우변의 클래스 타입과 같거나 그 자식 타입인 경우

A is a B = A instanceof B

true → 형변환 가능

false  → 형변환 불가

```java
if(c instanceof Parent) {
	Parent p = c;
}

if(p instanceof Child) {
    Child c = (Child)p;
}
```

<br>

> 동적 바인딩

상속 관계에서 업캐스팅 후 메서드를 호출할 때

컴파일 단계에서의 실행 대상과 실제 실행 단계에서의 실행 대상이 달라지는 것

<br>

>다형성

하나의 데이터타입(참조변수)으로 여러 인스턴스를 참조하는 특성

인스턴스를 업캐스팅하여 슈퍼클래스 타입 변수로 다루면

하나의 슈퍼클래스 타입으로 여러 서브클래스 타입 인스턴스를 다룰 수 있음

메서드에 다형성 활용

- 이미 다형성이 적용된 배열을 메서드 파라미터로 전달
- 메서드 파라미터로 인스턴스를 전달

<br>

> 추상메서드 Abstract Method

메서드 바디 { }가 존재하지 않음 → 세미콜론

실행코드가 없으므로 호출 될 수 없음

메서드 선언부 접근제한자 뒤에 abstract 키워드

```java
[접근제한자] abstract 리턴타입 메서드명([매개변수…]);
```

<br>

> 추상클래스 Abstract Class

인스턴스를 생성할 수 없음

→ 추상메서드가 호출되면 안되므로 인스턴스 생성을 못하게 차단

상속을 통한 슈퍼클래스로 사용, 다형성 활용을 위한 참조변수 타입으로 사용 가능

추상메서드가 없는 메서드도 추상클래스로 정의할 수 있음

추상메서드를 포함하는 추상클래스를 상속받는 서브클래스에서는

반드시 오버라이딩을 통해 추상메서드 바디{} 를 구현해야함

추상메서드를 구현하지 않을 경우 해당 클래스를 추상클래스로 선언해야함

슈퍼클래스에 추상메서드가 구현되어있는 경우 강제성 X, 선택적으로 오버라이딩 가능

추상메서드에 대한 구현을 강제함으로써 코드의 강제성, 통일성

class 키워드 앞에 abstract 키워드

```java
[접근제한자] abstract class 클래스명 {
	//멤버 변수
    //생성자
    //일반메서드
    //추상메서드
}
```

<br>

> 상수 Constant

변하지 않는 데이터

public static final 형태로 선언

- public : 누구나 접근 가능

- static : 

  클래스 로딩 시 함께 로딩되어 인스턴스 생성과 무관

  클래스명만으로 접근 가능(클래스명.변수명)

- final : 데이터 변경 불가

복잡한 데이터도 이름만으로 단순 사용 가능

<br>
> 열거형 Enum
	
데이터타입이 일치하면 다른 데이터라도 사용 가능한 상수의 단점을 해결

java.lang.Enum 클래스를 상속받음
	
데이터타입 구분 없이 나열

참조변수의 데이터타입으로 사용 가능
	
enum 상수 값은 동등비교연산자(==)로 일치 여부 비교 가능

switch~case문 타입으로 사용 가능
	
→ enum타입명.상수가 아닌 상수 자체를 비교
	
enum 상수에 각각 ordinal (순서번호) 값이 0부터 자동 부여됨 
	
ordinal() : 상수의 순서번호를 정수로 리턴
	
name() : 상수명을 문자열로 리턴
	
```java
public enum 타입명 {
	상수1, 상수2, …, 상수n
}
//===================================================================
enum Week {
	MONDAY, TUESDAY, WEDNESDAY, THURSDAY, FRIDAY, SATURDAY, SUNDAY
}
//--------------------------------------------------------------------
class WeekClass {
	public static final int MONDAY = 1;
	public static final int TUESDAY = 2;
	public static final int WEDNESDAY = 3;
	public static final int THURSDAY = 4;
	public static final int FRIDAY = 5;
	public static final int SATURDAY = 6;
	public static final int SUNDAY = 7;
}
//--------------------------------------------------------------------
Week today; // Week 타입 변수에는 Week 타입 상수만 저장 가능
today = Week.FRIDAY;

switch(today) {
	case MONDAY : 
	case TUESDAY : 
	case WEDNESDAY : 
	case THURSDAY : 
	case FRIDAY : 
	case SATURDAY : 
	case SUNDAY : 
}
//==================================================================
enum Month {
	// 생성자를 사용하면 상수에 다른 값 결합 가능
	JANUARY("1월"), FEBRUARY("2월");
	
	private String monthKor;
	Month(String monthKor) {
		this.monthKor = monthKor;
	}
	
	public String getMonthKor() {
		return monthKor;
	}
	
	public void setMontKor (String monthKor) {
		this.monthKor = monthKor;
}
```
<br>







---

<br>

> JDBC

1. JDBC 드라이버 로드

   java.lang.Class 클래스 static 메서드 forName() 호출

   → 파라미터 : 해당 DB 드라이버 클래스 파일명 (문자열)

2. DB 연결

   java.sql.DriverManager 클래스 static 메서드 getConnection() 호출

   → 파라미터 : 해당 DB 접속 URL, 계정명, 패스워드

   연결 성공 → java.sql.Connection 객체 리턴

3. SQL 구문 전달 및 실행

   Connection 객체 메서드 prepareStatement() 호출

   → 파라미터 : 실행할 SQL 구문 (문자열)

   연결 성공 → java.sql.PreparedStatement 객체 리턴

   PreparedStatement 객체 메서드 executeXXX() 호출

   - executeUpdate() : INSERT, UPDATE, DELETE 구문 실행 (데이터 조작)
   - executeQuery() : SELECT 구문 실행 전용 (데이터 조회)

4. SQL 구문 실행 결과 처리

   executeUpdate() : int 타입 → 쿼리문에 영향을 받은 레코드 수 리턴

   executeQuery() : ResultSet 타입 → 조회된 테이블을 관리하는 ResultSet 타입 객체 리턴

```java
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Ex {
    public static void main(String[] args) {
        
        String driver = "com.mysql.jdbc.Driver"; // MySQL Driver 지정
		String url = "jdbc:mysql://localhost:3306/java"; // MySQL 접속 URL
		String user = "root"; // MySQL 접속 계정
		String password = "1234"; // MySQL 접속 계정의 패스워드
        
        try {
			//1.드라이버 로드
			Class.forName(driver);
			//2.DB 연결
			Connection con = DriverManager.getConnection(url, user, password);
			//3.SQL 구문 전달 및 실행
			String sql = "SELECT * FROM test"; // 실행할 SQL 구문 작성
			PreparedStatement pstmt = con.prepareStatement(sql);
			//SELECT → PreparedStatement 객체 메서드 executeQuery() 호출
			ResultSet rs = pstmt.executeQuery();
			//4.SQL 구문 실행 결과 처리
			while(rs.next()) {
				// ResultSet 객체 메서드 getXXX() 호출 → 데이터 가져오기
				int idx = rs.getInt(1); // 인덱스 번호를 지정
				int idx = rs.getInt("idx"); // 컬럼명을 지정
			}
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
			System.out.println("드라이버 로드 실패");
		} catch (SQLException e) {
			e.printStackTrace();
			System.out.println("DB 연결 실패 / 구문 오류");
		}
    }
}
```

<br>

