**〈%       %〉**  변수, 연산자, 조건문, 반복문 사용 가능

**〈%=     %〉** 웹에 출력

〈%       %〉 안에 〈%=     %〉 사용 불가

**〈%!      %〉** 전역 변수 

**〈%@    %〉** 설정

**〈!--       --〉** 주석



> 웹서버

웹애플리케이션 서버에 전달

1. request, response 내장 객체 생성 (기억장소)
   request : 이름=값 요청 정보 저장
2. web.xml 참조
3. 서블릿 : request에 저장된 태그 이름에 해당하는 값을 가져와서 출력 명령
		request.getParameter("태그이름") → 리턴값 String 타입

<br>

> 한글 깨짐

form method="**post**" 일 때 발생, getParameter 사용 전에 처리 

```jsp
<% request.setCharacterEncoding("utf-8"); %>
```

<br>

> 문자열 → 정수 

**Integer.parseInt(변수명)**

<br>

> checkbox 다중 선택값 가져오기

**String[]** 변수명 = **request.getParameterValues**("태그이름");

```jsp
<% String[] hobby = request.getParameterValues("hobby"); %>

취미 : <%
	for(int i=0; i<hobby.length; i++){
	%>	<%=hobby[i] %> <%
	}
%>
```

<br>

> 내장객체에 값 저장

```jsp
<%
pageContext.setAttribute("page", "pageContext value");
request.setAttribute("req", "reqest value");
session.setAttribute("ses", "session value");
application.setAttribute("app", "application value");
%>

pageContext 값 : <%=pageContext.getAttribute("page") %><br>
request 값 : <%=request.getAttribute("req") %><br>
session 값 : <%=session.getAttribute("ses") %><br>
application 값 : <%=application.getAttribute("app") %><br>
```

<br>

> 내장객체 값 넘기기

```jsp
<% 
String id = request.getParameter("id"); 
String pw = request.getParameter("pw");
int num = Integer.parseInt(request.getParameter("num"));
%>
<!-- 1)------------------------------------------ -->
<a href="scopeProPro.jsp?id=<%=id%>&pw=<%=pw%>">
<!-- 2)------------------------------------------ -->
<script type="text/javascript">
	alert("scopeProPro.jsp 이동");
	location.href="scopeProPro.jsp?id=<%=id%>&pw=<%=pw%>";
</script>
<%
response.sendRedirect("scopeProPro.jsp?id="+id+"&pw="+pw);
%>
```

<br>

> 액션태그 - **forward**

```jsp
<jsp:forward page="이동할 페이지" />
<jsp:forward page="이동할 페이지"></jsp:forward>
```

 모든 request 정보 공유

<br>

> 액션태그 - **include**

```jsp
<%@ include file = "포함할 파일" %>
<!-- ---------------------------------- -->
<body>
<jsp:include page="포함할 파일" />
<!-- ---------------------------------- -->
<jsp:include page="포함할 파일">
<jsp:param value=" " name=" " />
</jsp:include>
</body>
```

반복되는 파일

<br>

---

<br>

> 세션 **session**

```jsp
<% 

//세션공간에 이름:값 저장
session.setAttribute("session_name", "session_value"); 

//세션공간에 값 삭제
session.removeAttribute("session_name"); 

//세션공간에 값 전체 삭제
session.invalidate(); 

%>
```

페이지 상관없이 값 유지

서버에 저장됨

보안상 중요한 데이터 저장

서버와 클라이언트 연결 정보 저장

기본 유지시간 값 30분

<br>

> 쿠키 **cookie**

```jsp
<%

//쿠키 객체 생성
Cookie cookie = new Cookie("cookie_name","cookie_value");
//쿠키 시간 설정 (초단위)
cookie.setMaxAge(1800); 
//클라이언트에 저장
response.addCookie(cookie);

//========================================

//쿠키값 가져오기 => 쿠키 배열 변수에 저장
Cookie cookie[] = request.getCookies();
if(cookie != null){
    for(int i=0; i<cookie.lentgh; i++){
        if(cookie[i].getName().equals("cookie_name")){
        	out.println("들고온 쿠키 주소값 : " + cookie[i] + "<br>");
			out.println("들고온 쿠키 이름 : " + cookie[i].getName() + "<br>");
			out.println("들고온 쿠키 값 : " + cookie[i].getValue() + "<br>");
        }
    }
}

//========================================

//쿠키값 삭제
Cookie cookie[] = request.getCookies();
if(cookie != null){
	for(int i=0; i<cookie.length; i++){
		if(cookie[i].getName().equals("cookie_name")){
			//쿠키 시간 설정 0초
            cookie[i].setMaxAge(0);
            //클라이언트에 저장
			response.addCookie(cookie[i]);
		}
	}
}

%>

```

