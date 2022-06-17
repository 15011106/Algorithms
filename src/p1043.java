import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class p1043 {
    public static void union(int x, int y) {
        x = find(x);
        y = find(y);

        if (x < y) {
            parent[y] = x;
        } else
            parent[x] = y;

    }

    public static int find(int x) {

        if (parent[x] == x) {
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

    public static int[] parent;

    public static void main(String[] args) throws IOException {
        StringTokenizer st;
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        ArrayList<Integer>[] arr;

        st = new StringTokenizer(bf.readLine());

        int ans = 0;


        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        parent = new int[N + 1];
        arr = new ArrayList[M + 1];

        for (int i = 1; i <= M; i++) {
            arr[i] = new ArrayList<>();
        }

        for (int i = 1; i <= N; i++) {
            parent[i] = i;
        }


        st = new StringTokenizer(bf.readLine());

        int lie = Integer.parseInt(st.nextToken());
        int[] lier = new int[lie + 1];

        if (lie != 0) {
            for (int i = 1; i <= lie; i++) {
                lier[i] = Integer.parseInt(st.nextToken());
            }
            for (int i = 1; i < lie; i++) {
                union(lier[i], lier[i + 1]);
            }
        }


        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(bf.readLine());
            int participants = Integer.parseInt(st.nextToken());
            int[] temp = new int[participants];

            for (int j = 0; j < participants; j++) {
                int who = Integer.parseInt(st.nextToken());
                temp[j] = who;
                arr[i + 1].add(who);
            }

            for (int j = 0; j < participants - 1; j++) {
                union(temp[j], temp[j + 1]);
            }
        }

        if (lie != 0) {
            for (int i = 1; i < arr.length; i++) {
                for (int j = 0; j < arr[i].size(); j++) {
                    if (!isSameParent(arr[i].get(j), lier[1])) {
                        ans++;
                        break;
                    }
                }
            }
        }
        else
            ans = M;

        System.out.println(ans);
    }
}
