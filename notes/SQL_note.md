> 테이블 구조 조회

```mysql
DESCRIBE 테이블명
```

![sql001](./img/sql001.PNG)

<br>

> 데이터 검색

```sql
SELECT *
FROM 테이블명;
```

<br>

> NULL

해당 컬럼에 데이터를 입력하지 않은 경우 입력되는 값

표현식의 연산내용에 NULL값을 포함한 컬럼이 있다면 연산식의 내용과는 상관없이 NULL값이 출력

<br>

> Column Alias

1. 컬럼명 [AS] alias
2. 컬럼명 [AS] "Alias" → 대소문자 구분, 공백 포함, 특수문자 포함

 <br>

> 연결 연산자 

```sql
SELECT 컬럼1 || 컬럼2
FROM 테이블명;
```

<br>

> 리터럴 문자 
>

```sql
SELECT 컬럼1 || '리터럴 문자' || 컬럼2
FROM 테이블명;
```

![sql001](./img/sql002.PNG)

<br>

> 중복 값 제거

```sql
SELECT DISTINCT 컬럼명
FROM 테이블명;
```

![sql001](./img/sql003.PNG)

<br>

