import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class p2739 {


    public static void main(String[] args) throws IOException {

        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int N = Integer.parseInt(bf.readLine());

        for(int i=1;i<=9; i++){
            int ans = N*i;
            System.out.print(N + " * " + i + " = " + ans);
            System.out.println();
        }

    }

}
