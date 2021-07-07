> 톰캣 서버 포트 바꾸기

Servers 뷰 → 서버 더블클릭 → Ports → HTTP/1.1 → 포트변경(8088) → 저장

<br>

> Servlet 생성

src/main/java 우클릭 → New → Servlet 

→ Class name : 입력 (HttpServlet 자동 상속) → Next

→ URL mappings: 입력 → Finish

<br>

> Servlet 클래스

javax.servlet.Servlet 인터페이스 구현 필요 

→ 모든 추상메서드를 구현해야함

→ 해당 추상메서드가 모두 javax.servlet.http.HttpServlet 클래스에 구현되어 있음

→ HttpServlet 클래스를 상속받아 정의 

→ 필요한 추상메서드만 오버라이딩하여 사용

서블릿 클래스가 실행된 적이 없을 경우 (인스턴스가 생성되지 않았을 경우)

최초 1회 init() 메서드가 호출되고 Service() doGet() doPost() 호출

2회째부터 서블릿 클래스를 실행하는 경우  

init() 메서드 호출 X , Service() 메서드에서 쓰레드만 생성하고 doGet() doPost() 호출

```java
import javax.servlet.http.HttpServlet;

public class TestServlet extends HttpServlet {
    @Override // Get 방식 요청일때 자동 호출
	protected void doGet(HttpServletRequest reqest, HttpServletResponse response) throws ServletException, IOException {}
    @Override // Post 방식 요청일때 자동 호출
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {}
}
```

<br>

> web.xml

배포서술자 (Deployment Descriptor) 역할을 수행

servlet 태그와 servlet-mapping 태그를 사용 →  URL 과 서블릿 주소 매핑 작업 수행

"http://...(생략).../프로젝트명/서블릿주소" 입력

→ 해당 서블릿 주소에 연결된 현재 프로젝트의 XXX 클래스가 실행되도록 매핑 작업 수행 

다른 서블릿 매핑과 중복될 경우 404 Not Found 발생

매핑은 되었으나 지정된 서블릿 클래스가 없는 경우 500 ClassNotFoundException 발생

```xml
<!-- 서블릿 클래스 등록 -->
<servlet>
    <!-- 서블릿 클래스를 가리킬 서블릿 이름 지정 -->
    <servlet-name>서블릿이름</servlet-name> <!-- 동일하게 -->
    <!-- 서블릿 클래스 이름 지정 (존재하는 클래스) -->
    <servlet-class>[패키지명.]서블릿클래스</servlet-class>
</servlet>

<!-- 서블릿 클래스와 URL 매핑 -->
<servlet-mapping>
    <!-- 서블릿 이름 지정 (servlet 태그에서 설정한 이름) -->
 	<servlet-name>서블릿이름</servlet-name> <!-- 동일하게 -->
    <!-- 서블릿 클래스를 입력하기 위한 요청 주소의 패턴 설정 -->
    <url-pattern>/url으로 사용할 값</url-pattern>
 </servlet-mapping>
```

서블릿 3.0 버전부터 **@WebServlet** 어노테이션 기능 제공

→ 서블릿 클래스 정의 시 클래스 선언부 윗줄에 @WebServlet() 안에 문자열로 URL 작성

@webServlet("/xxx") → 단일매핑

@webServlet("***.**xx") → .xx로 끝나는 URL을 모두 매핑, 다중매핑

**request.getRequestURL()**

주소창에서 요청된 주소 "프로토콜://주소:포트번호/프로젝트명/서블릿주소" 리턴

리턴타입 StringBuffer → 문자열 변환 toString() 메서드 필요

**request.getRequestURI()**

요청된 주소 중에서 "/프로젝트명/서블릿주소"  리턴

**request.getContextPath()**

요청된 주소 중에서 "/프로젝트명" 리턴

**request.getServletPath()**

요청된 주소 중에서 "/서블릿주소" 리턴

```java
@WebServlet("/URL패턴")
@WebServlet("*.XXX")
public class 클래스명 extends HttpServlet {
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doProcess(request, response); // 호출 필수
    }
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doProcess(request, response); // 호출 필수
    }
	// GET,POST 방식 요청을 모두 처리하기 위한 메서드 (공통 작업)
	protected void doProcess(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String requestURL = request.getRequestURL().toString();
        String requestURI = request.getRequestURI();
        String contextPath = request.getContextPath();
        // 서블릿 주소 추출 
        String command = requestURI.substring(contextPath.length()); 
        String command = request.getServletPath();
        
        // 페이지 이동
        response.sendRedirect("result.jsp");
    }
}
```

