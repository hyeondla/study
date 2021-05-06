
public class Ex5 {

	public static void main(String[] args) {

		MyDate md = new MyDate();
		System.out.printf("%d/%d/%d\n", md.year, md.month, md.day);

		System.out.println("-------------------------------------");

		MyDate md2 = new MyDate(2021);
		System.out.printf("%d/%d/%d\n", md2.year, md2.month, md2.day);

		System.out.println("------------------------------------");
		MyDate md3 = new MyDate(2030, 5);
		System.out.printf("%d/%d/%d\n", md3.year, md3.month, md3.day);
		System.out.println("------------------------------------");
		
		MyDate md4 = new MyDate(2040, 5, 6);
		System.out.printf("%d/%d/%d\n", md4.year, md4.month, md4.day);
		
	}

}

class MyDate {
	int year;
	int month;
	int day;

	public MyDate() {
		// 생성자 this() => 첫번째로 실행되어야 함
		this(1900, 1, 1);

		System.out.println("MyDate() 생성자 호출");
//		year = 1900;
//		month = 1;
//		day = 1;

//		this(1900,1,1);
		// 오류! Constructor call must be the first statement in a constructor
	}

	public MyDate(int year) {
		this(year, 1, 1);
		System.out.println("MyDate(int) 생성자 호출");
	}

	public MyDate(int year, int month) {
		this(year, month, 1);
		System.out.println("MyDate(int, int) 생성자 호출");
	}

	public MyDate(int year, int month, int day) {
		System.out.println("MyDate(int, int, int) 생성자 호출");
		this.year = year;
		this.month = month;
		this.day = day;
	}

}