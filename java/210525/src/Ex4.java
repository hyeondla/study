
public class Ex4 {

	public static void main(String[] args) {
		
		Ex4 ex = new Ex4();
		
		ex.noRelationship();
		
		System.out.println("------------------");
		
		ex.hasRelationship();
		
	}

	public void noRelationship() {
		NoteBookPc notebook = new NoteBookPc();
		SmartPhone smartphone = new SmartPhone();
	
		Object[] objArr = {notebook, smartphone};
		for(int i=0; i<objArr.length; i++) {
			if(objArr[i] instanceof NoteBookPc) {
				//Object -> NoteBookPc 다운캐스팅
				NoteBookPc newNotebook = (NoteBookPc)objArr[i];
				newNotebook.charge();
			} else if(objArr[i] instanceof SmartPhone) {
				//Object -> SmartPhone 다운캐스팅
				SmartPhone newSmartphone = (SmartPhone)objArr[i];
				newSmartphone.charge();
			}
		}
	}
	
	public void hasRelationship() {
//		Chargeable c = new NoteBookPc2(); //업캐스팅
//		Chargeable c2 = new SmartPhone2(); //업캐스팅
		Chargeable[] cArr = {new NoteBookPc2(), new SmartPhone2()};
		//공통메서드 charge() 호출 가능
		for(int i=0; i<cArr.length; i++) {
			cArr[i].charge();
		}
	}
	
	
}

//공통 인터페이스
//-> 아무 관계도 없는 두 클래스가 서로 상속 관계로 묶임
interface Chargeable {
	public abstract void charge();
}

class NoteBookPc2 extends Pc implements Chargeable {
	@Override
	public void charge() {
		System.out.println("노트북 충전 중...");
	}
}

class SmartPhone2 extends HandPhone implements Chargeable {
	@Override
	public void charge() {
		System.out.println("스마트폰 충전 중...");
	}
}

//=================================================================

class Pc {}

class NoteBookPc extends Pc {
	public void charge() {
		System.out.println("노트북 충전 중...");
	}
}

class HandPhone {}

class SmartPhone extends HandPhone {
	public void charge() {
		System.out.println("스마트폰 충전 중...");
	}
}
