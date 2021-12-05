import java.math.BigInteger;
import java.util.Scanner;

public class p1271 {

    public static void main(String[] args) {
        Scanner kb = new Scanner(System.in);
        BigInteger a = kb.nextBigInteger();
        BigInteger b = kb.nextBigInteger();
        kb.close();

        BigInteger Quotient = a.divide(b);
        BigInteger Mod = a.remainder(b);
        System.out.println(Quotient);
        System.out.println(Mod);
    }
}