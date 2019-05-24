import java.io.FileNotFoundException;

public class Lab1 {

    public static void main(String[] args) throws FileNotFoundException {
        FractionCollection FrCol = new FractionCollection("com/artem48/fract.txt");
        FractionCollection FrCol2 = new FractionCollection("com/artem48/fract.txt");
        for (int i = 0; i < FrCol.size(); i++) {
            System.out.print(FrCol.get(i).getValue());
            System.out.print(' ');
        }
        System.out.println();
        System.out.println(FrCol.maxValue());
        System.out.println(FrCol.minValue());
        System.out.println(FrCol.countGreaterThan(new Fraction(5, 3)));

        Polynomial polinom1 = new Polynomial(FrCol);
        for (int i = 0; i < polinom1.size(); i++) {
            System.out.print(polinom1.get(i).getValue());
            System.out.print(' ');
        }
        System.out.println();
        FrCol2.add(1, 1);
        Polynomial polinom2 = new Polynomial(FrCol2);

        for (int i = 0; i < polinom2.size(); i++) {
            System.out.print(polinom2.get(i).getValue());
            System.out.print(' ');
        }
        Polynomial ans=Polynomial.sum(polinom1, polinom2);
        System.out.println();
        for (int i = 0; i < ans.size(); i++) {
            System.out.print(ans.get(i).getValue());
            System.out.print(' ');
        }

    }
}
