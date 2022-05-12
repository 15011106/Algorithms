import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class p6087 {

    static int[][] dist;
    static char[][] arr;
    static int W, H;
    static int INF = Integer.MAX_VALUE;
    static int[] dx = {0, 0, 1, -1};
    static int[] dy = {1, -1, 0, 0};
    static int startX, startY, endX, endY;

    static class Node implements Comparable<Node> {

        int x;
        int y;
        int mirror;
        int dir;

        public Node(int x, int y, int mirror, int dir) {

            this.x = x;
            this.y = y;
            this.mirror = mirror;
            this.dir = dir;
        }

        public int compareTo(Node o) {
            return mirror - o.mirror;
        }

    }

    public static void dijkstra(int startX, int startY) {
        PriorityQueue<Node> pq = new PriorityQueue<>();
        pq.offer(new Node(startX, startY, 0, 4));

        while (!pq.isEmpty()) {
            Node curNode = pq.poll();

            int curX = curNode.x;
            int curY = curNode.y;

            if (curX == endX && curY == endY) {
                return;
            }

            for (int i = 0; i < 4; i++) {

                int nx = dx[i] + curX;
                int ny = dy[i] + curY;

                if (nx >= 0 && ny >= 0 && nx < H && ny < W) {
                    if (arr[nx][ny] != '*') {
                        if (curNode.dir == 4 || curNode.dir == i) {
                            if (dist[nx][ny] >= curNode.mirror) {
                                dist[nx][ny] = curNode.mirror;
                                pq.offer(new Node(nx, ny, curNode.mirror, i));

                            }
                        } else {
                            if (dist[nx][ny] >= curNode.mirror + 1) {
                                dist[nx][ny] = curNode.mirror + 1;
                                pq.offer(new Node(nx, ny, curNode.mirror + 1, i));
                            }
                        }
                    }
                }
            }

        }
    }

    public static void main(String[] args) throws IOException {

        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine());

        W = Integer.parseInt(st.nextToken());
        H = Integer.parseInt(st.nextToken());

        dist = new int[H][W];
        arr = new char[H][W];
        boolean flag = false;

        for (int i = 0; i < H; i++) {
            Arrays.fill(dist[i], INF);
        }

        startX = 0;
        startY = 0;
        endX = 0;
        endY = 0;

        for (int i = 0; i < H; i++) {
            String temp = bf.readLine();
            for (int j = 0; j < W; j++) {
                char tempChar = temp.charAt(j);

                if (tempChar == 'C' && !flag) {
                    startX = i;
                    startY = j;
                    flag = true;
                } else if (tempChar == 'C') {
                    endX = i;
                    endY = j;
                }

                arr[i][j] = tempChar;
            }
        }

        dijkstra(startX, startY);

        System.out.println(dist[endX][endY]);

    }
}
