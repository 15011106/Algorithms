import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class p11779ver2 {

    static ArrayList<Node>[] list;
    static int[] dist,route;
    static int dst;
    static int INF = Integer.MAX_VALUE;

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
                    route[node.d] = curD;
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
        dist = new int[N + 1];
        route = new int[N + 1];
        int count = 0;

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
        Stack<Integer> stack = new Stack<>();
        int current = dst;

        while(current != start){
            stack.push(current);
            count++;

            current = route[current];
        }
        stack.push(current);
        count++;

        System.out.println(dist[dst]);
        System.out.println(count);

        while(!stack.isEmpty()){
            System.out.print(stack.pop() + " ");
        }

    }
}