import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class p1149 {

    static int[][] dp;
    static int[][] rgb;

    public static int sol(int x, int color) {

        if (dp[x][color] == 0) {

            if (color == 0)
                dp[x][color] = Math.min(sol(x - 1, 1), sol(x - 1, 2)) + rgb[x][color];

            else if (color == 1)
                dp[x][color] = Math.min(sol(x - 1, 0), sol(x - 1, 2)) + rgb[x][color];

            else if (color == 2)
                dp[x][color] = Math.min(sol(x - 1, 1), sol(x - 1, 0)) + rgb[x][color];

        }

        return dp[x][color];
    }

    public static void main(String[] args) throws IOException {

        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int ans=0;
        int n = Integer.parseInt(bf.readLine());

        dp = new int[n][3];
        rgb = new int[n][3];

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(bf.readLine());
            for (int j = 0; j < 3; j++) {
                rgb[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        dp[0][0] = rgb[0][0];
        dp[0][1] = rgb[0][1];
        dp[0][2] = rgb[0][2];

        ans = Math.min(Math.min(sol(n-1,0),sol(n-1,1)),sol(n-1,2));

        System.out.println(ans);
    }
}
