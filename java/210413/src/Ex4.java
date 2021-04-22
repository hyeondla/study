
public class Ex4 {

	public static void main(String[] args) {

		/*
		for(int i=2; i<=9; i++) {
			
			System.out.println("< " + i + "단 >");
//			if(i == 5 ) {
//				continue;
//			}
			
			for(int j=1; j<=9; j++) {

				if(i == 5) {
					break;
				}
				
				System.out.printf("%d * %d = %d\n", i, j, i*j);
			}
			System.out.println("-------------");
			
		}
		*/
		
		/*
		 * Label
		 * - 반복문 앞에 위치
		 * - break / continue 동작 지점 지정
		 * - 중첩 반복문에서 반복문을 한꺼번에 빠져나가기 위해 사용
		 */
		
		EXIT_FOR: //레이블
		for(int i=2; i<=9; i++) {
			
			System.out.println("< " + i + "단 >");

			for(int j=1; j<=9; j++) {

				if(i == 5) {
					break EXIT_FOR; //EXIT_FOR 레이블을 찾아 해당 반복문 종료
//					continue EXIT_FOR; //EXIT_FOR 레이블을 찾아 다음 반복문 진행
				}
				
				System.out.printf("%d * %d = %d\n", i, j, i*j);
			}
			System.out.println("-------------");
			
		}
		
		
		
	}

}
