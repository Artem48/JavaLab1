import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class FractionCollection {
    public List<Fraction> data;
    private Fraction maxValue, minValue;

    public FractionCollection() {
        data = new ArrayList<Fraction>();
        maxValue = new Fraction(Integer.MAX_VALUE, 1);
        minValue = new Fraction(Integer.MIN_VALUE, 1);
    }

    public FractionCollection(String Filename) throws FileNotFoundException {
        data = new ArrayList<Fraction>();
        maxValue = new Fraction(Integer.MIN_VALUE, 1);
        minValue = new Fraction(Integer.MAX_VALUE, 1);
        addFromFile(Filename);
    }


    static FractionCollection fromFile(String filename) {

        FractionCollection col=new FractionCollection();
        ArrayList<Integer> l = new ArrayList<>();
        Scanner scanner = null;
        try {
            scanner = new Scanner(new File(filename));
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        while (scanner.hasNextInt()) {
            l.add(scanner.nextInt());
        }
        if (l.size() > 0) {
            for (int i = 0; i < l.size(); i += 2) {
                if (i + 1 < l.size()) {
                    Fraction temp=new Fraction(l.get(i), l.get(i + 1));
                    col.data.add(temp);
                }
            }
        }
        return col;
    }

    public double maxValue() {
        return maxValue.getValue();
    }

    public double minValue() {
        return minValue.getValue();
    }

    public int countGreaterThan(Fraction x) {
        int count = 0;
        for (Fraction i : data) {
            if (i.compareTo(x)>0) count++;
        }
        return count;
    }

    public int countLessThan(Fraction x) {
        int count = 0;
        for (Fraction i : data) {
            if (i.getValue() < x.getValue()) count++;
        }
        return count;
    }

    public void add(int m, int n) {
        Fraction NewFraction = new Fraction(m, n);
        data.add(NewFraction);
        if (NewFraction.getValue() > maxValue.getValue())
            maxValue = NewFraction;
        if (NewFraction.getValue() < minValue.getValue())
            minValue = NewFraction;
    }

    public void add(Fraction NewFraction) {
        data.add(NewFraction);
        if (NewFraction.getValue() > maxValue.getValue())
            maxValue = NewFraction;
        if (NewFraction.getValue() < minValue.getValue())
            minValue = NewFraction;
    }

    public Fraction get(int pos) {
        return data.get(pos);
    }

    public int size() {
        return data.size();
    }

    public void addFromFile(String filename) throws FileNotFoundException {
        FractionCollection add=fromFile(filename);
        for(int i=0;i<add.size();i++)
            this.data.add(add.get(i));

    }
}
