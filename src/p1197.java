import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

class Node implements Comparable<Node> {
    int s;
    int d;
    int v;

    public Node(int s, int d, int v) {
        this.s = s;
        this.d = d;
        this.v = v;
    }

    public Node(int s, int d) {
    }

    public int compareTo(Node o) {
        return v - o.v;
    }
}


public class p1197 {

    static int[] parent;

    public static void union(int a, int b) {

        int x = find(a);
        int y = find(b);

        if (x < y) {
            parent[y] = x;
        } else
            parent[x] = y;

    }

    public static int find(int a) {

        if (parent[a] == a) {
            return parent[a];
        } else {
            parent[a] = find(parent[a]);
            return parent[a];
        }
    }

    public static void main(String[] args) throws IOException {

        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine());
        PriorityQueue<Node> arr = new PriorityQueue<>();

        int V = Integer.parseInt(st.nextToken());
        int E = Integer.parseInt(st.nextToken());
        int ans = 0;

        parent = new int[V + 1];
        for (int i = 0; i <= V; i++) {
            parent[i] = i;
        }


        for (int i = 0; i < E; i++) {

            st = new StringTokenizer(bf.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());

            arr.add(new Node(a, b, c));
        }

        while (!arr.isEmpty()) {
            Node curNode = arr.poll();

            if (find(curNode.s) != find(curNode.d)) {
                ans += curNode.v;
                union(curNode.s, curNode.d);
            }
        }

        System.out.println(ans);
    }
}
