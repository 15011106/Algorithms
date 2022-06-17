import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class p1003 {

    public static int fib(int n) {

        if (dp[n] == -1) {
            dp[n] = fib(n - 2) + fib(n - 1);
            oneCount[n] =  oneCount[n-1] + oneCount[n-2] ;
            zeroCount[n] = zeroCount[n-1] + zeroCount[n-2];
        }
        return dp[n];
    }


    static int[] dp;
    static int [] zeroCount;
    static int [] oneCount;

    public static void main(String[] args) throws IOException {

        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(bf.readLine());


        for (int i = 0; i < n; i++) {


            int temp = Integer.parseInt(bf.readLine());

            if (temp == 0) {
                System.out.println("1 0");
                continue;
            } else if (temp == 1) {
                System.out.println("0 1");
                continue;
            }

            dp = new int[temp + 1];
            zeroCount = new int [temp +1];
            oneCount = new int [temp +1];

            for (int x = 0; x <= temp; x++) {
                dp[x] = -1;
            }

            dp[0] = 0;
            dp[1] = 1;
            zeroCount[0]=1;
            zeroCount[1] = 0;
            oneCount[0] = 0;
            oneCount[1] = 1;

            if(temp>=2){
                zeroCount[2] = 1;
                oneCount[2] = 1;
            }

            fib(temp);

            System.out.println(zeroCount[temp] +" "+ oneCount[temp]);
        }
    }
}