페이지, 서버 상관없이 값 유지

클라이언트 하드디스크에 저장됨

서버 부하를 줄임

기본 유지시간 값 없음 → 설정 필요

<br>

>MySQL

```sql
#CMD창에서 접속
mysql -u 계정명 -p
비밀번호 입력

#데이터베이스 목록 확인
SHOW DATABASES;

#데이터베이스 생성
CREATE DATABASE 데이터베이스명;

#데이터베이스 삭제
DROP DATABASE 데이터베이스명;

#데이터베이스 사용
USE 데이터베이스명;

#데이터베이스 공간 상태 확인
STATUS;

#테이블 목록 확인
SHOW TABLES;

#테이블 생성
CREATE TABLE 테이블명(
	컬럼1 int PRIMARY KEY, 
    컬럼2 varchar(10)
);

#테이블 컬럼 추가
ALTER TABLE 테이블명
ADD 컬럼명 데이터타입;

#테이블 삭제
DROP TABLE 테이블명;

#테이블 구조 확인
DESC 테이블명;
DESCRIBE 테이블명;

#데이터 저장
INSERT INTO 테이블명(컬럼1, 컬럼2) VALUES(컬럼1값, 컬럼2값);

#데이터 수정
UPDATE 테이블명 SET 컬럼1=값1, 컬럼2=값2
WHERE 조건;

#데이터 삭제
DELETE FROM 테이블명
WHERE 조건;

#데이터 조회
SELECT * FROM 테이블명;

SELECT 컬럼1, 컬럼2 FROM 테이블명
WHERE 조건1 AND 조건2
ORDER BY 컬럼명 ASC|DESC;

#접속 해제
EXIT
```

데이터 정의어 : create, alter, delete
데이터 제어어 : grant, revoke
데이터 조작어 : insert, update, delete, select

<br>

> JDBC

```jsp
<%@page import="java.sql.Timestamp"%>
<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.PreparedStatement"%>
<%@page import="java.sql.DriverManager"%>
<%@page import="java.sql.Connection"%>
<%
request.setCharacterEncoding("utf-8");

//폼에서 넘어온 내용 저장
int num = Integer.parseInt(request.getParameter("num"));
String name = request.getParameter("name");

//현재 시스템 날짜 시간 저장
Timestamp date = new Timestamp(System.currentTimeMillis());

//1.Driver.class 불러오기
Class.forName("com.mysql.jdbc.Driver");

//2.DB 서버 접속
String dbUrl = "jdbc:mysql://localhost:3306/jspdb3"; //DB이름
String dbUser = "root"; //아이디
String dbPass = "1234"; //비밀번호
Connection con = DriverManager.getConnection(dbUrl, dbUser, dbPass);

//3.String 문자열 -> sql 구문 (테이블 확인하기)
String sql = "insert into student(num,name) values(?,?)"; 
String sql = "update student set name=? where num=?";
String sql = "delete from student where num=? and name=?";
String sql = "select * from student"; 
PreparedStatement pstmt = con.prepareStatement(sql);
//setXXX(parameterIndex, x)
//Index 1번부터 시작 -> sql values ? ? 순서대로 채움
//x -> '' 사용안함
pstmt.setInt(1, num); 
pstmt.setString(2, name); 
pstmt.setTimestamp(parameterIndex, date);

//4.INSERT/UPDATE/DELETE => sql 구문 실행
pstmt.executeUpdate();

//----------------------------------------

//4.SELECT => ResultSet 내장객체에 저장
ResultSet rs = pstmt.executeQuery();

//5.rs.next() 다음 행 이동 -> 데이터 있으면 true, 없으면 false
while(rs.next()){
   	out.println(rs.getInt(1)); //첫번째 컬럼(num)
	out.println(rs.getString(2)+"<br>"); //두번째 컬럼(name)
    //------------------------------
    out.println(rs.getInt("num")); 
	out.println(rs.getString("name")+"<br>");
    out.println(rs.getTimestamp("date"));
}
%>

```

