
public class Ex2 {

	public static void main(String[] args) {

		Point3D p3 = new Point3D();
		p3.print3D();
		
	}

}

class Point2D{ 
	
	int x = 10;
	int y = 20;
	
	public void print2D() {
		
		System.out.println("x좌표 = " + x + ", y좌표 = " + y);
	
	}	
}

class Point3D extends Point2D{
	int z = 30;
	
	public void print3D() {
		
//		System.out.println("x좌표 = " + x + " y좌표 = " + y + " z좌표 = " + z);
		print2D();
		System.out.println("z좌표 : " + z);
		
	}
}