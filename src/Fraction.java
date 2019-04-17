public class Fraction {
    private int m,n;
    public Fraction(){
        m=1;
        n=1;
    }
    public Fraction(int x,int y){
        m=x;
        n=y;
    }
    public int first(){
        return m;
    }
    public int second(){
        return n;
    }
    public int numerator(){
        return m;
    }
    public int denominator(){
        return n;
    }
    public double GetValue(){
        return (double) m/n;
    }
}