자바 파일 만들기 

src/main/java → 패키지 생성 → 클래스 생성

```java
package member;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

public class MemberDAO { //메서드 정의
	
    //DB연결
	private Connection getConnection() throws Exception {//예외처리 → 메서드 호출하는 곳에서 처리
		//드라이버 로더
		Class.forName("com.mysql.jdbc.Driver");
		//DB 서버 접속
		String dbUrl="jdbc:mysql://localhost:3306/jspdb3";
		String dbUser="root";
		String dbPass="1234";
		Connection con=DriverManager.getConnection(dbUrl,dbUser,dbPass);
		
		return con;
	}
    
    //insert
	public void insertMember(MemberBean mb) {
		try { //예외처리
			//연결 메서드 호출
			Connection con=getConnection();
			//sql문
			String sql="insert into member(id,pass,name,date) values(?,?,?,?)";
			PreparedStatement pstmt=con.prepareStatement(sql);
			pstmt.setString(1, mb.getId());
			pstmt.setString(2, mb.getPass());
			pstmt.setString(3, mb.getName());
			pstmt.setTimestamp(4, mb.getDate());
			//실행
			pstmt.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace(); //예외 추적 메시지 출력
		} finally { //예외 상관없이 처리
			//기억장소 해제
		} 
		return;
    }
    
    //info
	public MemberBean getMember(String id) {

		MemberBean mb = new MemberBean();
		
		try {
            //연결 메서드 호출
			Connection con=getConnection();
			//sql문
			String sql = "select * from member where id=?";
			PreparedStatement pstmt = con.prepareStatement(sql);
			pstmt.setString(1, id);
			//실행
			ResultSet rs = pstmt.executeQuery();
			
			if(rs.next()) {
				mb.setId(rs.getString("id"));
				mb.setPass(rs.getString("pass"));
				mb.setName(rs.getString("name"));
				mb.setDate(rs.getTimestamp("date"));
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			
		}
		return mb;
	}
    
    //login
    public MemberBean userCheck(String id, String pass) {
		MemberBean mb = null;
		try {
			Connection con = getConnection();
	
			String sql = "select * from member where id=? and pass=?";
			PreparedStatement pstmt = con.prepareStatement(sql);
			pstmt.setString(1, id);
			pstmt.setString(2, pass);
						
			ResultSet rs = pstmt.executeQuery();
			if(rs.next()) {
				mb = new MemberBean();
				mb.setId(rs.getString("id"));
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			
		}
		return mb;
	}
}
```

```java
package member;

import java.sql.Timestamp;

public class MemberBean { //데이터 담아서 전달
	//멤버변수 접근자 private 
    //→ 아무나 접근 못하게 막아줌(은닉, 캡슐화)
	private String id;
	private String pass;
	private String name;
	private Timestamp date;
	
    //멤버함수 접근자 public
    //→ Getter, Setter 
    public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getPass() {
		return pass;
	}
	public void setPass(String pass) {
		this.pass = pass;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Timestamp getDate() {
		return date;
	}
	public void setDate(Timestamp date) {
		this.date = date;
	}
}
```

```jsp
<%@page import="member.MemberBean"%>
<%@page import="member.MemberDAO"%>
<!-- -------------------------- -->
<%
//MemberDAO 기억장소 할당 → 객체 생성
MemberDAO mdao = new MemberDAO();

//MemberDTO (MemberBean) 데이터 전달
MemberBean mb = new MemberBean();
mb.setId(id);
mb.setPass(pass);
mb.setName(name);
mb.setDate(date);

//메서드 호출
mdao.insertMember(mb);
%>
<!-- -------------------------- -->
<%
String id = (String)session.getAttribute("id"); 
MemberDAO mdao = new MemberDAO();
MemberBean mb = mdao.getMember(id);
%>
아이디 : <%=mb.getId() %><br>
비밀번호 : <%=mb.getPass() %><br>
이름 : <%=mb.getName() %><br>
가입날짜 : <%=mb.getDate() %><br>
<!-- -------------------------- -->
<%
String id = request.getParameter("id");
String pass = request.getParameter("pass");

MemberDAO mdao = new MemberDAO();
MemberBean mb = mdao.userCheck(id, pass);

if(mb != null){
	session.setAttribute("id", id);
	response.sendRedirect("main.jsp");
} else {
	%>
	<script type="text/javascript">
		alert("입력하신 정보가 틀립니다");
		history.back();
	</script> 
	<%
}
%>
```

