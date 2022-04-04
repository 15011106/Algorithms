import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class P2644 {
    static boolean[] visited;
    static ArrayList<Integer>[] arr;
    static int ans = -1;


    public void dfs(int src, int dst, int cnt) {
        visited[src]=true;
        for (int x : arr[src]) {
            if (!visited[x])
            {
                if (x == dst) {
                    cnt++;
                    ans = cnt;
                }
                dfs(x,dst,cnt+1);
            }
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        P2644 sol = new P2644();
        int x = Integer.parseInt(bf.readLine());

        visited = new boolean[x + 1];
        arr = new ArrayList[x + 1];

        StringTokenizer st = new StringTokenizer(bf.readLine());
        int S = Integer.parseInt(st.nextToken());
        int D = Integer.parseInt(st.nextToken());


        int n = Integer.parseInt(bf.readLine());

        for (int i = 0; i <= x; i++) {
            arr[i] = new ArrayList<>();
        }

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(bf.readLine());
            int src = Integer.parseInt(st.nextToken());
            int dst = Integer.parseInt(st.nextToken());
            arr[src].add(dst);
            arr[dst].add(src);
        }
        sol.dfs(S, D, 0);
        System.out.println(ans);
    }

}
