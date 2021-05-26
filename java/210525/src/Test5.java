
public class Test5 {

	public static void main(String[] args) {
		
		Photoshop p = new Photoshop();
		
		p.draw(new Circle());
		p.draw(new Rectangle());
		
		System.out.println("-------------------------------------");
		
		Car car = new Taxi();
		car.speedUp();
		car.speedDown();
		
		if(car instanceof Taxi) {
			Taxi t = (Taxi)car;
			t.lift();
			t.drop();
		}
		
		car = new Truck();
		car.speedUp();
		car.speedDown();
		
		if(car instanceof Truck) {
			Truck tr = (Truck)car;
			tr.dump();
		}
		
	}

}

interface Shape {
	public abstract void draw();
}

class Circle implements Shape {
	
	private double radius = 3.0;
	
	public void setRadius(double radius) {
		this.radius = radius;
	}

	@Override
	public void draw() {
		System.out.println("원 그리기 -> 반지름 " + radius);
	}
	
}

class Rectangle implements Shape {
	
	private double line1Length = 2.0;
	private double line2Length = 1.5;
	
	public void setLine1Length(double line1Length) {
		this.line1Length = line1Length;
	}

	public void setLine2Length(double line2Length) {
		this.line2Length = line2Length;
	}

	@Override
	public void draw() {
		System.out.println("사각형 그리기 -> 가로 " + line1Length + " 세로 " + line2Length);
	}
	
}

class Photoshop {
	
	public void draw(Shape s) { //Shape로 업캐스팅
		s.draw();
	}
	
}

//---------------------------------------------------------------------------------------

interface Car {
	public abstract void speedUp();
	public abstract void speedDown();
}

class Taxi implements Car {

	@Override
	public void speedUp() {
		System.out.println("택시 속력 증가");
	}

	@Override
	public void speedDown() {
		System.out.println("택시 속력 감소");
	}
	
	public void lift() {
		System.out.println("택시 승객 탑승");
	}
	
	public void drop() {
		System.out.println("택시 승객 하차");
	}
	
}

class Truck implements Car {

	@Override
	public void speedUp() {
		System.out.println("트럭 속력 증가");
	}

	@Override
	public void speedDown() {
		System.out.println("트럭 속력 감소");
	}
	
	public void dump() {
		System.out.println("트럭 덤프");
	}
	
}

