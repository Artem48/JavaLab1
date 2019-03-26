import java.util.ArrayList;

public class FractionCollection {
    private ArrayList<Fraction> data;
    private Fraction maxValue, minValue;
    public FractionCollection(){
        data=new ArrayList<Fraction>();

    }
    public Fraction MaxValue(){
        return maxValue;
    }
    public Fraction MinValue(){
        return minValue;
    }
    public int CountGreaterThan(Fraction x){
        int count=0;
        for(Fraction i: data){
            if(i.getValue()>x.getValue()) count++;
        }
        return count;
    }
    public int CountLessThan(Fraction x){
        int count=0;
        for(Fraction i: data){
            if(i.getValue()<x.getValue()) count++;
        }
        return count;
    }
    
}
