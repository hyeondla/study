package string_class;

public class Test {

	public static void main(String[] args) {

		String jumin="900909-6234567";
		char genderNum = jumin.charAt(7);
		
		if(genderNum == '1' || genderNum == '3') {
			System.out.println("남성");
		} else if(genderNum == '2' || genderNum == '4') {
			System.out.println("여성");
		} else if(genderNum == '5' || genderNum == '6') {
			System.out.println("외국인");
		} else {
			System.out.println("잘못된 주민번호");
		}
		
		switch(genderNum) {
			case 1:
			case 3:	System.out.println("남성");	break;
			case 2:
			case 4:	System.out.println("여성");	break;
			case 5:
			case 6:	System.out.println("외국인"); break;
			default : System.out.println("잘못된 주민번호");
		}

		System.out.println("============================================");
		
		String address = "Address:부산광역시 부산진구 동천로109";
		System.out.println(address.substring(8));
	
		System.out.println("============================================");
		
		String address2 = "Address:부산광역시 부산진구 동천로109,Floor:7층,Tel:051-803-0909";
		String[] addArr = address2.split(",");
		for(int i=0; i<addArr.length; i++) {
//			System.out.println(addArr[i]);
//			String[] addArr2 = addArr[i].split(":");
//			System.out.print(addArr2[1] + " ");
			System.out.println(addArr[i].split(":")[1]); //1회성 접근
		}
		
		
		
	}

}
