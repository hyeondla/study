package mailtest;

import javax.mail.Authenticator;
import javax.mail.PasswordAuthentication;

public class GoogleAuthentication extends Authenticator {
	
	PasswordAuthentication passAuth;
	
	// 생성자
	public GoogleAuthentication() {
		// 구글 인증
		passAuth = new PasswordAuthentication("hyeondla", "uufsjombldrusmjl");
	}
	
	public PasswordAuthentication getPasswordAuthentication() {
		return passAuth;
	}
	
}
