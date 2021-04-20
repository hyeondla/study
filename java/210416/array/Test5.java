package array;

public class Test5 {

	public static void main(String[] args) {

		String[] names = {"홍길동", "이순신", "강감찬", "김태희", "전지현"};
		int[][] score = {
				{80, 70, 80},
				{90, 90, 90},
				{50, 60, 77},
				{100, 100, 100},
				{80, 80, 60}
		};
		int[] studentTotal = new int[names.length];
		
		System.out.println("< 학생 점수표 >");
		System.out.println("         국어  영어  수학");
		  
		for(int i=0; i<score.length; i++) {
			System.out.print(names[i] + " ");
			for(int j=0; j<score[i].length; j++) {
				System.out.printf(" %4d ", score[i][j]);
				studentTotal[i] += score[i][j];
			}
			System.out.println();
		}
		
		System.out.println("--------------------------");
		
		System.out.println("< 학생별 총점 >");
		for(int i=0; i<names.length; i++) {
			System.out.println(names[i] + " : " + studentTotal[i] + "점");
		}
		
	}

}
