
public class Ex {

	public static void main(String[] args) {

		Person p = new Person();

//		p.name = "홍길동"; //=> not visible
//		p.age = 20; //=> not visible

		p.setName("홍길동");
		p.setAge(20);

		System.out.println("이름 : " + p.getName());
		System.out.println("나이 : " + p.getAge());

	}

}