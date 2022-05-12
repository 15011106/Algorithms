import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class p9370 {

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

            if (curW > dist[curD]) {
                continue;
            }
            for (Node nextNode : list[curD]) {
                if (dist[nextNode.d] > dist[curD] + nextNode.w) {
                    dist[nextNode.d] = dist[curD] + nextNode.w;
                    pq.offer(new Node(nextNode.d, dist[nextNode.d]));
                    route[nextNode.d] = curD;
                }
            }

        }
    }


    static ArrayList<Node>[] list;
    static int[] dist;
    static int[] route;
    static int INF = Integer.MAX_VALUE;

    public static void main(String[] args) throws IOException {

        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

        int T = Integer.parseInt(bf.readLine());
        StringTokenizer st;
        ArrayList<Integer> arr = new ArrayList<>();

        for (int i = 0; i < T; i++) {


            st = new StringTokenizer(bf.readLine());
            int n = Integer.parseInt(st.nextToken());
            int m = Integer.parseInt(st.nextToken());
            int t = Integer.parseInt(st.nextToken());

            list = new ArrayList[n + 1];

            int[] distS;
            int[] distG;
            int[] distH;
            int gToH = 0;

            ArrayList<Integer> ans = new ArrayList<>();

            dist = new int[n + 1];
            route = new int[n + 1];
            int[] dst = new int[t];

            Arrays.fill(dist, INF);

            for (int j = 1; j <= n; j++) {
                list[j] = new ArrayList<>();
            }

            st = new StringTokenizer(bf.readLine());

            int s = Integer.parseInt(st.nextToken());
            int g = Integer.parseInt(st.nextToken());
            int h = Integer.parseInt(st.nextToken());

            for (int j = 0; j < m; j++) {
                st = new StringTokenizer(bf.readLine());

                int a = Integer.parseInt(st.nextToken());
                int b = Integer.parseInt(st.nextToken());
                int d = Integer.parseInt(st.nextToken());


                if (a == g && b == h || a == h && b == g) {
                    gToH = d;
                }

                list[a].add(new Node(b, d));
                list[b].add(new Node(a, d));
            }

            for (int j = 0; j < t; j++) {
                dst[j] = Integer.parseInt(bf.readLine());
            }

            dijkstra(s);
            distS = dist.clone();
            dist = new int[n + 1];
            Arrays.fill(dist, INF);

            dijkstra(g);
            distG = dist.clone();
            dist = new int[n + 1];
            Arrays.fill(dist, INF);

            dijkstra(h);
            distH = dist.clone();
            dist = new int[n + 1];
            Arrays.fill(dist, INF);

            for (int x : dst) {
                int weight = distS[x];
                if (weight == gToH + Math.min(distS[g] + distH[x], distS[h] + distG[x]))
                    ans.add(x);
            }

            Collections.sort(ans);

            for(int x : ans){
                System.out.print(x + " ");
            }
        }





    }
}
