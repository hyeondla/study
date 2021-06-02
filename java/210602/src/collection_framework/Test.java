package collection_framework;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Test {

	public static void main(String[] args) {

		Set<Integer> myLotto = new HashSet<Integer>();
		
		while(myLotto.size() != 6) {
			myLotto.add((int)(Math.random()*45) + 1);
		}
		System.out.println("내 로또 번호 : " + myLotto);
		
		List<Integer> lotto = Arrays.asList(7,8,11,13,15,23);
		Set<Integer> thisWeekLotto = new HashSet<Integer>(lotto);
		System.out.println("이번주 추첨 번호 : " + thisWeekLotto);
		
		int count = 0;
		for(Object o : thisWeekLotto) {
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
		
	}

}
