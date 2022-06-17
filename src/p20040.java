import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class p20040 {

    static void union(int x, int y) {

        x = find(x);
        y = find(y);

        if (x < y) {
            parent[y] = x;
        } else
            parent[x] = y;
    }


    static int find(int x) {

        if (x == parent[x]) {
            return parent[x];
        } else {
            parent[x] = find(parent[x]);
            return parent[x];
        }
    }

    static boolean isSameParent(int x, int y) {

        x = find(x);
        y = find(y);

        if (x == y) {
            return true;
        } else
            return false;
    }


    static int[] parent;

    public static void main(String[] args) throws IOException {

        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st;
        st = new StringTokenizer(bf.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        boolean flag = false;
        int ans = 0;
        parent = new int[n];
        boolean[] visited = new boolean[n];

        for (int i = 0; i < n; i++) {
            parent[i] = i;
        }

        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(bf.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            ans++;


            if (!isSameParent(a, b)) {
                union(a, b);
            }
            else {
                flag = true;
                break;
            }
        }

        if (flag) {
            System.out.println(ans);
        } else
            System.out.println("0");
    }
}
