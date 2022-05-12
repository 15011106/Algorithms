import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class p11779 {

    static ArrayList<Node>[] list;
    static ArrayList<Node> ans;
    static int[] dist;
    static int dst;
    static int path;
    static int INF = Integer.MAX_VALUE;

    static void route(int start) {

        for (int i = 0; i < list[start].size(); i++) {
            int s = list[start].get(i).d;
            int w = list[start].get(i).w;

            if (s == dst) {
                int sum = 0;
                for (Node an : ans) {
                    sum += an.w;
                }

                if (sum == path) {
                    for(int j=0; j<ans.size();j++){
                        System.out.println(ans.get(j).d);
                    }

                    return;
                }
                else {
                    ans.clear();
                }
            } else {
                ans.add(new Node(s,w));
                route(s);
            }
        }
    }

    static class Node implements Comparable<Node> {

        int d;
        int w;

        public Node(int d, int w) {
            this.d = d;
            this.w = w;
        }

        public int compareTo(Node o) {
            return w - o.w;
        }
    }

    static void dijkstra(int start) {
        PriorityQueue<Node> pq = new PriorityQueue<>();
        dist[start] = 0;
        pq.offer(new Node(start, 0));

        while (!pq.isEmpty()) {

            Node curNode = pq.poll();
            int curD = curNode.d;
            int curW = curNode.w;

            if (curW > dist[curD])
                continue;

            for (Node node : list[curD]) {
                if (dist[node.d] > dist[curD] + node.w) {
                    dist[node.d] = dist[curD] + node.w;
                    pq.offer(new Node(node.d, dist[node.d]));
                }
            }
        }
    }

    public static void main(String[] args) throws IOException {

        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int N = Integer.parseInt(bf.readLine());
        int M = Integer.parseInt(bf.readLine());
        list = new ArrayList[N + 1];
        ans = new ArrayList<>();
        dist = new int[N + 1];

        Arrays.fill(dist, INF);

        for (int i = 1; i <= N; i++) {
            list[i] = new ArrayList<>();
        }

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(bf.readLine());

            int s = Integer.parseInt(st.nextToken());
            int d = Integer.parseInt(st.nextToken());
            int w = Integer.parseInt(st.nextToken());

            list[s].add(new Node(d, w));
        }

        st = new StringTokenizer(bf.readLine());
        int start = Integer.parseInt(st.nextToken());
        dst = Integer.parseInt(st.nextToken());

        dijkstra(start);
        path = dist[dst];
        route(start);
        System.out.println(ans);



    }
}