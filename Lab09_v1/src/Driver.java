import java.util.Random;

public class Driver {

	public static void main(String[] args) {
		int N = new Random().nextInt(10);
		System.out.println(N);
		System.out.println(new Calculator().sumFractions(N));
	}
}
