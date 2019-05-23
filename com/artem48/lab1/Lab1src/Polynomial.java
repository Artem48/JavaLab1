import java.util.ArrayList;

public class Polynomial {
    private ArrayList<Fraction> data;

    public Polynomial(FractionCollection Collection) {
        data = new ArrayList<Fraction>();
        for (int i = 0; i < Collection.size(); i++) {
            data.add(Collection.get(i));
        }
    }

    public int size() {
        return data.size();
    }

    public Fraction get(int pos) {
        return data.get(pos);
    }

    public void sum(Polynomial y) {
        Polynomial ans;
        int i, j;
        if (this.size() > y.size()) {
            ans = this;
            j = y.data.size() - 1;
        } else {
            ans = y;
            j = this.data.size() - 1;
        }

        i = ans.data.size() - 1;
        while (true) {
            if (i < 0 || j < 0) break;
            int numeratorx,numeratory,denominatorx,denominatory;
            if (this.size() > y.size()) {
                numeratorx = this.data.get(i).numerator();
                numeratory = y.data.get(j).numerator();
                denominatorx = this.data.get(i).denominator();
                denominatory = y.data.get(j).denominator();
            } else {
                numeratorx = this.data.get(j).numerator();
                numeratory = y.data.get(i).numerator();
                denominatorx = this.data.get(j).denominator();
                denominatory = y.data.get(i).denominator();
            }

            int newdenominator = denominatorx * denominatory;
            int newnumerator = numeratorx * denominatory + numeratory * denominatorx;

            ans.data.get(i).setNumerator(newnumerator);
            ans.data.get(i).setDenominator(newdenominator);
            i--;
            j--;
        }
        this.data=ans.data;
    }
}
