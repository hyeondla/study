
public class Test2 {

	public static void main(String[] args) {
		
		Vehicle v = new ElectricCar();
		v.addFuel();
		v.reprotPosition();
		
		v = new DieselCar();
		v.addFuel();
		v.reprotPosition();
		
	}

}

abstract class Vehicle {
	
	int curX, curY;
	
	public void reprotPosition() {
		System.out.println("현재 위치 : " + curX + ", " + curY);
	}
	
//	public void addFuel() {
//		System.out.println("자동차의 연료 공급");
//	}
	
	public abstract void addFuel();
	
}

class ElectricCar extends Vehicle {

	@Override
	public void addFuel() {
		System.out.println("전기차 충전소에서 배터리 충전");
	}
	
}

class DieselCar extends Vehicle {

	@Override
	public void addFuel() {
		System.out.println("주유소에서 디젤 연료 공급");
	}
	
}