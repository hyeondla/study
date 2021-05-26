
public class Ex {

	public static void main(String[] args) {
		
		//Object클래스
		
		Person p1 = new Person("홍길동", "123456-1234567");
		Person p2 = new Person("홍길동", "123456-1234567");

		System.out.println("p1 객체 정보 : " + p1);
		System.out.println("p2 객체 정보 : " + p2);
		
		
		//============== 참조변수 동등비교 =================
		
		if(p1 == p2) { //동등비교
			System.out.println("주소값이 같음");
		} else {
			System.out.println("주소값이 다름");
		}
		
		if(p1.equals(p2)) { //동일한 결과
			System.out.println("주소값이 같음");
		} else {
			System.out.println("주소값이 다름");
		}
		
		System.out.println("-----------------------------------");
		
		Person p3 = p2;
		System.out.println("p2 객체 정보 : " + p2);
		System.out.println("p3 객체 정보 : " + p3);
		
		if(p3 == p2) { //동등비교
			System.out.println("주소값이 같음");
		} else {
			System.out.println("주소값이 다름");
		}
		
		if(p3.equals(p2)) { //동일한 결과
			System.out.println("주소값이 같음");
		} else {
			System.out.println("주소값이 다름");
		}
	
		System.out.println("=====================================");
		
		OverridePerson p5 = new OverridePerson("홍길동", "123456-1234567");
		OverridePerson p6 = new OverridePerson("홍길동", "123456-1234567");

		if(p5 == p6) { 
			System.out.println("주소값이 같음");
		} else {
			System.out.println("주소값이 다름");
		}
		
		if(p5.equals(p6)) {
			System.out.println("두 객체의 멤버변수 값이 같음");
		} else {
			System.out.println("두 객체의 멤버변수 값이 다름");
		}
		
		
		
	}

}

class Person {
	String name;
	String jumin;
	
	public Person(String name, String jumin) {
		super();
		this.name = name;
		this.jumin = jumin;
	}
}

class OverridePerson {
	String name;
	String jumin;
	
	public OverridePerson(String name, String jumin) {
		super();
		this.name = name;
		this.jumin = jumin;
	}

	//단축키 alt + shift + s -> h
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		OverridePerson other = (OverridePerson) obj;
		if (jumin == null) {
			if (other.jumin != null)
				return false;
		} else if (!jumin.equals(other.jumin))
			return false;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		return true;
	}
	
//	@Override
//	public boolean equals(Object obj) {
//		
//		if(obj instanceof OverridePerson) {
//			OverridePerson p = (OverridePerson)obj;
//			
//			if(name.equals(p.name) && jumin.equals(p.jumin)) {
//				return true;
//			} 
//			
//		}
//		
//		return false;
//	}
	
	
}