package array;

public class Test4 {

	public static void main(String[] args) {

			int[][] array = {
					{95, 86},
					{83, 92, 96},
					{78, 83, 93, 87, 88}
			};
			
			int sum = 0, count = 0;
			double avg = 0.0;
			
			for(int i=0; i<array.length; i++) {
				for(int j=0; j<array[i].length; j++) {
					sum += array[i][j];
					count++;
				}
			}
			
			avg = (double)sum / count;
			
			System.out.println(sum);
			System.out.println(avg);
			
			System.out.println("============================");
			
			int[] coinUnit = {500, 100, 50, 10};
			
			int money = 5020, cnt;
			System.out.println("money = " + money);
			
			for(int i=0; i<coinUnit.length; i++) {
				cnt = money / coinUnit[i];
				money -= coinUnit[i] * cnt;
				
				System.out.printf("%d원 : %d\n", coinUnit[i], cnt);
			}
			
	}

	
}
