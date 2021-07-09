<h2>MVC_Board 구조</h2>



svc + vo → 비즈니스 로직



<h4>db</h4>

DB 공통 수행 작업

JdbcUtil → DB 연결, 자원 반환 



<h4>action</h4>

인터페이스 → Action 클래스들이 공통적으로 구현해야 하는 execute 메서드 정의

클라이언트 요청 처리

execute 메서드 호출 → XXXFrontController에서 전송된 요청 파악, 처리

ActionForward 객체 리턴



<h4>vo</h4>

ActionForward 클래스 → 이동할 뷰 페이지 url, 포워딩 정보 저장 

XXXBean → 바구니

페이징 처리 정보



<h4>controller</h4>

모든 클라이언트 요청을 받아서 제어

각 요청을 처리하는 Action 객체 호출

서블릿 정의



<h4>svc</h4>

클라이언트 요청 처리

비즈니스 로직 구현 자바 파일



<h4>dao</h4>

데이터베이스로 SQL 구문 전송