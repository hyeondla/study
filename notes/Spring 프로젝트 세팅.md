> Legacy 프로젝트 세팅

자바 컴파일러 / faces 1.8 버전

pom.xml → 메이븐 파일 → Maven Dependencies에 해당 jar 자동 설치

```xml
<properties>
		<java-version>1.8</java-version>
		<org.springframework-version>4.1.7.RELEASE</org.springframework-version>
		<org.aspectj-version>1.6.10</org.aspectj-version>
		<org.slf4j-version>1.6.6</org.slf4j-version>
</properties>
```

pom.xml 추가 → 설치 (AspectJ 위에)

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
<!-- https://mvnrepository.com/artifact/org.mybatis/mybatis -->
		<dependency>
		    <groupId>org.mybatis</groupId>
		    <artifactId>mybatis</artifactId>
		    <version>3.2.8</version>
		</dependency>
		<!-- https://mvnrepository.com/artifact/org.mybatis/mybatis-spring -->
		<dependency>
		    <groupId>org.mybatis</groupId>
		    <artifactId>mybatis-spring</artifactId>
		    <version>1.2.2</version>
		</dependency>
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
		<!-- https://mvnrepository.com/artifact/com.fasterxml.jackson.core/jackson-databind -->
		<dependency>
		    <groupId>com.fasterxml.jackson.core</groupId>
		    <artifactId>jackson-databind</artifactId>
		    <version>2.5.4</version>
		</dependency>
```

web.xml 한글처리 추가

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

servlet-context.xml 추가 - 자바 패키지 -> 스캔

```xml
<context:component-scan base-package="com.itwillbs.FunWeb" />
<context:component-scan base-package="com.itwillbs.controller" />
<context:component-scan base-package="com.itwillbs.service" />
<context:component-scan base-package="com.itwillbs.dao" />

<!-- 파일 업로드 -->
	<beans:bean id="multipartResolver" class="org.springframework.web.multipart.commons.CommonsMultipartResolver">
		<beans:property name="maxUploadSize" value="52428800"></beans:property>
	</beans:bean>
	<!-- upload 폴더 위치 설정 -->
	<beans:bean id="uploadPath" class="java.lang.String">
		<beans:constructor-arg value="D:\\workspace_sts3\\FunWeb\\src\\main\\webapp\\resources\\upload"></beans:constructor-arg>
	</beans:bean>
```
root-context.xml

```xml
<!-- DB 연결 객체 생성 -->	
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
```

src/main/resources > mybatis-config.xml

```
<?xml version="1.0" encoding="UTF-8"?>
<!DOCTYPE configuration
  PUBLIC "-//mybatis.org//DTD Config 3.0//EN"
  "http://mybatis.org/dtd/mybatis-3-config.dtd">
<configuration>

</configuration>
```

src/main/resources > mappers 패키지 > xxxMapper.xml 

src/main/java > domain 패키지 > XxxBean.java

src/main/java > controller 패키지 > XxxController.java

```java
@Controller
public class MemberController {

	@Inject
	private MemberService memberService;
	
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String insert() {
		return "/";
	}
	...
}
```

src/main/java > service 패키지 > XxxService.java XxxServiceImpl.java

src/main/java > dao 패키지 > XxxDAO.java XxxDAOImpl.java

```java
@Service
public class MemberServiceImpl implements MemberService {
	
    @Inject
	private MemberDAO memberDAO;
    
    @Override
    ...
        
}
```

```java
@Repository
public class MemberDAOImpl implements MemberDAO {
	
    @Inject
	private SqlSession sqlSession;
	
	private static final String namespace = "com.itwillbs.mapper.MemberMapper";
	
    @Override
    ...
        
}
```

<br>

AjaxController

```java
package com.itwillbs.controller;

import javax.inject.Inject;
import javax.servlet.http.HttpServletRequest;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.itwillbs.domain.MemberBean;
import com.itwillbs.service.MemberService;

@RestController
public class AjaxController {

	@Inject
	private MemberService memberService;
	
	@RequestMapping(value = "/member/idcheck", method = RequestMethod.GET)
	public ResponseEntity<String> idcheck(HttpServletRequest request) {
		ResponseEntity<String> entity = null;
		String result = "";
		try {
			String id = (String)request.getParameter("id");
			MemberBean mb = memberService.getMember(id);
			if(mb!=null) {
				result = "iddup";
			} else {
				result = "idok";
			}
			entity = new ResponseEntity<String>(result, HttpStatus.OK);
		} catch (Exception e) {
			e.printStackTrace();
			entity = new ResponseEntity<String>(HttpStatus.BAD_REQUEST);
		}
		return entity;
	}
	
}
```

```jsp
<script src="<c:url value='/resources/script/jquery-3.6.0.js'/>"></script>
<script type="text/javascript">
$(document).ready(function() {
	$('#btn').click(function() {
		$.ajax('<c:url value="/member/idcheck"/>',{
			data:{id:$('#id').val()},
			success:function(rdata){
				if(rdata=='iddup'){
					rdata="아이디 중복";
				} else {
					rdata="아이디 사용가능";
				}
				$('#dup').html(rdata);
			}
		});
	});
}
------------------------------------------------------------
<input type="button" value="dup.check" class="dup" id="btn">
```

<br>

```jsp
<c:choose>
		<c:when test="${empty sessionScope.id }">
			<div id="login"><a href="<c:url value='/member/login'/>">login</a> | <a href="<c:url value='/member/insert'/>">join</a></div>
		</c:when>
		<c:otherwise>
			<div id="login"><%=id %>님 | <a href="<c:url value='/member/logout'/>">logout</a> | <a href="<c:url value='/member/update'/>">update</a></div>
		</c:otherwise>
	</c:choose>
```

<br>

```jsp
<script src="<c:url value='/resources/script/jquery-3.6.0.js'/>"></script>
<script type="text/javascript">
$(document).ready(function() {
	$('.brown').click(function() {
		$.getJSON('<c:url value="/board/ajaxlist" />', function(rdata) {
			$.each(rdata, function(index,item) {
				// 문자열 => Date 날짜객체
				nowdate = new Date(item.date);
				// 날짜 년, 월, 일 => 문자열
				date_str = nowdate.getFullYear() + "." + (nowdate.getMonth()+1) + "." + nowdate.getDate();
				$('table').append('<tr><td class="contxt"><a href="${pageContext.request.contextPath}/board/content?num='+item.num+'">'+item.subject+'</a></<td><td>'+date_str+'</td></tr>');
			});
		});
		$(this).unbind();
	});
});
</script>
```

