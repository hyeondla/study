package array;

public class Ex {
	
	public static void main(String[] args) {
	
//		int score1 = 90, score2 = 60, score3 = 80, score4 = 100, score5 = 50;
//		int scoreTotal = score1 + score2 + score3 + score4 + score5;

//		int[] score;
//		score = new int[5];
		
		int[] score = new int[5];

//		System.out.println(score); //주소값 출력
		
		System.out.println(score[0]);
		System.out.println(score[1]);
		System.out.println(score[2]);
		System.out.println(score[3]);
		System.out.println(score[4]);
		//=> 기본값(0)으로 자동 초기화
//		System.out.println(score[5]); //실행 시 오류 발견됨
		
		System.out.println("-----------------");
		
		score[0] = 90;
		score[1] = 100;
		score[2] = 80;
		score[3] = 70;
		score[4] = 50;
		
		/*
		 * for(int i=0; i<5; i++) { System.out.println(score[i]); }
		 */
		
		System.out.println("배열 score의 크기 : " + score.length);
		
		for(int i=0; i<score.length; i++) {
			System.out.println(i + "번 인덱스 : " + score[i]);
		}
		
		System.out.println("=====================");
		
		int[] arr1, arr2; //int[], int[]
		
		int arr3, arr4[]; //int, int[]
		
		
		
		
	}
	
}
