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

```java
@WebServlet("/URL패턴")
public class 클래스명 extends HttpServlet {
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doProcess(request, response); // 호출 필수
    }
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doProcess(request, response); // 호출 필수
    }
	// GET,POST 방식 요청을 모두 처리하기 위한 메서드 (공통 작업)
	protected void doProcess(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {}
}
```

<br>

