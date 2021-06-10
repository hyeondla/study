package jdbc;

public class MemberDTO {
	
	private int idx;
	private String name;
	private int age;
	private String gender;
	private String jumin;
	
	public MemberDTO() {}
	
	public MemberDTO(int idx, String name, int age, String gender, String jumin) {
		super();
		this.idx = idx;
		this.name = name;
		this.age = age;
		this.gender = gender;
		this.jumin = jumin;
	}

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

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public String getJumin() {
		return jumin;
	}

	public void setJumin(String jumin) {
		this.jumin = jumin;
	}

}
