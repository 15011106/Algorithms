import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class p1967 {

    static class Node {

        int d;
        int w;

        public Node(int d, int w) {
            this.d = d;
            this.w = w;
        }

    }

    static ArrayList<Node>[] list;
    static boolean[] visited;
    static int max = Integer.MIN_VALUE;
    static int maxIdx = 0;

    public static void dfs(int i, int w) {

        if (max < w) {
            max = w;
            maxIdx = i;
        }

        visited[i] = true;
        for (Node nextNode : list[i]) {

            if (!visited[nextNode.d]) {
                dfs(nextNode.d, nextNode.w + w);
            }
        }

    }

    public static void main(String[] args) throws IOException {

        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(bf.readLine());
        visited = new boolean[n + 1];
        list = new ArrayList[n + 1];
        StringTokenizer st;

        for (int i = 1; i <= n; i++) {
            list[i] = new ArrayList<>();
        }

        for (int i = 1; i < n; i++) {

            st = new StringTokenizer(bf.readLine());

            int s = Integer.parseInt(st.nextToken());
            int d = Integer.parseInt(st.nextToken());
            int w = Integer.parseInt(st.nextToken());

            list[s].add(new Node(d, w));
            list[d].add(new Node(s, w));
        }

        dfs(1, 0);
        max = Integer.MIN_VALUE;
        visited = new boolean[n+1];
        dfs(maxIdx, 0);
        System.out.println(max);
    }
}
