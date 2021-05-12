package access_modifier_p2;

import access_modifier_p1.ParentClass;

public class OtherPackageSomeClass {

	public void useMember() {

		ParentClass p = new ParentClass();

		p.publicVar = 10;
//		p.protectedVar = 20; //패키지가 다르고 상속단계가 아님
//		p.defaultVar = 30; //다른 패키지에서 접근 불가
//		p.privateVar = 40; //다른 클래스에서 접근 불가

	}

}
