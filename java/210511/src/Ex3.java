
public class Ex3 {

	public static void main(String[] args) {
		
	}

}


class Engine {
	int cc = 3000;
}

class Car { //has-a

	Engine engine = new Engine();
	
	String modelName = "그랜져";
	
	public void showCarInfo() {
		System.out.println("모델명 : " + modelName);
		//포함 관계 -> 해당 클래스의 인스턴스를 통해 접근
		System.out.println("배기량 : " + engine.cc);
	}
	
}

class FireEngine extends Car { //is-a
	
	int supplyLimit = 10000;
	
	public void showFireEngineInfo() {
		System.out.println("급수량 : " + supplyLimit);
		System.out.println("모델명 : " + modelName);
		//부모와 포함관계인 객체의 멤버에 접근
		System.out.println("배기량 : " + engine.cc);
	}
	
}