import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;

public class p11725 {

    static boolean[] visited;
    static ArrayList<Integer>[] arr;
    static ArrayList<Integer>[] answer;

    public static void dfs(int i) {

        visited[i] = true;

        for (int x : arr[i]) {
            if (!visited[x]) {
                answer[x].add(i);
                dfs(x);
            }
        }


    }

    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(bf.readLine());

        visited = new boolean[n + 1];
        arr = new ArrayList[n + 1];
        answer = new ArrayList[n + 1];

        StringTokenizer st;
        for (int i = 0; i < n+1; i++) {
            arr[i] = new ArrayList<>();
            answer[i] = new ArrayList<>();
        }

        for (int i = 0; i < n - 1; i++) {
            st = new StringTokenizer(bf.readLine());

            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            arr[a].add(b);
            arr[b].add(a);
        }

        dfs(1);

        for(int i=2 ; i<=n; i++){
            System.out.println(answer[i].get(0));
        }
    }
}
