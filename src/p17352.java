import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class p17352 {

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


    static int[] parent;

    public static void main(String[] args) throws IOException {

        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int N = Integer.parseInt(bf.readLine());
        parent = new int[N + 1];

        for (int i = 1; i <= N; i++) {
            parent[i] = i;
        }

        for (int i = 0; i < N - 2; i++) {

            st = new StringTokenizer(bf.readLine());

            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            union(a, b);
        }

        for(int i=2; i<=N; i++){

            if(find(i) == i)
            {
                System.out.print(i-1 +" "+ i);
            }
        }


    }
}
