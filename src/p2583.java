import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.StringTokenizer;

public class p2583 {
    static int[][] arr;
    static boolean[][] visited;
    static int[] dx = {1, -1, 0, 0};
    static int[] dy = {0, 0, 1, -1};
    static int N, M;
    static int temp = 0;

    static void dfs(int x, int y) {

        visited[x][y] = true;
        temp++;

        for (int i = 0; i < 4; i++) {
            int nx = dx[i] + x;
            int ny = dy[i] + y;

            if (nx >= 0 && ny >= 0 && nx < M && ny < N) {
                if (!visited[nx][ny] && arr[nx][ny] == 0) {
                    dfs(nx, ny);
                }
            }
        }
    }

    ;

    public static void main(String[] args) throws IOException {

        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine());

        M = Integer.parseInt(st.nextToken());
        N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        int cnt = 0;
        ArrayList<Integer> territory = new ArrayList<>();
        arr = new int[M][N];
        visited = new boolean[M][N];

        for (int i = 0; i < M; i++) {
            for (int j = 0; j < N; j++) {
                arr[i][j] = 0;
            }
        }

        for (int i = 0; i < K; i++) {
            st = new StringTokenizer(bf.readLine());
            int lX = Integer.parseInt(st.nextToken());
            int lY = Integer.parseInt(st.nextToken());
            int rX = Integer.parseInt(st.nextToken());
            int rY = Integer.parseInt(st.nextToken());

            for (int y = lY; y < rY; y++) {
                for (int x = lX; x < rX; x++) {
                    arr[y][x] = 1;
                }
            }

        }

        for (int i = 0; i < M; i++) {
            for (int j = 0; j < N; j++) {
                if (!visited[i][j] && arr[i][j] == 0) {
                    cnt++;
                    dfs(i, j);
                    territory.add(temp);
                    temp = 0;
                }
            }
        }

        System.out.println(cnt);
        territory.sort(Comparator.naturalOrder());
        for(int x :territory){
            System.out.print(x+" ");
        }
    }
}
