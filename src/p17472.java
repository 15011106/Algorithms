import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class p17472 {

    static class Node implements Comparable<Node> {
        int s;
        int d;
        int w;

        public Node(int s, int d, int w) {
            this.s = s;
            this.d = d;
            this.w = w;
        }

        public int compareTo(Node o) {
            return w - o.w;
        }
    }

    static int find(int x) {

        if (x == parent[x])
            return parent[x];

        else {
            parent[x] = find(parent[x]);
            return parent[x];
        }

    }

    static void union(int x, int y) {

        x = find(x);
        y = find(y);

        if (x < y) {
            parent[y] = x;
        } else {
            parent[x] = y;
        }
    }

    static void countingIsland(int x, int y, int c) {

        visited[x][y] = true;
        arr[x][y] = c;

        for (int i = 0; i < 4; i++) {
            int nx = dx[i] + x;
            int ny = dy[i] + y;

            if (nx >= 0 && ny >= 0 && nx < N && ny < M) {
                if (arr[nx][ny] == 1 && !visited[nx][ny]) {
                    countingIsland(nx, ny, c);
                }
            }
        }
    }

    static void makeXBridge(int x, int y, int c) {

        int cnt = -1;

        for (int i = y + 1; i < M; i++) {
            cnt++;

            if (arr[x][i] == c) {
                break;
            }

            if (arr[x][i] != 0) {
                if (cnt > 1) {
                    pq.add(new Node(c, arr[x][i], cnt));
                }
                break;
            }
        }
        cnt = -1;

        for (int i = y - 1; i >= 0; i--) {
            cnt++;
            if (arr[x][i] == c) {
                break;
            }

            if (arr[x][i] != 0) {
                if (cnt > 1) {
                    pq.add(new Node(c, arr[x][i], cnt));
                }
                break;

            }
        }

    }

    static void makeYBridge(int x, int y, int c) {

        int cnt = -1;

        for (int i = x + 1; i < N; i++) {
            cnt++;

            if (arr[i][y] == c) {
                break;
            }

            if (arr[i][y] != 0) {
                if (cnt > 1) {
                    pq.add(new Node(c, arr[i][y], cnt));
                }
                break;
            }
        }

        cnt = -1;

        for (int i = x - 1; i >= 0; i--) {
            cnt++;
            if (arr[i][y] == c) {
                break;
            }
            if (arr[i][y] != 0) {
                if (cnt > 1) {
                    pq.add(new Node(c, arr[i][y], cnt));
                }
                break;
            }
        }
    }

    static PriorityQueue<Node> pq;
    static int[] dx = {0, 0, 1, -1};
    static int[] dy = {1, -1, 0, 0};
    static int[][] arr;
    static int N, M;
    static int[] parent;
    static boolean[][] visited;

    public static void main(String[] args) throws IOException {

        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        visited = new boolean[N][M];
        pq = new PriorityQueue<>();
        boolean isAble = true;
        int ans = 0;

        int island = 1;
        arr = new int[N][M];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(bf.readLine());
            for (int j = 0; j < M; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (arr[i][j] == 1 && !visited[i][j]) {
                    countingIsland(i, j, island);
                    island++;
                }
            }
        }

        parent = new int[island];

        for (int i = 0; i <= island - 1; i++) {
            parent[i] = i;
        }

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (arr[i][j] != 0) {
                    makeXBridge(i, j, arr[i][j]);
                    makeYBridge(i, j, arr[i][j]);
                }
            }
        }

        while (!pq.isEmpty()) {

            Node x = pq.poll();
            if (find(x.s) != find(x.d)) {
                union(x.s, x.d);
                ans += x.w;
            }
        }

        int commonParent = find(1);
        for(int i=1; i<island; i++){
            if(find(i) !=commonParent){
                System.out.println(-1);
                isAble = false;
                break;
            }
        }

        if(isAble){
            System.out.println(ans);
        }
    }
}
