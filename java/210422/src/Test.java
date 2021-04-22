
public class Test {

	public static void main(String[] args) {
		
		//1. 파라미터 X, 리턴값 X
		printHello();
		
		System.out.println("-----------------");
		
		gugudan();
		
		System.out.println("=================================");
		
		//2. 파라미터 X, 리턴값 O
		int total = sum();
		System.out.println("1 ~ 10 정수의 합 = " + total);
		System.out.println("----------------------");
		
//		String weather = getWeather();
//		System.out.println("오늘의 날씨 : " + weather);
		System.out.println("오늘의 날씨 : " + getWeather());
		
		
	}
	
	public static void printHello() {
		
		for(int i=0; i<10; i++) {
			System.out.println("Hello, World!");
		}
		
	}
	
	public static void gugudan() {
		
		for(int i=2; i<=9; i++) {
			System.out.println("< " + i + "단 >");
			for(int j=1; j<=9; j++) {
				System.out.printf("%d * %d = %d\n", i, j, i*j);
			}
		}
		
	}
	
	//======================================================
	
	public static int sum() {
		int total = 0;
		for(int i=1; i<=10; i++) {
			total += i;
		}
		return total;
	}
	
	public static String getWeather() {
//		return "흐림";
		
		String weather = "흐림";
		return weather;
	}
	
	
}
