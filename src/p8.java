import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class p8 {
    public static void main (String [] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        String s= bf.readLine().toLowerCase().replaceAll("[^a-z]","");
        String rs = new StringBuilder(s).reverse().toString();
        if (s.equals(rs)){
            System.out.println("YES");
        }
        else{
            System.out.println("NO");
        }

    }
}
