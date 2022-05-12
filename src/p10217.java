import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class p10217 {

    static class Node implements Comparable<Node> {

        int v;
        int c;
        int d;

        public Node(int v, int c, int d) {
            this.v = v;
            this.c = c;
            this.d = d;
        }

        public int compareTo(Node o) {
            return c - o.c;
        }
    }

    static ArrayList<Node>[] list;
    static int[][] dist;
    static int M;
    static int INF = Integer.MAX_VALUE;

    public static void dijkstra(int start) {

        PriorityQueue<Node> pq = new PriorityQueue<>();

        pq.offer(new Node(start, 0, 0));
        dist[start][0] = 0;

        while (!pq.isEmpty()) {

            Node curNode = pq.poll();
            int curV = curNode.v;

            if (dist[curV][curNode.c] < curNode.d)
                continue;

            for (Node nextNode : list[curV]) {
                if (nextNode.c + curNode.c > M) {
                    continue;
                }

                if (dist[nextNode.v][nextNode.c + curNode.c] > curNode.d + nextNode.d) {
                    dist[nextNode.v][nextNode.c + curNode.c] = curNode.d + nextNode.d;
                    pq.offer(new Node(nextNode.v, nextNode.c + curNode.c, dist[nextNode.v][nextNode.c + curNode.c]));
                }
            }
        }
    }

    public static void main(String[] args) throws IOException {

        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int T = Integer.parseInt(bf.readLine());


        for (int i = 0; i < T; i++) {

            st = new StringTokenizer(bf.readLine());
            int N = Integer.parseInt(st.nextToken());
            M = Integer.parseInt(st.nextToken());
            int ans = INF;
            int K = Integer.parseInt(st.nextToken());

            list = new ArrayList[N + 1];
            dist = new int[N + 1][M + 1];

            for (int j = 1; j <= N; j++) {
                Arrays.fill(dist[j], INF);
            }

            for (int x = 1; x <= N; x++) {
                list[x] = new ArrayList<>();
            }

            for (int j = 0; j < K; j++) {
                st = new StringTokenizer(bf.readLine());
                int u = Integer.parseInt(st.nextToken());
                int v = Integer.parseInt(st.nextToken());
                int c = Integer.parseInt(st.nextToken());
                int d = Integer.parseInt(st.nextToken());

                list[u].add(new Node(v, c, d));
            }

            dijkstra(1);

            for (int j = 0; j <= M; j++) {
                if (ans > dist[N][j])
                    ans = dist[N][j];
            }

            if (ans == INF) {
                System.out.println("Poor KCM");
            } else {
                System.out.println(ans);
            }
        }

    }
}
