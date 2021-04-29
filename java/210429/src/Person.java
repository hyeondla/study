
public class Person {

	// 외부에서 멤버 변수에 접근 불가능
	private String name;
	private int age;

	// Getter -> 파라미터 X, 리턴값 O
	public String getName() {
		return name;
	}

	public int getAge() {
		return age;
	}

	// Setter -> 파라미터 O, 리턴값 X

	public void setName(String name) {
		this.name = name;
	}

	public void setAge(int age) {
		this.age = age;
	}

}
