package array;

public class Ex4 {

	public static void main(String[] args) {
		/*
		 * 2차원 배열 
		 * 데이터타입[][] 변수명 = new 데이터타입[행크기][열크기]; 
		 * 데이터타입[][] 변수명 = { {값1,값2,...},{값1,값2,...},...,{값1,값2,...} };
		 */
		
		
//		int[][] arr;
//		arr = new int[3][2];
		int[][] arr = new int[3][2];
		
		arr[0][0] = 1;	arr[0][1] = 2;
		arr[1][0] = 3;	arr[1][1] = 4;
		arr[2][0] = 5;	arr[2][1] = 6;
		
		for(int i=0; i<arr.length; i++) {
			for(int j=0; j<arr[i].length; j++) {
				System.out.print(arr[i][j]+" ");
			}
			System.out.println();
		}
		
		System.out.println("---------------------------");
		
		int[][] arr2 = {
				{1, 2}, 
				{3, 4}, 
				{5, 6}
		};
		
		for(int i=0; i<arr2.length; i++) {
			for(int j=0; j<arr2[i].length; j++) {
				System.out.print(arr2[i][j]+" ");
			}
			System.out.println();
		}
		
		System.out.println("============================");
		
		String[][] names = {
				{"홍길동", "이순신", "강감찬"},
				{"김태희", "전지현", "송혜교"},
				{"유재석", "정우성", "조인성"}
		};
		
		for(int i=0; i<names.length; i++) {
			for(int j=0; j<names[i].length; j++) {
				System.out.print(names[i][j]+" ");
			}
			System.out.println();
		}
		
		System.out.println("=========================");
		//행 먼저 생성 후 열 각각 생성 가능
		//데이터타입[][] 배열명 = new 데이터타입[행크기][];
		//배열명[행번호] = new int[열크기];
		
		int[][] arr3 = new int[3][];
		
//		arr3[0] = new int[3];
//		arr3[1] = new int[2];
//		arr3[2] = new int[4];
//		
//		arr3[0][0] = 1; arr3[0][1] = 2; arr3[0][2] = 3;
//		arr3[1][0] = 1; arr3[1][1] = 2; 
//		arr3[2][0] = 1; arr3[2][1] = 2; arr3[2][2] = 3; arr3[2][3] = 4;
//		
		arr3[0] = new int[] {1, 2, 3};
		arr3[1] = new int[] {1, 2};
		arr3[2] = new int[] {1, 2, 3, 4};
		
		/*
		 * int[][] arr3 = {
		 *		{1, 2, 3},
		 *		{1, 2},
		 * 		{1, 2, 3, 4}
		 * };
		 */
		
		
		System.out.println("arr3 배열 크기 : " + arr3.length);
		
		for(int i=0; i<arr3.length; i++) {
			for(int j=0; j<arr3[i].length; j++) {
				System.out.print(arr3[i][j]+" ");
			}
			System.out.println();
		}
		
		
	}

}
