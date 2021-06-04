package collection_framework;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class Test2 {

	public static void main(String[] args) {

		Set<Integer> thisWeekLotto = new HashSet<Integer>(Arrays.asList(7,8,11,13,15,23));
//		System.out.println("이번주 추첨 번호 : " + thisWeekLotto);
		
		int buy = 0;
		while(true) {
			Set<Integer> myLotto = new HashSet<Integer>();
			while(myLotto.size() != 6) {
				myLotto.add((int)(Math.random()*45) + 1);
			}
//			System.out.println("내 로또 번호 : " + myLotto);
			buy++;
			
			int count = 0;
			for(int o : thisWeekLotto) {
				if(myLotto.contains(o)) {
					count++;
				}
			}
			switch (count) {
				case 6: System.out.println("6개 일치 : 1등"); break;
				case 5: System.out.println("5개 일치 : 2등"); break;
				case 4: System.out.println("4개 일치 : 3등"); break;
				case 3: System.out.println("3개 일치 : 4등"); break;
				case 2: 
				case 1: 
				default: System.out.println(count + "개 일치 : 꽝"); 
			}
		
			if(count==6) {
				break;
			}
		}
		System.out.println(buy + "번째 구입에 1등 당첨");
		System.out.println(buy * 1000L + "원 사용");
	}

}
