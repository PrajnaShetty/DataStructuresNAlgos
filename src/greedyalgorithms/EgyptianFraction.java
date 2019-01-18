package greedyalgorithms;

/**
 * Created by prajnashetty on 1/13/19.
 *
 * Every positive fraction can be represented as sum of unique unit fractions.
 * A fraction is unit fraction if numerator is 1 and denominator is a positive integer, for example 1/3 is a unit fraction.
 * Such a representation is called Egyptian Fraction as it was used by ancient Egyptians.

 Following are few examples:
 Egyptian Fraction Representation of 2/3 is 1/2 + 1/6
 Egyptian Fraction Representation of 6/14 is 1/3 + 1/11 + 1/231
 Egyptian Fraction Representation of 12/13 is 1/2 + 1/3 + 1/12 + 1/156

 We can generate Egyptian Fractions using Greedy Algorithm.
 For a given number of the form ‘nr/dr’ where dr > nr, first find the greatest possible unit fraction,
 then recur for the remaining part. For example, consider 6/14, we first find ceiling of 14/6, i.e., 3.
 So the first unit fraction becomes 1/3, then recur for (6/14 – 1/3) i.e., 4/42.
 */
public class EgyptianFraction {



    public static void main(String[] args) {

        int nr = 6, dr = 14;
        System.out.print("Egyption Fraction for " + nr + "/" + dr + " = " );
        printEgyptianFraction(nr, dr);


        System.out.println();
        nr = 12; dr = 13;
        System.out.print("Egyption Fraction for " + nr + "/" + dr + " = " );
        printEgyptianFraction(nr, dr);

        System.out.println();
        nr = 5; dr = 8;
        System.out.print("Egyption Fraction for " + nr + "/" + dr + " = " );
        printEgyptianFraction(nr, dr);

    }

    private static void printEgyptianFraction(int nr, int dr) {
        if (nr == 0 || dr == 0)
            return;

        if (dr % nr == 0) {
            System.out.print("1/" + dr/nr);
            return;
        }

        if (nr % dr == 0) {
            System.out.print(nr/dr);
            return;
        }

        if (nr > dr) {
            System.out.print(nr/dr + " + ");
            printEgyptianFraction(nr % dr, dr);
            return;
        }


        //dr > nr
        int n = dr/nr + 1;
        System.out.print(" 1/" + n + " + ");
        printEgyptianFraction(nr * n -  dr, dr * n);

    }
}
