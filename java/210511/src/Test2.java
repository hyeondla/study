
public class Test2 {

	public static void main(String[] args) {
		
		Manager m = new Manager("홍길동",5000,"개발팀");
		System.out.println(m.getManager());
		
	}

}

class Employee {
	
	String name;
	int salary;
	
	public String getEmployee() {
		return name + " " + salary;
	}
	
}

class Manager extends Employee {
	
	String depart;
	
	public Manager(String name, int salary, String depart) {
		this.name = name;
		this.salary = salary;
		this.depart = depart;
	}
	
	public String getManager() {
		String str = getEmployee() + " " + depart;
		return str;
	}
	
}
