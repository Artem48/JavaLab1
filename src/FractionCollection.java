import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class FractionCollection {
    private ArrayList<Fraction> data;
    private Fraction maxValue, minValue;

    public FractionCollection() {
        data = new ArrayList<Fraction>();
        maxValue = new Fraction(Integer.MAX_VALUE, 1);
        minValue = new Fraction(Integer.MIN_VALUE, 1);
    }

    public Fraction MaxValue() {
        return maxValue;
    }

    public Fraction MinValue() {
        return minValue;
    }

    public int CountGreaterThan(Fraction x) {
        int count = 0;
        for (Fraction i : data) {
            if (i.GetValue() > x.GetValue()) count++;
        }
        return count;
    }

    public int CountLessThan(Fraction x) {
        int count = 0;
        for (Fraction i : data) {
            if (i.GetValue() < x.GetValue()) count++;
        }
        return count;
    }

    public void Add(int m, int n) {
        Fraction NewFraction = new Fraction(m, n);
        data.add(NewFraction);
        if (NewFraction.GetValue() > maxValue.GetValue())
            maxValue = NewFraction;
        if (NewFraction.GetValue() < minValue.GetValue())
            minValue = NewFraction;
    }

    public void Add(Fraction NewFraction) {
        data.add(NewFraction);
        if (NewFraction.GetValue() > maxValue.GetValue())
            maxValue = NewFraction;
        if (NewFraction.GetValue() < minValue.GetValue())
            minValue = NewFraction;
    }
    public Fraction get(int pos){
        return data.get(pos);
    }
    public int size(){
        return data.size();
    }

    public void AddFromFile(String Filename) {
        int[] array = null;
        try (BufferedReader in = new BufferedReader(new FileReader(Filename))) {
            array = in.lines().mapToInt(Integer::parseInt).toArray();
        } catch (IOException | NumberFormatException e) {
            e.printStackTrace();
        }
        if (array != null) {
            for (int i = 0; i < array.length; i += 2) {
                if(i+1<array.length)
                    this.Add(array[i], array[i+1]);
            }
        }
    }
}
