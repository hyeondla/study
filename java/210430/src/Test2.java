
public class Test2 {

	public static void main(String[] args) {
		
		MyDate mydate1 = new MyDate();
		mydate1.showDateInfo();
		System.out.println("---------------------------");
		MyDate mydate2 = new MyDate(2030);
		mydate2.showDateInfo();
		System.out.println("---------------------------");
		MyDate mydate3 = new MyDate(2040, 7);
		mydate3.showDateInfo();
		System.out.println("---------------------------");
		MyDate mydate4 = new MyDate(2050, 12, 31);
		mydate4.showDateInfo();
		
	}

}

class MyDate {
	
	int year, month, day;

	public MyDate() {
		System.out.println("MyDate() 생성자 호출");
		year = 2021;
		month = 4;
		day = 30;
	}

	public MyDate(int year) {
		System.out.println("MyDate(int) 생성자 호출");
		this.year = year;
		month = 4;
		day = 30;
	}

	public MyDate(int year, int month) {
		System.out.println("MyDate(int, int) 생성자 호출");
		this.year = year;
		this.month = month;
		day = 30;
		
	}

	public MyDate(int year, int month, int day) {
		System.out.println("MyDate(int, int, int) 생성자 호출");
		this.year = year;
		this.month = month;
		this.day = day;
	}
	
	public void showDateInfo() {
		System.out.printf("%4d년 %2d월 %2d일\n", year, month, day);
	}
	
	
	
	
}