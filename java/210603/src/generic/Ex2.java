package generic;

import java.util.ArrayList;
import java.util.List;

public class Ex2 {

	public static void main(String[] args) {

		// static 메서드 내에서 제네릭 타입 파라미터 사용 불가
		
		// new 연산자 사용 시 제네릭 타입 파라미터 사용 불가
		
		// instanceof 연산자 사용 시 제네릭 타입 파라미터 사용 불가
		
		List<String> list = new ArrayList<String>();
		
	}

}

// 제네릭 타입 상속, 구현
class Class1<P> {}
interface Interface1<Q> {}

// 부모 타입에 제네릭 타입 지정
// 서브클래스에서 상속 시 부모 타입 파라미터를 서브클래스 타입 파라미터로 명시
class SubClass<P, Q> extends Class1<P> implements Interface1<Q> {
	P var1;
	Q var2;
}
