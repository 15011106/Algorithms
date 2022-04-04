import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class p14502 {
    static int N;
    static int M;
    static int[][] arr;
    static int[] dx = {0, 0, -1, 1};
    static int[] dy = {1, -1, 0, 0};
    static int answer = 0;

    public static void makeWall(int depth, int start) {


        if (depth == 3) {
            int[][] arrCopy = new int[N][M];
            for (int i = 0; i < N; i++) {
                System.arraycopy(arr[i], 0, arrCopy[i], 0, M);
            }
            int x = spread(arrCopy);
            if (answer < x) {
                answer = x;
            }

        } else {
            for (int i = start; i < N * M; i++) {
                int x = i / M;
                int y = i % M;
                if (arr[x][y] == 0) {
                    arr[x][y] = 1;
                    makeWall(depth + 1, start + 1);
                    arr[x][y] = 0;
                }
            }
        }
    }

    public static int spread(int[][] spreadMap) {
        Queue<int[]> queue = new LinkedList<>();

        boolean[][] visited = new boolean[N][M];

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (spreadMap[i][j] == 2) {
                    int[] coor = {i, j};
                    queue.offer(coor);
                }
            }
        }
        while (!queue.isEmpty()) {
            int[] a = queue.poll();
            for (int k = 0; k < 4; k++) {
                int nx = dx[k] + a[0];
                int ny = dy[k] + a[1];
                if (nx >= 0 && ny >= 0 && nx < N && ny < M) {
                    if (spreadMap[nx][ny] == 0 && !visited[nx][ny]) {
                        visited[nx][ny] = true;
                        spreadMap[nx][ny] = 2;
                        queue.offer(new int[]{nx, ny});

                    }
                }
            }
        }
        int cnt = 0;
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (spreadMap[i][j] == 0) {
                    cnt++;
                }
            }
        }
        return cnt;
    }


    public static void main(String[] args) throws IOException {


        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        arr = new int[N][M];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(bf.readLine());
            for (int j = 0; j < M; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        makeWall(0, 0);
        System.out.println(answer);
    }
}