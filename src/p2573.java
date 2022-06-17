import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class p2573 {
    static int[] dx = {0, 0, 1, -1};
    static int[] dy = {1, -1, 0, 0};
    static int[][] arr;
    static int N, M;
    static boolean[][] visited;
    static boolean[][] meltVisited;

    static void melt() {

        int cnt = 0;

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {

                if (arr[i][j] != 0) {
                    meltVisited[i][j] = true;

                    for (int x = 0; x < 4; x++) {
                        int nx = dx[x] + i;
                        int ny = dy[x] + j;

                        if (arr[nx][ny] == 0 && !meltVisited[nx][ny]) {
                            cnt++;
                        }
                    }

                    arr[i][j] = arr[i][j] - cnt;
                    if (arr[i][j] < 0) {
                        arr[i][j] = 0;
                    }
                }
                cnt = 0;
            }
        }
    }


    static void dfs(int x, int y) {

        visited[x][y] = true;

        for (int i = 0; i < 4; i++) {
            int nx = dx[i] + x;
            int ny = dy[i] + y;

            if (nx >= 0 && ny >= 0 && nx < N && ny < M) {
                if (arr[nx][ny] != 0 && !visited[nx][ny]) {
                    dfs(nx, ny);
                }
            }
        }
    }

    static int isSeparation() {

        int cnt = 0;

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {

                if (arr[i][j] != 0 && !visited[i][j]) {
                    cnt++;
                    dfs(i, j);
                }
            }
        }

        return cnt;
    }

    static boolean isDone() {

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (arr[i][j] != 0)
                    return false;
            }
        }

        return true;
    }


    public static void main(String[] args) throws IOException {

        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        arr = new int[N][M];
        visited = new boolean[N][M];
        meltVisited = new boolean[N][M];
        int ans = 0;
        boolean flag = false;

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(bf.readLine());
            for (int j = 0; j < M; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        while (!isDone()) {

            visited = new boolean[N][M];
            meltVisited = new boolean[N][M];

            ans++;

            melt();
            int temp = isSeparation();

            if (temp >= 2) {
                System.out.println(ans);
                flag = true;
                break;
            }
        }

        if (!flag) {
            System.out.println("0");
        }
    }

}
