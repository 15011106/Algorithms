import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class p2579 {
    static int[] dp, arr;

    static int sol(int x) {

        if (dp[x] == -1) {
            dp[x] = Math.max(sol(x - 3) + arr[x - 1], sol(x - 2)) + arr[x];
        }
        return dp[x];
    }

    public static void main(String[] args) throws IOException {

        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(bf.readLine());

        arr = new int[N + 1];
        dp = new int[N + 1];

        for (int i = 1; i <= N; i++) {
            arr[i] = Integer.parseInt(bf.readLine());
        }

        for (int i = 1; i <= N; i++) {
            dp[i] = -1;
        }

        dp[1] = arr[1];
        if(N >= 2) {
            dp[2] = arr[1] + arr[2];
        }

        System.out.println(sol(N));
    }
}
