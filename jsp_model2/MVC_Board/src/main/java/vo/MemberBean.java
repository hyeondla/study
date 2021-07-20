package vo;

public class MemberBean {
	/*
	 * CREATE TABLE member(
		idx INT PRIMARY KEY AUTO_INCREMENT,
		name VARCHAR(10) NOT NULL,
		id VARCHAR(12) UNIQUE NOT NULL,
		password VARCHAR(16) NOT NULL,
		email VARCHAR(50) UNIQUE NOT NULL	
	   );
	 * 
	 */
	
	private int idx;
	private String name;
	private String id;
	private String password;
	private String email;
	
	public int getIdx() {
		return idx;
	}
	public void setIdx(int idx) {
		this.idx = idx;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	
}
