package array;

public class Ex2 {

	public static void main(String[] args) {

		/*
		 * 데이터타입[] 변수명 = {데이터1, 데이터2, ... , 데이터n}; 
		 *                           ㄴ 해당 데이터 갯수(n)만큼 배열 공간 자동 생성
		 */

		int[] arr = {1, 2, 3, 4, 5};
		// 리터럴 지정하여 저장공간 생성시 추가적인 데이터 저장 불가
		
		for(int i=0; i<arr.length; i++) {
			System.out.println(arr[i]);
		}

		int[] arr2;
//		arr2 = {1, 2, 3, 4, 5}; //=>오류 
		arr2 = new int[]{1, 2, 3, 4, 5}; //배열 크기 지정 X		
		
		System.out.println("----------------------------------");
		
		String[] strArr = {"Java", "JSP", "Android"};
		
		for(int i=0; i<strArr.length; i++) {
			System.out.println(strArr[i]);
		}
		
		System.out.println("==================================");
		
		int[] a = {1, 2, 3};
		int[] b = {4, 5, 6};
		int[] c = {7, 8, 9};
		
		a = b; //b의 주소값을 a에 저장 => 기존 a 저장 공간은 더 이상 참조되지 않으므로 GC에 의해 정리
		
		
	}

}
