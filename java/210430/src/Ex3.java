
public class Ex3 {

	public static void main(String[] args) {

		PrintClass pc = new PrintClass();
		pc.print();
		System.out.println("----------------------------");
		pc.print("도도");
		System.out.println("----------------------------");
		pc.print("도도", "레레");
		System.out.println("----------------------------");
		pc.print("도도", "레레", "미미");

	}

}

class PrintClass {

	public void print() {
//		System.out.println("초대 멤버 : 없음, 없음, 없음");
		System.out.println("print() 호출");
		print("없음", "없음", "없음");
	}

	public void print(String name1) {
		System.out.println("print(String) 호출");
//		System.out.println("초대 멤버 : " + name1 + ", 없음, 없음");
		print(name1, "없음", "없음");
	}

	public void print(String name1, String name2) {
		System.out.println("print(String, String) 호출");
//		System.out.println("초대 멤버 : " + name1 + ", " + name2 + ", 없음");
		print(name1, name2, "없음");
	}

	public void print(String name1, String name2, String name3) {
		System.out.println("print(String, String, String) 호출");
		System.out.println("초대 멤버 : " + name1 + ", " + name2 + ", " + name3);
	}

}
