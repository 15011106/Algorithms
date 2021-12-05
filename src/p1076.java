import java.math.BigInteger;
import java.util.Arrays;
import java.util.Scanner;

public class p1076 {

    public static void main(String[] args) {
        String [] list = {"black","brown","red","orange","yellow","green","blue","violet","grey","white"};
        Scanner kb = new Scanner(System.in);
        String a = kb.nextLine();
        String b = kb.nextLine();
        String c = kb.nextLine();
        kb.close();

        int aa = Arrays.asList(list).indexOf(a);
        int bb = Arrays.asList(list).indexOf(b);
        int cc = Arrays.asList(list).indexOf(c);

        String str1 = Integer.toString(aa);
        String str2 = Integer.toString(bb);
        String resistanceStr = str1 + str2;
        BigInteger resistance = new BigInteger(resistanceStr);


        BigInteger answer = resistance.multiply(BigInteger.valueOf(10).pow(cc));

        System.out.println(answer);
    }
}