
public class MemberLoginPro {
	public String login(String id, String password) {
		System.out.println("MemberLoginPro - login()");
		System.out.println("아이디 : " + id);
		System.out.println("비밀번호 : " + password);
		
		String path = "";
		boolean loginResult = false; // 로그인 결과 가정
		
		if(id.equals("admin")) {
			loginResult = true;
		}
		
		if(loginResult) {
			System.out.println("로그인 성공 - loginResult.jsp 이동");
			path = "loginResult.jsp";
		} else {
			System.out.println("로그인 실패 - loginForm2.jsp 이동");
			path = "loginForm2.jsp";
		}
		return path;
	}
}
