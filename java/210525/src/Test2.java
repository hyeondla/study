
public class Test2 {

	public static void main(String[] args) {
		BumbleBee bee = new BumbleBee();
		bee.fight();
		bee.speak();
		bee.transform(BumbleBee.MODE_NORMAL);
	}

}

interface Fightable {
	public abstract void fight();
}

interface Transformable {
	public static final int MODE_CAR = 1;
	public static final int MODE_AIRPLANE = 2;
	public static final int MODE_NORMAL = 3;
	
	
	public abstract void transform(int mode);
}

interface Robot extends Fightable, Transformable {
	public abstract void speak();
}

class BumbleBee implements Robot {

	@Override
	public void fight() {
		System.out.println("로켓 발사");
	}

	@Override
	public void transform(int mode) {
		if(mode == Transformable.MODE_NORMAL) {
			System.out.println("기본모드로 변신");
		} else if (mode == Transformable.MODE_CAR) {
			System.out.println("자동차로 변신");
		}
	}

	@Override
	public void speak() {
		System.out.println("라디오로 말하기");
	}
	
}
