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

---

<br>

> 톰캣 서버 포트 바꾸기

Servers 뷰 → 서버 더블클릭 → Ports → HTTP/1.1 → 포트변경(8088) → 저장

<br>

> Servlet 생성

src/main/java 우클릭 → New → Servlet 

→ Class name : 입력 (HttpServlet 자동 상속) → Next

→ URL mappings: 입력 → Finish

<br>