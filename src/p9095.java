import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class p9095 {

    static int[] dp;

    static int sol(int x) {

        if (dp[x] == -1) {
            dp[x] = sol(x - 1) + sol(x - 2) + sol(x - 3);
        }

        return dp[x];
    }

    public static void main(String[] args) throws IOException {

        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(bf.readLine());


        for (int i = 0; i < N; i++) {

            int temp = Integer.parseInt(bf.readLine());

            dp = new int[temp + 1];

            for (int j= 0; j <= temp; j++) {
                dp[j] = -1;
            }

            dp[0] = 0;
            dp[1] = 1;

            if (temp >= 2) {
                dp[2] = 2;
            }

            if (temp >= 3) {
                dp[3] = 4;
            }
            System.out.println(sol(temp));

        }

    }

}
