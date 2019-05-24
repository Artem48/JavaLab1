import static java.lang.Math.abs;

public class Fraction implements Comparable<Fraction> {
    private int m, n;

    public Fraction(int x, int y) {
        m = x;
        n = y;
    }


    public int numerator() {
        return m;
    }

    public int denominator() {
        return n;
    }

    public double getValue() {
        return (double) m / n;
    }

    public void setNumerator(int newm) {
        m = newm;
    }

    public void setDenominator(int newn) {
        n = newn;
    }

    @Override
    public int compareTo(Fraction o) {
        if(abs(this.getValue()-o.getValue())<1e5)
            return 0;
        else if(this.getValue()-o.getValue()>0)
            return 1;
        return -1;
    }
}
