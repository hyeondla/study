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

root-context.xml → webapp > WEB-INF > spring 폴더 안에 있음

```xml
<?xml version="1.0" encoding="UTF-8"?>
<beans xmlns="http://www.springframework.org/schema/beans"
	xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
	xsi:schemaLocation="http://www.springframework.org/schema/beans https://www.springframework.org/schema/beans/spring-beans.xsd">
	
	<!-- Root Context: defines shared resources visible to all other web components -->
	<bean id="dataSource" class="org.springframework.jdbc.datasource.DriverManagerDataSource">
		<property name="driverClassName" value="com.mysql.jdbc.Driver"></property>
		<property name="url" value="jdbc:mysql://localhost:3306/jspdb3"></property>
		<property name="username" value="root"></property>
		<property name="password" value="1234"></property>
	</bean>

	<!-- 마이바티스 객체생성 https://blog.mybatis.org/ 
	                     https://mybatis.org/mybatis-3/ -->
	<bean id="sqlSessionFactory" class="org.mybatis.spring.SqlSessionFactoryBean">
		<property name="dataSource" ref="dataSource"></property>
		<property name="configLocation" value="classpath:/mybatis-config.xml"></property>
		<property name="mapperLocations" value="classpath:mappers/**/*Mapper.xml"></property>
	</bean>
	
	<bean id="sqlSession" class="org.mybatis.spring.SqlSessionTemplate" destroy-method="clearCache">
		<constructor-arg name="sqlSessionFactory" ref="sqlSessionFactory"></constructor-arg>
	</bean>

</beans>

```

<br>

---

<br>

> BoardController.java

```java
package com.itwillbs.controller;

import javax.inject.Inject;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.itwillbs.domain.BoardBean;
import com.itwillbs.service.BoardService;

@Controller
public class BoardController {
	
	@Inject
	private BoardService boardService;
	
	@RequestMapping(value = "/board/write", method = RequestMethod.GET)
	public String insert() {
		
		return "/board/writeForm";
	}
	
	@RequestMapping(value = "/board/writePro", method = RequestMethod.POST)
	public String insertPro(BoardBean bb) {
		
		boardService.insertBoard(bb);
		
		return "redirect:/board/list";
	}
	
}
```

<br>

> BoardBean.java

```java
package com.itwillbs.domain;

import java.sql.Timestamp;

public class BoardBean {
	private int num;
	private String name;
	private String pass;
	private String subject;
	private String content;
	private int readcount;
	private Timestamp date;
	//file 추가
	private String file;
	
	public String getFile() {
		return file;
	}
	public void setFile(String file) {
		this.file = file;
	}
	
	public int getNum() {
		return num;
	}
	public void setNum(int num) {
		this.num = num;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getPass() {
		return pass;
	}
	public void setPass(String pass) {
		this.pass = pass;
	}
	public String getSubject() {
		return subject;
	}
	public void setSubject(String subject) {
		this.subject = subject;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public int getReadcount() {
		return readcount;
	}
	public void setReadcount(int readcount) {
		this.readcount = readcount;
	}
	public Timestamp getDate() {
		return date;
	}
	public void setDate(Timestamp date) {
		this.date = date;
	}
	
	
}
```

<br>

> BoardService.java

```java
package com.itwillbs.service;

import com.itwillbs.domain.BoardBean;

public interface BoardService {

	public void insertBoard(BoardBean bb);

}
```

> BoardServiceImpl.java

```java
package com.itwillbs.service;

import javax.inject.Inject;

import org.springframework.stereotype.Service;

import com.itwillbs.dao.BoardDAO;
import com.itwillbs.domain.BoardBean;

@Service
public class BoardServiceImpl implements BoardService {

	@Inject
	private BoardDAO boardDAO;
	
	@Override
	public void insertBoard(BoardBean bb) {
		boardDAO.insertBoard(bb);
	}

}
```

<br>

> boardMapper.xml

src/main/resources → mappers 패키지 생성 → xml 파일 생성

