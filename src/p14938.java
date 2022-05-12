import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class p14938 {

    public static class Node implements Comparable<Node> {
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

    static int[] dist;
    static int INF = Integer.MAX_VALUE;
    static ArrayList<Node>[] list;

    public static void dijkstra(int start){

        PriorityQueue<Node> pq = new PriorityQueue<>();
        dist[start] = 0;
        pq.offer(new Node(start,0));

        while(!pq.isEmpty()){
            Node curNode = pq.poll();
            int curD = curNode.d;

            if(curNode.w > dist[curD]){
                continue;
            }

            for(Node nextNode : list[curD]){
                if(dist[nextNode.d] > dist[curD] + nextNode.w){
                    dist[nextNode.d] = dist[curD] + nextNode.w;
                    pq.offer(new Node(nextNode.d, dist[nextNode.d]));
                }
            }

        }
    }


    public static void main(String[] args) throws IOException {

        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine());

        int max=0;


        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int r = Integer.parseInt(st.nextToken());

        int[] item = new int[n+1];
        int [][] ansArr = new int [n+1][n+1];
        list = new ArrayList[n + 1];
        dist = new int[n + 1];

        for (int i = 1; i <= n; i++) {
            list[i] = new ArrayList<>();
            dist[i] = INF;
        }

        st = new StringTokenizer(bf.readLine());
        for (int i = 1; i <= n; i++) {
            item[i] = Integer.parseInt(st.nextToken());
        }

        for (int i = 0; i < r; i++) {
            st = new StringTokenizer(bf.readLine());

            int s = Integer.parseInt(st.nextToken());
            int d = Integer.parseInt(st.nextToken());
            int w = Integer.parseInt(st.nextToken());

            list[s].add(new Node(d, w));
            list[d].add(new Node(s, w));
        }

        for(int i=1; i<= n; i++){

            int tempSum = 0;
            dijkstra(i);
            ansArr[i] = dist.clone();

            for(int k=1;k<=n;k++){
                if (ansArr[i][k] <= m){
                    tempSum += item[k];
                }
            }

            max = Math.max(tempSum, max);
            for (int j = 1; j <= n; j++) {
                dist[j] = INF;
            }
        }

        System.out.println(max);

    }
}

