import java.util.ArrayList;

public class Polynomial {
    private ArrayList<Fraction> data;

    public Polynomial(FractionCollection Collection) {
        for (int i = 0; i < Collection.size(); i++) {
            data.add(Collection.get(i));
        }
    }

    public double sum() {
        double sum=0;
        for(Fraction i : data){
            sum+=i.GetValue();
        }
        return sum;
    }
}
