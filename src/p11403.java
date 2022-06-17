import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class p11403 {

    static int[][] arr, ans;
    static int n;
    static boolean[] visited;

    static void dfs(int s) {

        for (int i = 0; i < n; i++) {
            if (!visited[i] && arr[s][i] == 1) {
                visited[i] = true;
                dfs(i);
            }
        }
    }


    public static void main(String[] args) throws IOException {

        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        n = Integer.parseInt(bf.readLine());


        arr = new int[n][n];
        ans = new int[n][n];
        visited = new boolean[n];

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(bf.readLine());
            for (int j = 0; j < n; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        for (int i = 0; i < n; i++) {
            dfs(i);
            for (int j = 0; j < n; j++) {
                if (visited[j]) {
                    ans[i][j] = 1;
                }
            }
            visited = new boolean[n];
        }

        for(int i=0; i<n; i++){
            for(int j=0 ;j<n; j++){
                System.out.print(ans[i][j] +" ");
            }
            System.out.println();
        }

    }
}
