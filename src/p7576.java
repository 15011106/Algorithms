import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class p7576 {

    static int N, M;
    static int[][] arr;
    static boolean[][] visited;
    static int[] nx = {0, 0, -1, 1};
    static int[] ny = {1, -1, 0, 0};

    public static int bfs() {

        int max = 0;
        Queue<int[]> queue = new LinkedList<>();
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (arr[i][j] == 1) {
                    int[] coor = {i, j};
                    queue.offer(coor);
                }
            }
        }

        while (!queue.isEmpty()) {
            int[] temp = queue.poll();
            for (int i = 0; i < 4; i++) {
                int dx = nx[i] + temp[0];
                int dy = ny[i] + temp[1];
                if (dx >= 0 && dy >= 0 && dx < N && dy < M) {
                    if (arr[dx][dy] == 0 && !visited[dx][dy]) {
                        arr[dx][dy] = arr[temp[0]][temp[1]]+1;
                        visited[dx][dy] = true;
                        queue.offer(new int[]{dx, dy});
                    }
                }
            }
        }
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (arr[i][j] == 0) {
                    return -1;
                }
                if (max<arr[i][j]) {
                    max = arr[i][j];
                }
            }
        }
        return max-1;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine());
        M = Integer.parseInt(st.nextToken());
        N = Integer.parseInt(st.nextToken());
        int cntZero = 0;
        int cntOne = 0;

        visited = new boolean[N][M];
        arr = new int[N][M];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(bf.readLine());
            for (int j = 0; j < M; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                int x = arr[i][j];
                if (x == 0)
                    cntZero++;
                else if (x == 1)
                    cntOne++;
            }
        }

        if (cntOne > 0 && cntZero == 0) {
            System.out.println(0);
        } else {
            System.out.println(bfs());

        }
    }
}
