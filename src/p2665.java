import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class p2665 {

    static class Node implements Comparable<Node> {

        int x;
        int y;
        int w;

        public Node(int x, int y, int w) {
            this.x = x;
            this.y = y;
            this.w = w;
        }

        @Override
        public int compareTo(Node o) {
            return w - o.w;
        }
    }

    static int[] dx = {0, 0, 1, -1};
    static int[] dy = {1, -1, 0, 0};
    static int[][] arr;
    static int[][] dist;
    static int INF = Integer.MAX_VALUE;
    static int N;

    public static void dijkstra(int x, int y) {
        PriorityQueue<Node> pq = new PriorityQueue<>();

        if (arr[x][y] == 1) {
            pq.offer(new Node(x, y, 1));
        } else
            pq.offer(new Node(x, y, 0));

        while (!pq.isEmpty()) {
            Node curNode = pq.poll();
            int curX = curNode.x;
            int curY = curNode.y;
            int curW = curNode.w;

            for (int i = 0; i < 4; i++) {
                int nx = dx[i] + curX;
                int ny = dy[i] + curY;

                if (nx >= 0 && ny >= 0 && nx < N && ny < N) {
                    if (dist[nx][ny] > curW + arr[nx][ny]) {
                        dist[nx][ny] = curW + arr[nx][ny];
                        pq.offer(new Node(nx, ny, dist[nx][ny]));
                    }
                }
            }
        }

        if(dist[N-1][N-1] ==0) {
            System.out.println("0");
        }
        else
            System.out.println(dist[N-1][N-1]);
    }

    public static void main(String[] args) throws IOException {

        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        N = Integer.parseInt(bf.readLine());

        arr = new int[N][N];
        dist = new int[N][N];

        for (int i = 0; i < N; i++) {
            Arrays.fill(dist[i], INF);
        }

        for (int i = 0; i < N; i++) {
            String temp = bf.readLine();
            for (int j = 0; j < N; j++) {
                if(Integer.parseInt(String.valueOf(temp.charAt(j))) ==1)
                    arr[i][j] = 0;
                else
                    arr[i][j] = 1;
            }
        }

        dijkstra(0, 0);
    }
}