```xml
<?xml version="1.0" encoding="UTF-8"?>
<!DOCTYPE mapper
  PUBLIC "-//mybatis.org//DTD Mapper 3.0//EN"
  "http://mybatis.org/dtd/mybatis-3-mapper.dtd">
<mapper namespace="com.itwillbs.mapper.BoardMapper">

	<insert id="insertBoard">
		insert into board(num,name,pass,subject,content,readcount,date) 
		values(#{num},#{name},#{pass},#{subject},#{content},#{readcount},#{date})
	</insert>

</mapper>
```

<br>

> BoardDAO.java

```java
package com.itwillbs.dao;

import com.itwillbs.domain.BoardBean;

public interface BoardDAO {

	public void insertBoard(BoardBean bb);
	
}
```

> BoardDAOImpl.java

```java
package com.itwillbs.dao;

import java.sql.Timestamp;

import javax.inject.Inject;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

import com.itwillbs.domain.BoardBean;

@Repository
public class BoardDAOImpl implements BoardDAO {

	@Inject
	private SqlSession sqlSession;
	
	private static final String namespace="com.itwillbs.mapper.BoardMapper";
	
	@Override
	public void insertBoard(BoardBean bb) {
		System.out.println("BoardDAOImpl - insertBoard");
		
//		sqlSession.insert(namespace + ".insertBoard", bb);
	}

}
```

<br>

> writeForm.jsp

webapp > WEB-INF > views > board 폴더

이미지는 webapp > resources > img 폴더 안에 넣기

```jsp
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<h1>board/writeForm.jsp</h1>
<form action='<c:url value="/board/writePro" />' method="post">
<table border="1">
<tr><td>글쓴이</td>
    <td><input type="text" name="name"></td></tr>
<tr><td>비밀번호</td>
    <td><input type="password" name="pass"></td></tr>
<tr><td>제목</td>
    <td><input type="text" name="subject"></td></tr>
<tr><td>내용</td>
    <td><textarea rows="10" cols="20" name="content"></textarea></td></tr>
<tr><td colspan="2"><input type="submit" value="글쓰기"></td></tr>    
</table>
</form>
</body>
</html>
```

<br>

---

<br>

> 컨트롤러에서 파라미터 가져오기

```java
@RequestMapping(value = "/board/list", method = RequestMethod.POST)
public String list(Model model, HttpServletRequest request) {	
	String pageNum = request.getParameter("pageNum");
	//...
	return "/board/list";
}
```

<br>

> 파일 업로드 

pom.xml

```xml
<!-- https://mvnrepository.com/artifact/commons-fileupload/commons-fileupload -->
<dependency>
    <groupId>commons-fileupload</groupId>
    <artifactId>commons-fileupload</artifactId>
    <version>1.2.2</version>
</dependency>

<!-- https://mvnrepository.com/artifact/commons-io/commons-io -->
<dependency>
    <groupId>commons-io</groupId>
    <artifactId>commons-io</artifactId>
    <version>2.4</version>
</dependency>

<!-- https://mvnrepository.com/artifact/javax.annotation/javax.annotation-api -->
<dependency>
    <groupId>javax.annotation</groupId>
    <artifactId>javax.annotation-api</artifactId>
    <version>1.3.1</version>
</dependency>
```

<br>

webapp > resources > upload 폴더 생성

<br>

servlet-context.xml

```xml
<!-- 파일 업로드 -->
<beans:bean id="multipartResolver" class="org.springframework.web.multipart.commons.CommonsMultipartResolver">
	<beans:property name="maxUploadSize" value="10485760"></beans:property>
</beans:bean>
<!-- 업로드 폴더 위치 -->
<beans:bean id="uploadPath" class="java.lang.String">
    <!-- value에 본인이 upload 폴더 생성한 경로 입력 -->
	<beans:constructor-arg value="D:\\workspace_sts3\\SpringProject2\\src\\main\\webapp\\resources\\upload"></beans:constructor-arg>
</beans:bean>
```

<br>

fwriteForm.jsp

```jsp
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!-- ... -->
<form action='<c:url value="/board/fwritePro"/>' method="post" enctype="multipart/form-data">
```

<br>

controller