import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class p18352 {

    static class Node implements Comparable<Node> {
        int e;
        int w;

        public Node(int e, int w) {
            this.e = e;
            this.w = w;
        }

        @Override
        public int compareTo(Node o) {
            return w - o.w;
        }
    }

    static void dijkstra(int x) {

        PriorityQueue<Node> pq = new PriorityQueue<>();
        pq.offer(new Node(x, 0));
        dist[x] = 0;

        while (!pq.isEmpty()) {

            Node curNode = pq.poll();
            int curE = curNode.e;
            int curW = curNode.w;

            if (curW > dist[curE]) {
                continue;
            }

            for (Node node : list[curE]) {
                if (dist[node.e] > node.w + dist[curE]) {
                    dist[node.e] = node.w + dist[curE];
                    pq.offer(new Node(node.e, dist[node.e]));
                }
            }
        }
    }

    static int N, M, K, X;
    static int[] dist;
    static ArrayList<Node>[] list;
    static int INF = Integer.MAX_VALUE;

    public static void main(String[] args) throws IOException {

        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine());
        ArrayList<Integer> ans = new ArrayList<>();

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
        X = Integer.parseInt(st.nextToken());

        list = new ArrayList[N + 1];
        dist = new int[N + 1];

        for (int i = 1; i <= N; i++) {
            list[i] = new ArrayList<>();
        }

        Arrays.fill(dist, INF);

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(bf.readLine());

            int s = Integer.parseInt(st.nextToken());
            int d = Integer.parseInt(st.nextToken());

            list[s].add(new Node(d, 1));
        }

        dijkstra(X);

        for (int i = 0; i <= N; i++) {
            if (dist[i] == K) {
                ans.add(i);
            }
        }

        if (ans.isEmpty()) {
            System.out.println("-1");
        }
        else {
            Collections.sort(ans);
            for (int x : ans) {
                System.out.println(x);
            }
        }
    }
}
