package jdbc;


public class JDBC_Member_Management {

	public JDBC_Member_Management() {
		insert();
	}
	
	public void insert() {
		String name = "김태희";
		int age = 35;
		String gender = "여";
		String jumin = "811111-2222222";
		
		MemberDTO dto = new MemberDTO(0, name, age, gender, jumin);
		MemberDAO dao = new MemberDAO();
		int count = dao.insert(dto);
		System.out.println(count + "개 insert 성공");
	}
	
	
	public void delete() {
		
	}
	
	public void select() {
		
	}
	
	public static void main(String[] args) {
		
		new JDBC_Member_Management();
		
	}

}
