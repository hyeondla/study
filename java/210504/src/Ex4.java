
public class Ex4 {

	public static void main(String[] args) {

		// this => 자신의 인스턴스 주소값을 저장, 참조 변수

		// 1.레퍼런스 this
		// 자신의 인스턴스 내의 멤버에 접근

		// 2.생성자 this()
		// 자신의 생성자 내에서 또 다른 자신의 생성자 호출

		Person4 p = new Person4("홍길동", 20);
		p.showPersonInfo();

		p.setName("이순신");
		p.setAge(44);
		p.showPersonInfo();

	}

}

class Person4 {
	private String name;
	private int age;

	public Person4(String name, int age) {
		this.name = name;
		this.age = age;
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

	public void showPersonInfo() {
		System.out.println("이름 : " + name + ", 나이 : " + age);
	}
}
