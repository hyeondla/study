
public class Test {

	public static void main(String[] args) {

		스마트폰 내폰 = new 스마트폰();
		
		내폰.전화();
		내폰.문자();
		내폰.카톡();
		
		핸드폰 어머니폰 = new 핸드폰();

		어머니폰.전화();
		어머니폰.문자();
		
		System.out.println("--------------------");
		
		//업캐스팅
		어머니폰 = 내폰; //자동 형변환
		
		어머니폰.전화();
		어머니폰.문자();
//		어머니폰.카톡(); //오류!
		//스마트폰을 핸드폰 타입으로 참조할 경우 기능 축소
		
		스마트폰 동생폰 = new 스마트폰();
		어머니폰 = 동생폰;
		
		어머니폰.전화();
		어머니폰.문자();
//		어머니폰.카톡(); //오류!
		
		//핸드폰 타입으로 여러 스마트폰 사용 가능
		
		System.out.println("========================");
		
		//다운캐스팅
		어머니폰 = new 스마트폰(); //스마트폰->핸드폰 업캐스팅
		
		내폰 = (스마트폰)어머니폰; //핸드폰->스마트폰 다운캐스팅
		//=> 강제형변환
		내폰.전화();
		내폰.문자();
		내폰.카톡();
		
	}

}

class 전화기 {
	
	public void 전화() {
		System.out.println("전화 걸기");
	}
	
}

class 핸드폰 extends 전화기 {
	
	public void 문자() {
		System.out.println("문자 전송");
	}
	
}

class 스마트폰 extends 핸드폰 {
	
	public void 카톡() {
		System.out.println("카톡 전송");
	}
	
}