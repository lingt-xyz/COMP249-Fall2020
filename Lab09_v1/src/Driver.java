import java.util.Random;

public class Driver {

	public static void main(String[] args) {
		
		Random  Ra  = new Random();
		
	//	int x=2;
	//	int y=7;
		int N = Ra.nextInt(7+1-5)+5;
		
		
		//Calculator calc = new Calculator();
		Calculator calc1 = new Calculator();
				
	//	int answer = calc.power(x,y);
		
		double frac = calc1.sumFractions(4);
		
		//System.out.println(answer);
		
		System.out.println(frac);
		

	}


}
