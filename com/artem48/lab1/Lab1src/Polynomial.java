import java.util.ArrayList;

public class Polynomial {
    private final FractionCollection coeffs;

    // primary ctor
    public Polynomial(FractionCollection Collection) {
        this.coeffs = Collection;
    }

    public int size() {
        return coeffs.size();
    }

    public Fraction get(int pos) {
        return coeffs.get(pos);
    }

    public static Polynomial sum(Polynomial x, Polynomial y) {
        Polynomial ans;
        int i, j;
        if (x.size() > y.size()) {
            ans = x;
            j = y.coeffs.size() - 1;
        } else {
            ans = y;
            j = x.coeffs.size() - 1;
        }

        i = ans.coeffs.size() - 1;
        while (true) {
            if (i < 0 || j < 0) break;
            int numeratorx, numeratory, denominatorx, denominatory;
            if (x.size() > y.size()) {
                numeratorx = x.coeffs.get(i).numerator();
                numeratory = y.coeffs.get(j).numerator();
                denominatorx = x.coeffs.get(i).denominator();
                denominatory = y.coeffs.get(j).denominator();
            } else {
                numeratorx = x.coeffs.get(j).numerator();
                numeratory = y.coeffs.get(i).numerator();
                denominatorx = x.coeffs.get(j).denominator();
                denominatory = y.coeffs.get(i).denominator();
            }

            int newdenominator = denominatorx * denominatory;
            int newnumerator = numeratorx * denominatory + numeratory * denominatorx;

            ans.coeffs.get(i).setNumerator(newnumerator);
            ans.coeffs.get(i).setDenominator(newdenominator);
            i--;
            j--;
        }
        return ans;
    }
}