```java
protected void doProcess(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	String command = request.getServletPath(); // 서블릿 주소
	
	if(command.equals("/loginForm.me")) {
		response.sendRedirect("loginForm.jsp");
	} else if(command.equals("/loginPro.me")) {
		String id = request.getParameter("id");
		String password = request.getParameter("password");	
		MemberLoginPro pro = new MemberLoginPro();
		String path = pro.login(id, password);
		response.sendRedirect(path);
	} else if(command.equals("/logout.me")) {
		MemberLogoutPro pro = new MemberLogoutPro();
		String path = pro.logout();
		response.sendRedirect(path);
	} 
}
```

<br>

> Forward

1. **Redirect** 방식

   포워딩 시 웹브라우저의 **주소(URL)가 변경**되어 새로운 요청을 수행

   새로운 요청에 의해 주소창의 요청 주소가 변경됨

   새로운 요청에 의한 포워딩이므로 request 객체가 새로 생성되어 전달

   → 기존의 **request 객체가 유지되지 않음**

   → request 객체에 저장된 데이터가 포워딩 된 페이지에서 공유되지 않음

2. **Dispatcher** 방식

   포워딩 시 웹브라우저의 **주소(URL)가 변경되지 않음**

   새로운 요청이 발생하더라도 기존 요청 주소가 유지됨

   포워딩 시 request, response 객체를 파라미터로 전달하므로 r**equest 객체가 유지됨**

   → request 객체에 저장된 데이터가 포워딩 된 페이지에서 **공유**됨

```java
public class ActionForward {
	
	private String path;
	private boolean isRedirect; // 리다이렉트 true, 디스패쳐 false
	
	public String getPath() {
		return path;
	}
	public void setPath(String path) {
		this.path = path;
	}
	public boolean isRedirect() {
		return isRedirect;
	}
	public void setRedirect(boolean isRedirect) {
		this.isRedirect = isRedirect;
	}
	
}
```

```java
ActionForward forward = null;

if(forward != null) {
	if(forward.isRedirect()) { // Redirect
		response.sendRedirect(forward.getPath());
	} else { // Dispatcher
		RequestDispatcher dispatcher = request.getRequestDispatcher(forward.getPath());
		dispatcher.forward(request, response);
	}		
}
```

<br>

> Action

각 액션 클래스에서 사용할 메서드를 통일할 목적으로 부모 인터페이스를 정의

인터페이스 내 공통 메서드인 execute() 메서드를 추상메서드로 정의

```java
public interface Action {
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception;
}
```

POJO 클래스 → 인스턴스 생성 → execute() 메서드 호출 → request 객체와 response 객체 전달

<br>

> DBCP 커넥션풀

**Resource** 태그를 사용하여 정보 설정

- **name** 속성 : 공유 리소스 이름(DB 작업 수행하는 코드에서 DBCP API 통해 불러올 때 지정)

