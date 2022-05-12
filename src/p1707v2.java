import java.awt.print.Pageable;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;

public class p1707v2 {
    static int[] team;
    static ArrayList<Integer>[] list;

    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int K = Integer.parseInt(bf.readLine());

        for (int i = 0; i < K; i++) {
            st = new StringTokenizer(bf.readLine());

            int V = Integer.parseInt(st.nextToken());
            int E = Integer.parseInt(st.nextToken());

            team = new int[V + 1];
            list = new ArrayList[V + 1];

            for(int l =1; l<=V; l++){
                list[l] = new ArrayList<>();
            }

            for (int j = 0; j < E; j++) {
                st = new StringTokenizer(bf.readLine());
                int u = Integer.parseInt(st.nextToken());
                int v = Integer.parseInt(st.nextToken());

                list[u].add(v);
                list[v].add(u);
            }

            for (int k = 1; k <= V; k++) {
                if (team[k] == 0)
                    dfs(k, 0);
            }
            boolean check = true;

            for(int j=1; j<=V; j++){
                for(int temp =0 ; temp<list[j].size(); temp++){
                    if(team[j] == team[list[j].get(temp)]){
                        check = false;
                    }
                }
            }

            if(check){
                System.out.println("YES");
            }
            else
                System.out.println("NO");
        }
    }

    static void dfs(int current, int num) {
        team[current] = num;

        for (int next : list[current]) {
            if (team[next] == 0) {
                if (team[current] == 1) {
                    dfs(next, 2);
                } else
                    dfs(next, 1);
            }
        }
    }
}
