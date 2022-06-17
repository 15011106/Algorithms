import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class p2156 {


    static Integer[] dp;
    static int[] arr;

    static int sol(int n) {

        if (dp[n] == null) {
            dp[n] = Math.max(Math.max(sol(n - 3) + arr[n - 1], sol(n - 2)) + arr[n], sol(n - 1));
        }

        return dp[n];
    }

    public static void main(String[] args) throws IOException {

        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(bf.readLine());
        arr = new int[N + 1];
        dp = new Integer[N + 1];

        for (int i = 1; i <= N; i++) {
            arr[i] = Integer.parseInt(bf.readLine());
        }
        dp[0] = 0;
        dp[1] = arr[1];

        if(N>=2){
            dp[2] = arr[1]+arr[2];
        }

        System.out.println(sol(N));
    }
}
