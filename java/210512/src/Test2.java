
public class Test2 {

	public static void main(String[] args) {

		ElectricCar e = new ElectricCar();
		e.speed = 80;
		e.maxSpeed = 240;
		e.batteryCapacity = 10000;
		e.speedUP();
		e.speedDown();
		e.addFuel();
		
		System.out.println("---------------------------------------");
		
		DieselCar d = new DieselCar();
		d.speed = 60;
		d.maxSpeed = 280;
		d.cc = 2000;
		d.speedUP();
		d.speedDown();
		d.addFuel();
		
	}

}

class Car {
	
	int speed;
	int maxSpeed;
	
	public void speedUP() {
		System.out.println("자동차 속력 증가");
	}
	
	public void speedDown() {
		System.out.println("자동차 속력 감소");
	}
	
	public void addFuel() {
		System.out.println("자동차 연료 주입");
	}
	
}

class ElectricCar extends Car {
	
	int batteryCapacity;

	@Override
	public void speedUP() {
		System.out.println("전기 모터의 힘으로 속력 증가 -> " + maxSpeed + "km/h");
	}

	@Override
	public void speedDown() {
		System.out.println("속력 감소하면서 전기배터리 충전 -> " + speed + "km/h");
	}

	@Override
	public void addFuel() {
		System.out.println("전기 충전소에서 배터리 충전");
	}
	
	
	
}

class DieselCar extends Car {
	
	int cc;

	@Override
	public void speedUP() {
		System.out.println("디젤 엔진의 힘으로 속력 증가 -> " + maxSpeed + "km/h");
	}

	@Override
	public void speedDown() {
		System.out.println("디젤 자동차 속력 감소 -> " + speed + "km/h");
	}

	@Override
	public void addFuel() {
		System.out.println("주유소에서 연료 주입");
	}
	
	
}