import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class p9461 {
    static Long sol(int n) {

        if (dp[n] == -1) {
            dp[n] = sol(n - 1) + sol(n - 5);
        }
        return dp[n];
    }

    static long[] dp;

    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(bf.readLine());

        for (int i = 0; i < N; i++) {

            int t = Integer.parseInt(bf.readLine());
            dp = new long[t + 1];
            for (int j=0; j<=t ;j++){
                dp[j] = -1;
            }

            dp[0] = 0;
            dp[1] = 1;
            if (t >= 2) {
                dp[2] = 1;
            }
            if(t >=3){
                dp[3] = 1;
            }
            if(t>=4){
                dp[4] = 2;
            }

            if(t>=5){
                sol(t);
            }

            System.out.println(dp[t]);

        }
    }
}
