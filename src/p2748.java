import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class p2748 {

    static long[] dp;

    public static long fib(int x) {
        if (dp[x] == -1) {
            dp[x] = fib(x - 1) + fib(x - 2);
        }
        return dp[x];

    }

    public static void main(String[] args) throws IOException {

        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(bf.readLine());

        dp = new long[N + 1];

        for (int i = 0; i <= N; i++) {
            dp[i] = -1;
        }

        dp[0] = 0;
        dp[1] = 1;

        System.out.println(fib(N));


    }
}
