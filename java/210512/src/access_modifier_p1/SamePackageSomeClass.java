package access_modifier_p1;

public class SamePackageSomeClass {
	
	public void useMember() {
		
		ParentClass p = new ParentClass();
		
		p.publicVar = 10;
		p.protectedVar = 20;
		p.defaultVar = 30;
//		p.privateVar = 40; //다른 클래스에서 접근 불가
		
	}
	
}
