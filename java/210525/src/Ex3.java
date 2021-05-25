
public class Ex3 {

	public static void main(String[] args) {
		
		PrintClient pc = new PrintClient();
		pc.setPrinter(new LaserPrinter());
		pc.print("Hello.java");
		
		pc.setPrinter(new InkjetPrinter());
		pc.print("Hello.java");
		
		pc.setPrinter(new DotPrinter());
		pc.print("Hello.java");
		
	}

}

class PrintClient {

	private Printer printer;

	public void setPrinter(Printer printer) {
		this.printer = printer;
	}
	
	public void print(String fileName) {
		printer.print(fileName);
	}
	
}


//---------------------------------------------------------------------

interface Printer {
	public abstract void print(String fileName);
}

class LaserPrinter implements Printer {
	@Override
	public void print(String fileName) {
		System.out.println("레이저프린터로 " + fileName + " 출력");	
	}
}

class InkjetPrinter implements Printer {
	@Override
	public void print(String fileName) {
		System.out.println("잉크젯프린터로 " + fileName + " 출력");	
	}
}

class DotPrinter implements Printer {
	@Override
	public void print(String fileName) {
		System.out.println("도트프린터로 " + fileName + " 출력");	
	}
}

