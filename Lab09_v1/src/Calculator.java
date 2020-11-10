public class Calculator {

    public int power(int x, int n) {

        if (n == 0) {
            return 1;
        } else {
            return (x * power(x, n - 1));
        }
    }

    public double sumFractions(int B) {
        if (B == 0) {
            return 1;
        } else {
            return 1.0 / power(2, B) + sumFractions(B - 1);
        }
    }

}
