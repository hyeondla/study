package array;

public class Ex3 {

	public static void main(String[] args) {

		int total = 0;
		int[] arr = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
		
		for(int i=0; i<arr.length; i++) {
			total += arr[i];
		}
		
		System.out.println(total);
		
		System.out.println("===================================");
		
		int oddTotal = 0;
		int evenTotal = 0;
		
		for(int i=0; i<arr.length; i++) {
			if(arr[i]%2 == 1) {
				oddTotal += arr[i];
			} else {
				evenTotal += arr[i];
			}
		}
		
		System.out.println("배열 내 홀수의 합 = " + oddTotal);
		System.out.println("배열 내 짝수의 합 = " + evenTotal);
		
		System.out.println("======================================");
		
		int[] array = {1, 5, 3, 8, 7};
		
		int max = array[0];
		int min = array[0];
		
		for(int i=1; i<array.length; i++) {
			
			if(array[i] > max) {
				max = array[i];
			} else if(array[i] < min) {
				min = array[i];
			}
			
		}
		
		System.out.println("max = " + max);
		System.out.println("min = " + min);
		
		
		
	}

}
