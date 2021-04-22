package array;

public class Test {

	public static void main(String[] args) {
		
		int[] arr = new int[5];
		//기본값 0
		
		arr[0] = 11;
		arr[1] = 22;
		arr[2] = 33;
		arr[4] = 55;
		
		for(int i=0; i<arr.length; i++) {
			System.out.println(arr[i]);
		}
		
		System.out.println("=====================");
		
		boolean[] arr2 = new boolean[3];
		//기본값 false
		
		arr2[1] = true;
		
		for(int i=0; i<arr2.length; i++) {
			System.out.println(arr2[i]);
		}
		
		System.out.println("=====================");
		
		String[] arr3 = new String[3];
		
		arr3[0] = "홍길동";
		arr3[1] = "이순신";
		//기본값 null
		
		for(int i=0; i<arr3.length; i++) {
			System.out.println(arr3[i]);
		}
		
		System.out.println("=====================");
		
		double[] arr4 = new double[5];
		
		arr4[0] = 968513.56543423;
		arr4[1] = 7657.32432954;
		arr4[3] = -3482834.3853;
		arr4[4] = 0.38485;
		//기본값 0.0
		
		for(int i=0; i<arr4.length; i++) {
			System.out.println(arr4[i]);
		}
	
		
	}
	

}
