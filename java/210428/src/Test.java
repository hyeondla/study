
public class Test {

	public static void main(String[] args) {

		Person p = new Person();
		p.name = "홍길동";
		p.age = 20;
		p.isHungry = false;

//		System.out.println(p.name);
//		System.out.println(p.age);
//		System.out.println(p.isHungry);
		p.showPersonInfo();
		System.out.println("--------------");

		p.talk();
		System.out.println("--------------");

		p.eat("샌드위치");

	}
}

class Person {

	String name;
	int age;
	boolean isHungry;

	public void showPersonInfo() {
		System.out.println("이름 : " + name);
		System.out.println("나이 : " + age);
		System.out.println("배고픔 : " + isHungry);
	}

	public void eat(String foodName) {
		System.out.println(foodName + " 먹기");
		isHungry = false;
		System.out.println("식사 후 배고픔 : " + isHungry);
	}

	public void talk() {
		System.out.println("말하기");
		isHungry = true;
		System.out.println("말한 후 배고픔 : " + isHungry);
	}

}