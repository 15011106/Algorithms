import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class p11726 {

    public static int sol(int x) {

        if (dp[x] == -1) {
            dp[x] = sol(x - 2) + sol(x - 1);
        }

        return dp[x] % 10007;
    }

    static int[] dp;

    public static void main(String[] args) throws IOException {

        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(bf.readLine());
        int ans;

        dp = new int[N + 1];
        for (int i = 0; i <= N; i++) {
            dp[i] = -1;
        }

        dp[0] = 0;
        dp[1] = 1;
        if (N >= 2) {
            dp[2] = 2;
        }

        ans = sol(N);
        System.out.println(ans);
    }
}
