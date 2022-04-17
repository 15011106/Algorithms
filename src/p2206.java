import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class p2206 {

    static int[] dx = {0, 0, -1, 1};
    static int[] dy = {-1, 1, 0, 0};
    static boolean[][][] visited;
    static int n, m;
    static int[][] arr;
    static int temp = -1;
    static int[][] dist;

    static void bfs() {

        Queue<int[]> queue = new LinkedList<>();
        queue.offer(new int[]{0, 0, 0});
        visited[0][0][0] = true;
        visited[1][0][0] = true;

        while (!queue.isEmpty()) {
            int[] pos = queue.poll();

            for (int k = 0; k < 4; k++) {
                int nx = dx[k] + pos[0];
                int ny = dy[k] + pos[1];

                if (nx >= 0 && ny >= 0 && nx < n && ny < m) {
                    if (arr[nx][ny] == 1) {
                        if (!visited[1][nx][ny] && pos[2] == 0) {
                            visited[1][nx][ny] = true;
                            arr[nx][ny] = arr[pos[0]][pos[1]] + 1;
                            queue.offer(new int[]{nx, ny, 1});

                        }
                    } else if (arr[nx][ny] == 0 && !visited[pos[2]][nx][ny]) {
                        visited[pos[2]][nx][ny] = true;
                        arr[nx][ny] = arr[pos[0]][pos[1]] + 1;
                        queue.offer(new int[]{nx, ny, pos[2]});
                    }

                    if (nx == n - 1 && ny == m - 1) {
                        temp = dist[n - 1][m - 1] + 1;
                        return;
                    }
                }

            }
        }
    }


    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        dist = new int[n][m];
        arr = new int[n][m];
        visited = new boolean[2][n][m];

        for (int i = 0; i < n; i++) {
            String temp = bf.readLine();
            for (int j = 0; j < m; j++) {
                arr[i][j] = Character.getNumericValue(temp.charAt(j));
            }
        }

        if(n == 1 && m==1){
            System.out.println(1);
        }
        else{
            bfs();
            System.out.println(temp);
        }

    }
}
