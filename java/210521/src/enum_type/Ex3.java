package enum_type;

public class Ex3 {

	public static void main(String[] args) {
		
		Month2 now = Month2.MAY;
		System.out.println(now + ", " + now.getMonthKor());
		
	}

}

enum Month2 {
	
	//생성자 사용시 상수에 다른 값 결합 가능
	JANUARY("1월"), FEBRUARY("2월"), MARCH("3월"), APRIL("4월"), MAY("5월"), JUNE("6월"), JULY("7월");
	
	private String monthKor;
	
	//초기화
	Month2(String monthKor) {
		this.monthKor = monthKor;
	}

	public String getMonthKor() {
		return monthKor;
	}

	public void setMonthKor(String monthKor) {
		this.monthKor = monthKor;
	}
	
	
	
}