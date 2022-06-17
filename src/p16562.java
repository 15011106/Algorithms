import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class p16562 {


    static int[] parent;
    static int[] val;

    public static void union(int x, int y) {

        x = find(x);
        y = find(y);


        if (x < y) {
            parent[y] = x;
        }

        else
            parent[x] = y;

        if(val[x] < val[y]){
            val[y] = val[x];
        }
        else val[x] = val[y];
    }

    public static int find(int x) {

        if (x == parent[x]) {
            return parent[x];
        } else {
            parent[x] = find(parent[x]);
            return parent[x];
        }

    }

    public static boolean isSameParent(int x, int y) {

        x = find(x);
        y = find(y);

        if (x == y) {
            return true;
        } else
            return false;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(bf.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        int ans = 0;
        boolean[] visited = new boolean[N + 1];
        val = new int[N + 1];
        parent = new int[N + 1];

        for (int i = 1; i <= N; i++) {
            parent[i] = i;
        }

        st = new StringTokenizer(bf.readLine());

        for (int i = 0; i < N; i++) {
            val[i + 1] = Integer.parseInt(st.nextToken());
        }

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(bf.readLine());

            int v = Integer.parseInt(st.nextToken());
            int w = Integer.parseInt(st.nextToken());
            union(v, w);

        }

        for (int i = 1; i <= N; i++) {
            if (visited[find(i)]) {
                continue;
            }
            ans += val[find(i)];
            visited[find(i)] = true;
            if (ans > K) {
                break;
            }
        }

        if (ans > K) {
            System.out.println("Oh no");
        } else
            System.out.println(ans);
    }

}
