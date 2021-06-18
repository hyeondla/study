import java.math.BigDecimal;
import java.math.BigInteger;

public class Ex {

	public static void main(String[] args) {
		
		BigInteger bi = new BigInteger("123456789012345678901234567890");
		BigInteger bi2 = new BigInteger("99999");
		bi = bi.subtract(bi2);
		System.out.println(bi);
		
		BigDecimal bd = new BigDecimal("2.0");
		BigDecimal bd2 = new BigDecimal("1.1");
		System.out.println(bd.subtract(bd2));
		
		
	}

}
