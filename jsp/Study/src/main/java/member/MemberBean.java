package member;

import java.sql.Timestamp;

public class MemberBean {
	//데이터 담아서 전달
	
	//멤버변수
	private String id;
	private String pass;
	private String name;
	private Timestamp date;
	
	//멤버함수
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
