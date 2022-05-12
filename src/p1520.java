import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class p1520 {

    static int[][] arr, dp;
    static int N, M;
    static int[] dx = {0, 0, 1, -1};
    static int[] dy = {1, -1, 0, 0};

    public static int dfs(int i, int j) {

        if (i== N - 1 && j == M - 1) {
            return 1;
        }
        if (dp[i][j] == -1) {
            dp[i][j] = 0;

            for (int k = 0; k < 4; k++) {
                int nx = dx[k] + i;
                int ny = dy[k] + j;

                if (nx >= 0 && ny >= 0 && nx < N && ny < M) {
                    if (arr[nx][ny] < arr[i][j]) {
                            dp[i][j] += dfs(nx,ny);
                    }

                }
            }
        }
        return dp[i][j];
    }

    public static void main(String[] args) throws IOException {

        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        arr = new int[N][M];
        dp = new int[N][M];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(bf.readLine());
            for (int j = 0; j < M; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
                dp[i][j] = -1;
            }
        }


        System.out.println(dfs(0, 0));
    }
}
