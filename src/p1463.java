import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class p1463 {

    public static int sol(int x) {

        if (dp[x] == -1) {
            if (x % 6 == 0) {
                dp[x] = Math.min(sol(x / 3), Math.min(sol(x / 2), sol(x - 1))) + 1;
            } else if (x % 3 == 0) {
                dp[x] = Math.min(sol(x / 3), sol(x - 1)) + 1;
            } else if (x % 2 == 0) {
                dp[x] = Math.min(sol(x / 2), sol(x - 1)) + 1;
            }
            else
                dp[x] =  sol(x - 1) + 1;
        }

        return dp[x];
    }

    static int[] dp;

    public static void main(String[] args) throws IOException {

        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(bf.readLine());
        dp = new int[N + 1];

        for (int i = 0; i <= N; i++) {
            dp[i] = -1;
        }
        dp[0] = 0;
        dp[1] = 0;

        System.out.println(sol(N));
    }
}
