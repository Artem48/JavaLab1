import java.io.FileNotFoundException;

public class Lab1 {

    public static void main(String[] args) throws FileNotFoundException {
        FractionCollection FrCol = new FractionCollection("com/artem48/fract.txt");
        for(int i=0;i<FrCol.size();i++) {
            System.out.print(FrCol.get(i).GetValue());
            System.out.print(' ');
        }
        System.out.println();
        System.out.println(FrCol.MaxValue());
        System.out.println(FrCol.MinValue());
        System.out.println(FrCol.CountGreaterThan(new Fraction(5,3)));

        Polynomial polinom1=new Polynomial(FrCol);
        for(int i=0;i<polinom1.size();i++) {
            System.out.print(polinom1.get(i).GetValue());
            System.out.print(' ');
        }
        System.out.println();
        FrCol.Add(1,1);
        Polynomial polinom2=new Polynomial(FrCol);

        for(int i=0;i<polinom2.size();i++) {
            System.out.print(polinom2.get(i).GetValue());
            System.out.print(' ');
        }
        polinom1.sum(polinom2);
        System.out.println();
        for(int i=0;i<polinom1.size();i++) {
            System.out.print(polinom1.get(i).GetValue());
            System.out.print(' ');
        }

    }
}
