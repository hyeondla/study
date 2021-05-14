
public class Ex2 {
	public static void main(String[] args) {
		
		SmartPhone sp = new SmartPhone("갤럭시", "010-1234-5678", "안드로이드");
		
		sp.call();
		sp.sms();
		sp.kakaoTalk();
		
		if(sp instanceof SmartPhone) {
			System.out.println("sp는 SmartPhone");
			SmartPhone phone = sp;
		}
		
		System.out.println("--------------------------");
		
		//업캐스팅 가능 대상 확인
		if(sp instanceof HandPhone) {

			System.out.println("sp는 HandPhone");
			System.out.println("=> 형변환 가능");
			System.out.println("sp는 HandPhone이 가진 모든 기능 포함");
			
			//sp -> HandPhone 타입으로 변환
			HandPhone hp = sp; //업캐스팅
			hp.call();
			hp.sms();
//			hp.kakaoTalk(); //오류! SmartPhone 기능 불가
			
		} else {
			System.out.println("sp는 HandPhone 아님");
		}
		
		System.out.println("--------------------------");
		
		//다운캐스팅 가능 대상 확인 (불가능)
		HandPhone h = new HandPhone("애니콜", "011-111-1111");
		
		if(h instanceof SmartPhone) {
			System.out.println("h는 SmartPhone");
		} else {
			System.out.println("h는 SmartPhone 아님");
		}
		
		System.out.println("--------------------------");
		
		//다운캐스팅 가능 대상 확인 (가능)
		HandPhone hp2 = new SmartPhone("갤럭시", "010-1234-5678", "안드로이드");
		hp2.call();
		hp2.sms();
//		hp2.kakaoTalk(); //오류!
		
		if(hp2 instanceof SmartPhone) {
			
			System.out.println("hp2는 SmartPhone");
			System.out.println("=> 형변환 가능");
			
//			SmartPhone sp2 = hp2; //자동 형변환 불가
			SmartPhone sp2 = (SmartPhone) hp2; //강제 형변환
			
			sp2.call();
			sp2.sms();
			sp2.kakaoTalk(); //SmartPhone 기능 사용 가능
			
		} else {
			System.out.println("hp2는 SmartPhone 아님");
		}
		
		System.out.println("================================");
		
		Child c = new Child();
		if(c instanceof Parent) {
			Parent p = c;
			p.parentPrn();
		}
		
		Parent p2 = new Parent();
		if(p2 instanceof Child) {
			Child c2 = (Child) p2;
			c2.parentPrn();
			c2.childPrn();
		}
		
	}
	
}

class HandPhone {
	
	String modelName;
	String phoneNumber;
	
	public HandPhone(String modelName, String phoneNumber) {
		super();
		this.modelName = modelName;
		this.phoneNumber = phoneNumber;
	}
	
	public void call() {
		System.out.println("전화 기능");
	}
	public void sms() {
		System.out.println("문자 기능");
	}
	
}

class SmartPhone extends HandPhone {
	
	String osName;

	public SmartPhone(String modelName, String phoneNumber, String osName) {
		super(modelName, phoneNumber);
		this.osName = osName;
	}
	
	public void kakaoTalk() {
		System.out.println("카톡 기능");
	}
	
}