<br>

> SELECT문 결과 테이블로 출력

```jsp
<table border="1">
<tr><td>번호</td><td>이름</td></tr>
<%
while(rs.next()){
	%><tr>
    	<td><%=rs.getInt("num") %></td>
    	<td><%=rs.getString("name") %></td>
    </tr><%	
}
%>
```

<br>

> 로그인

```jsp
<%
String sql = "select * from member where id=? and pass=?";
PreparedStatement pstmt = con.prepareStatement(sql);
pstmt.setString(1,id);
pstmt.setString(2,pass);

if(rs.next()){ //아이디와 비밀번호가 일치함
	//세션값 생성
	session.setAttribute("id", id);
	response.sendRedirect("main.jsp");
	}	
} else {
%>	
	<script type="text/javascript">
		alert("입력하신 정보가 틀립니다");
		history.back(); 
	</script>
<%
}
%>
<!-- ---------------------------------------- -->
<%
String sql = "select * from member where id=?";
PreparedStatement pstmt = con.prepareStatement(sql);
pstmt.setString(1,id);

ResultSet rs = pstmt.executeQuery();

if(rs.next()){ //아이디 일치
	if(pass.equals(rs.getString("pass"))){
		//비밀번호 일치 => 세션값 생성
		session.setAttribute("id", id);
		response.sendRedirect("main.jsp");
	} else {
		%>	
		<script type="text/javascript">
		alert("비밀번호가 일치하지 않습니다");
		history.back();
		</script>
		<%
	}
} else {
%>	
<script type="text/javascript">
alert("가입되지 않은 아이디입니다");
history.back();
</script>
<%
}
%> 
<!-- ======================================== -->
<%
//세션값 가져오기 (페이지 상관없이 값 유지)
//=> Object형으로 저장되어있기 때문에 형변환 필요
String id = (String)session.getAttribute("id");

Class.forName("com.mysql.jdbc.Driver");

String dbUrl = "jdbc:mysql://localhost:3306/jspdb3"; 
String dbUser = "root"; 
String dbPass = "1234"; 
Connection con = DriverManager.getConnection(dbUrl, dbUser, dbPass);

String sql = "select * from member where id=?";
PreparedStatement pstmt = con.prepareStatement(sql);
pstmt.setString(1,id);

ResultSet rs = pstmt.executeQuery();

if(rs.next()){
    %> 
	아이디 : <%=rs.getString("id") %><br>
	비밀번호 : <%=rs.getString("pass") %><br>
	이름 : <%=rs.getString("name") %><br>
	가입날짜 : <%=rs.getTimestamp("date") %><br>
	<%
}
%>
```

<br>

> 로그아웃

```jsp
<%
session.invalidate();
%>
<script type="text/javascript">
	alert("로그아웃");
	location.href="main.jsp";
</script>
<!-- ======================================== -->
<%
String id = (String)session.getAttribute("id");

if(id==null){
	response.sendRedirect("loginForm.jsp");
} 
%>

```

<br>

> 글번호 

```jsp
<%
int num=0; 
String sql = "select max(num) from board";
PreparedStatement pstmt = con.prepareStatement(sql);
ResultSet rs = pstmt.executeQuery();
if(rs.next()){
	num=rs.getInt("max(num)")+1;
}
%>
```

max() → 가장 큰 값을 리턴받음

null + 1 = 1

<br>

> 조회수

```
String sql = "update board set readcount=readcount+1 where num=?";
PreparedStatement pstmt = con.prepareStatement(sql);
pstmt.setInt(1, num);
pstmt.executeUpdate();
```

<br>

