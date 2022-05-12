import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class p1719 {

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

    static ArrayList<Node>[] list;
    static int[] dist;
    static int[] route;
    static int INF = Integer.MAX_VALUE;

    public static void dijkstra(int start) {

        PriorityQueue<Node> pq = new PriorityQueue<>();
        pq.offer(new Node(start, 0));
        dist[start] = 0;


        while (!pq.isEmpty()) {
            Node curNode = pq.poll();
            int curD = curNode.d;

            if (curNode.w > dist[curD]) {
                continue;
            }

            for (Node nextNode : list[curD]) {
                if (dist[nextNode.d] > dist[curNode.d] + nextNode.w) {
                    dist[nextNode.d] = dist[curNode.d] + nextNode.w;
                    pq.offer(new Node(nextNode.d, dist[nextNode.d]));
                    route[nextNode.d] = curD;
                }
            }
        }
    }

    public static void main(String[] args) throws IOException {


        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine());

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        route = new int[n + 1];
        list = new ArrayList[n + 1];
        dist = new int[n + 1];
        int [][] ans = new int[n][n];

        for (int i = 1; i <= n; i++) {
            list[i] = new ArrayList<>();
            dist[i] = INF;
        }
        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(bf.readLine());

            int s = Integer.parseInt(st.nextToken());
            int d = Integer.parseInt(st.nextToken());
            int w = Integer.parseInt(st.nextToken());

            list[s].add(new Node(d, w));
            list[d].add(new Node(s, w));
        }

        for(int i=1; i<=n;i++){
            dijkstra(i);

            for(int j=1; j<=n ;j++){
                ans[j-1][i-1] = route[j];
            }

            Arrays.fill(dist,INF);
            route = new int[n+1];
        }

        for(int i=0; i<n; i++){
            for(int j=0; j<n;j++){
                if(ans[i][j] == 0)
                    System.out.print("- ");
                else
                    System.out.print(ans[i][j] + " ");
            }
            System.out.println();
        }
    }

}
