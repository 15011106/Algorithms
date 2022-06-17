import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.StringTokenizer;

public class p1922 {

    static int find(int x) {

        if (parent[x] == x) {
            return parent[x];
        } else {
            parent[x] = find(parent[x]);
            return parent[x];
        }
    }

    static void union(int x, int y) {
        x = find(x);
        y = find(y);

        if (x < y) {
            parent[y] = x;
        } else {
            parent[x] = y;
        }
    }

    static int[] parent;

    public static void main(String[] args) throws IOException {

        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

        int sum = 0;
        int N = Integer.parseInt(bf.readLine());
        int M = Integer.parseInt(bf.readLine());

        StringTokenizer st;

        int[][] arr = new int[M][3];

        parent = new int[N + 1];
        for (int i = 0; i <= N; i++) {
            parent[i] = i;
        }

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(bf.readLine());
            for (int j = 0; j < 3; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        Arrays.sort(arr, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {

                return o1[2] - o2[2];
            }
        });

        for (int i = 0; i < arr.length; i++) {
            if (find(arr[i][0]) != find(arr[i][1])) {
                sum += arr[i][2];
                union(arr[i][0], arr[i][1]);
            }
        }

        System.out.println(sum);
    }
}
