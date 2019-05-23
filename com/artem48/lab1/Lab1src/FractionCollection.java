import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;

public class FractionCollection {
    private ArrayList<Fraction> data;
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
        AddFromFile(Filename);
    }

    public double MaxValue() {
        return maxValue.GetValue();
    }

    public double MinValue() {
        return minValue.GetValue();
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

    public void AddFromFile(String Filename) throws FileNotFoundException {
        ArrayList<Integer> array = new ArrayList<Integer>();
        Scanner scanner = new Scanner(new File(Filename));
        while(scanner.hasNextInt()){
            array.add(scanner.nextInt());
        }

        if (array.size()>0) {
            for (int i = 0; i < array.size(); i += 2) {
                if(i+1<array.size())
                    this.Add(array.get(i), array.get(i+1));
            }
        }

    }
}
