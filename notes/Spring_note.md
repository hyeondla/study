> Spring

spring-tool-suite-4-4.11.0.RELEASE-e4.20.0-win32.win32.x86_64.self-extracting.zip

C 드라이브에 압축 풀기 > contents.zip 압축풀기 > sts 폴더 > SpringToolSuite4.exe 바로가기

<br>

Help > Eclipse Marketplace 

Spring tools3 Add-On for Spring Tools 설치

Eclipse Web Developer Tools 설치

Eclipse Enterprise Java and Web Developer Tools 설치

<br>

Windows > Preferences > Web > CSS/HTML/JSP > Encoding : UTF-8

<br>

File > New > Other > Spring > Spring Legacy Project > 

Templates : Spring MVC Project

specify top-level package : com.itwillbs.myweb

→ 가상주소 http://localhost:8080/myweb/ 

<br>

프로젝트 > New > Other > Server > Apache >  Tomcat v8.0 >

directory : C:\Program Files\Apache Software Foundation\Tomcat 8.0

<br>

프로젝트 > BuildPath > Libraries > Add Library > Server > Tomcat > Finish

<br>

>  pom.xml 

```xml
<!-- https://mvnrepository.com/artifact/mysql/mysql-connector-java -->
<dependency>
    <groupId>mysql</groupId>
    <artifactId>mysql-connector-java</artifactId>
    <version>5.1.36</version>
</dependency>

<!-- https://mvnrepository.com/artifact/org.springframework/spring-jdbc -->
<dependency>
    <groupId>org.springframework</groupId>
    <artifactId>spring-jdbc</artifactId>
    <version>${org.springframework-version}</version>
</dependency>
```

<br>

---

<br>

>  web.xml 한글처리

```xml
<!-- post request 한글처리 -->
<filter>
	<filter-name>encoding</filter-name>
	<filter-class>org.springframework.web.filter.CharacterEncodingFilter</filter-class>
	<init-param>
		<param-name>encoding</param-name>
		<param-value>UTF-8</param-value>
	</init-param>
</filter>

<filter-mapping>
	<filter-name>encoding</filter-name>
	<url-pattern>/*</url-pattern>
</filter-mapping>
```

<br>

> Controller

주소 매핑, 처리 호출

```java
@Controller
public class MemberController {
    
    @RequestMapping(value = "/insert", method = RequestMethod.GET)
	public String insert() {
	//  /WEB-INF/views/insertForm.jsp 이동
		return "insertForm";
	}
    
    @RequestMapping(value = "/insertPro", method = RequestMethod.POST)
	public String insertPro(MemberBean mb) {
        // MemberBean을 매개변수로 받았을 때
        // → 폼의 파라미터 이름과 자바빈의 변수 이름이 일치하면 자동으로 저장됨
        
        // 회원가입 처리
        MemberServiceImpl memberService = new MemberServiceImpl();
		memberService.insertMember(mb);
        
        return "redirect:/login";
    }
    
}
```

<br>

> Service





<br>

> Repository

DB 작업



<br>





<br>

---

<br>

New Spring Legacy Project

Templates : Spring MVC Project

com.itwillbs.myweb2

생성

<br>

프로젝트 오른쪽클릭 → Properties → Java Compiler → 1.8 변경

Properties → Project Facets → Java → 1.8 변경

<br>

pom.xml  → java-version 변경 → spring-version 변경

```xml
<properties>
	<java-version>1.8</java-version>
	<org.springframework-version>4.1.7.RELEASE</org.springframework-version>
	<org.aspectj-version>1.6.10</org.aspectj-version>
	<org.slf4j-version>1.6.6</org.slf4j-version>
</properties>
```

<br>

pom.xml 프로그램 설치

→ jdbc

→ spring jdbc

→ mybatis, mybatis-spring

<br>

web.xml → 처리담당자 지정

```xml
<!-- post request 한글처리 -->
<filter>
	<filter-name>encoding</filter-name>
	<filter-class>org.springframework.web.filter.CharacterEncodingFilter</filter-class>
	<init-param>
		<param-name>encoding</param-name>
		<param-value>UTF-8</param-value>
	</init-param>
</filter>
	
<filter-mapping>
	<filter-name>encoding</filter-name>
	<url-pattern>/*</url-pattern>
</filter-mapping>
```

<br>

servlet-context.xml → java 폴더에 패키지 생성

```xml
<context:component-scan base-package="com.itwillbs.controller" />
<context:component-scan base-package="com.itwillbs.service" />
<context:component-scan base-package="com.itwillbs.dao" />
```

<br>



