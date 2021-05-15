> 기본 데이터 타입 (Primitive Type) 
>

<img src="./img/java001.PNG"><br>

byte (1Byte = 8bit) : 2<sup>8 = 256 = -128 ~ +127 

short (2Byte = 16bit) : 2<sup>16 = 65536 = -32768 ~ +32767 

int (4Byte = 32bit) : 2<sup>32 = 약 -21억 ~ +21억, 정수의 기본형 

long (8Byte = 64bit) : 2<sup>64 = 약 -922경 ~ +922경

 <br>

2진수 : 0, 1 사용, 접두사 0b

8진수 : 0~7 사용, 접두사 0

16진수 : 0~9, A~F(10~15) 사용, 접두사 0x

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

char ↔ byte, short 강제 형변환 필수

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

+=, -=, *=, /=, %=

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

==, !=, >, >=, <, <=

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

&&, ||, ^, !

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

