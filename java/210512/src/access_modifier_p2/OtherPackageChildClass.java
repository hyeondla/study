package access_modifier_p2;

import access_modifier_p1.ParentClass;

public class OtherPackageChildClass extends ParentClass {

	public void useMember() {

		this.publicVar = 10;
		this.protectedVar = 20; //다른 패키지지만 상속 관계이므로 접근 가능
//		this.defaultVar = 30; //다른 패키지에서 접근 불가
//		this.privateVar = 40; //다른 클래스에서 접근 불가
		
		//--------------------------------------------------------------------------
		
		ParentClass p = new ParentClass();
		//=> 인스턴스 생성 후 참조변수를 통해 접근 => has-a 관계
		p.publicVar = 10;
//		p.protectedVar = 20; //다른 패키지, 상속관계X => 접근 불가
//		p.defaultVar = 30; //다른 패키지 => 접근 불가
//		p.privateVar = 40; //다른 클래스에서 => 접근 불가

	}
	
}
