import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;


public class p1753 {

    static class Node implements Comparable<Node> {
        int e, w;

        public Node(int e, int w) {
            this.e = e;
            this.w = w;
        }

        @Override
        public int compareTo(Node o) {
            return w - o.w;
        }
    }


    static int n, m;
    static int start;
    static int[] dist;
    static ArrayList<Node>[] list;
    static int INF = Integer.MAX_VALUE;


    public static void main(String[] args) throws IOException {

        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        start = Integer.parseInt(bf.readLine());

        dist = new int[n + 1];
        list = new ArrayList[n + 1];

        Arrays.fill(dist, INF);

        for (int i = 1; i <= n; i++) {
            list[i] = new ArrayList<>();
        }

        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(bf.readLine());
            int s = Integer.parseInt(st.nextToken());
            int d = Integer.parseInt(st.nextToken());
            int w = Integer.parseInt(st.nextToken());

            list[s].add(new Node(d, w));
        }

        dijkstra(start);

        for (int i = 1; i <= n; i++) {

            if (dist[i] == INF)
                System.out.println("INF");
            else
                System.out.println(dist[i]);
        }

    }

    public static void dijkstra(int start) {
        PriorityQueue<Node> queue = new PriorityQueue<>();
        queue.offer(new Node(start, 0));
        dist[start] = 0;

        while (!queue.isEmpty()) {
            Node curNode = queue.poll();
            int cur = curNode.e;

            if (curNode.w > dist[cur])
                continue;

            for (Node node : list[cur]) {
                if (dist[node.e] > dist[cur] + node.w) {
                    dist[node.e] = dist[cur] + node.w;
                    queue.offer(new Node(node.e, dist[node.e]));
                }
            }
        }

    }
}
