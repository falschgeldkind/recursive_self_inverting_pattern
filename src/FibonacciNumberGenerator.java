public class FibonacciNumberGenerator extends NumberGenerator{

    static final double PHI = (1 + Math.sqrt(5)) / 2;
    @Override
    int getNumber(int position) {
        return (int) (Math.pow(PHI, position) - ( Math.pow(-1, position) / Math.pow(PHI, position) ) / Math.sqrt(5));
    }
}
