import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class p1717 {

    public static void union(int x, int y) {
        x = find(x);
        y = find(y);

        if (x < y) {
            parent[y] = x;
        }
        else
            parent[x] = y;
    }

    public static int find(int x) {

        if (x == parent[x]) {
            return x;
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

    static int[] parent;

    public static void main(String[] args) throws IOException {

        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st;

        st = new StringTokenizer(bf.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        parent = new int[n + 1];

        for (int i = 0; i <= n; i++) {
            parent[i] = i;
        }


        for (int i = 0; i < m; i++) {

            st = new StringTokenizer(bf.readLine());
            int cal = Integer.parseInt(st.nextToken());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            if (cal == 0){
                union(a,b);
            }

            else if (cal == 1){
                if (isSameParent(a,b)){
                    System.out.println("YES");
                }
                else
                    System.out.println("NO");
            }

        }
    }
}