- **auth** 속성 : 커넥션 풀 인증을 톰갯 등의 컨테이너에서 담당하도록 설정
- **type** 속성 : Connection 객체를 얻어가기 위한(getConnection() 메서드를 갖는) 객체(클래스) 설정
- **factory** 속성 : DataSource 객체를 생성하는 역할을 하는 팩토리 클래스 지정
- **driverClassName** 속성 : 연동할 데이터베이스의 JDBC 드라이버 클래스 위치 및 이름
- **url** 속성 : 연동할 데이터베이스 접근을 위한 URL(프로토콜://주소:포트번호/DB명)
- **username** 속성 : 데이터베이스 계정(Properties 객체 사용 시 미설정)
- **password** 속성 : 데이터베이스 계정 암호(Properties 객체 사용 시 미설정)
- **maxActive** 속성 : 최대 활성화 가능한 Connection 갯수(DB 동시 접속 가능한 사용자 수)

```xml
<?xml version="1.0" encoding="UTF-8"?>
<Context>
	<Resource
		name="jdbc/MySQL"
		auth="Container"
		type="javax.sql.DataSource"
		factory="org.apache.tomcat.dbcp.dbcp2.BasicDataSourceFactory"
		driverClassName="com.mysql.jdbc.Driver"
		url="jdbc:mysql://localhost:3306/jsp_model2_db3"
		username="root"
		password="1234"
		maxActive="500"
	/>
</Context>
```

main → webapp → META-INF → context.xml

<br>

> JDBC

```java
// 데이터베이스 연동 및 관리 작업을 수행
// → DB 연결 및 커넥션 반환, DB 자원 반환, 커밋, 롤백 기능 수행
// 인스턴스 생성없이 항상 메서드에 접근 가능하도록 모든 메서드를 static 으로 선언
public class JdbcUtil {
	// 1. 데이터베이스 연결 및 커넥션 반환을 수행할 getConnection() 메서드 정의
	public static Connection getConnection() {
		Connection con = null;
		try { // DBCP를 통해 생성된 Connection 객체 가져오기
            
			// 1) context.xml 파일의 <Context> 태그 부분 가져오기
			//    → InitialContext 객체 생성하여 Context 타입 변수에 저장 (업캐스팅)
			Context initCtx = new InitialContext();
			
			// 2) <Context> 태그 내의 <Resource> 태그 부분 가져오기
			//    → InitialContext 객체의 lookup() 메서드 호출
			//      리턴타입 Object → 다운캐스팅 필요
			Context envCtx = (Context)initCtx.lookup("java:comp/env");
			
			// 3) <Resource> 태그 내의 name 속성 가져오기
			//    → Context 객체의 lookup() 메서드 호출
			//      리턴타입 Object → 다운캐스팅 필요
			DataSource ds = (DataSource)envCtx.lookup("jdbc/MySQL");
			
			// 4) DataSource 객체(커넥션풀)로부터 Connection 객체 가져오기
			//    → getConnection() 메서드 호출
			//    → context.xml에서 username, password 미설정 시
			//      Properties 객체로부터 계정명, 패스워드를 가져와서 getConnection() 에 전달 가능
			//      con = ds.getConnection("root","1234");
			con = ds.getConnection();
			
			// 5) 트랜잭션을 적용하기 위해 데이터베이스(MySQL)의 Auto Commit 기능 해제
			//    → Connection 객체의 setAutoCommit() 메서드 호출 → false
			con.setAutoCommit(false);
		} catch (NamingException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return con;
	}
	
	// 2. 자원 반환을 위한 close() 메서드 정의
	//    객체가 null 이 아닐 경우에만 close() 메서드 호출
	public static void close(Connection con) {	
		if(con != null) { try { con.close(); } catch (SQLException e) { e.printStackTrace(); } }
	}
	public static void close(PreparedStatement pstmt) {
		if(pstmt != null) { try { pstmt.close(); } catch (SQLException e) { e.printStackTrace(); } }
	}
	public static void close(ResultSet rs) { 
        if(rs != null) { try { rs.close(); } catch (SQLException e) { e.printStackTrace();} }
	}
	
	// 3. 트랜잭션 기능을 수행하는 commit(), rollback() 메서드 정의
	//    → 작업을 수행할 Connection 객체를 파라미터로 전달
    //		AutoCommit 해제
	//      → 데이터베이스 작업 완료 후 Commit / 작업을 되돌리는 Rollback 직접 수행
	//    → Connection 객체의 commit(), rollback() 메서드 호출
	public static void commit(Connection con) {
		try {
			con.commit();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	public static void rollback(Connection con) {
		try {
			con.rollback();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
}
```

<br>

> DAO

```java
// 실제 데이터베이스 작업(비즈니스 로직)을 수행
public class BoardDAO {
	// ------------ 싱글톤 패턴 구현 ------------
	// 유일한 인스턴스 하나를 서로 다른 객체에서 공유하는 기법
	// 외부에서 인스턴스 생성을 직접 하지 못하도록 차단
	// 자신의 인스턴스를 생성
	// 생성된 인스턴스를 외부의 요청에 따라 리턴

	private static BoardDAO instance;
	
	private BoardDAO() {}

	public static BoardDAO getInstance() {
		// 인스턴스가 생성된 적이 없을 경우 생성 후 리턴
		if(instance == null) {
			instance = new BoardDAO();
		}
		
		return instance;
	}
	// ----------------------------------------------------------------------------------
	// 외부의 Service 클래스로부터 Connection 객체를 전달받아 Connection 타입 변수에 저장
	Connection con; 

	public void setConnection(Connection con) {
		this.con = con;
	}
	
	// ----------------------------------------------------------------------------------
	
}
```

<br>

> Service

```java
```

<br>