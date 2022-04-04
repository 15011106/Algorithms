import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class P1707 {
    static int[] visited;
    static ArrayList<Integer> [] arr;

    static public void dfs(int v){

        visited[v] = 2;

        for(int i=0; i<arr[v].size();i++){
            if(visited[arr[v].get(i)] !=1){

            }
        }


    }

    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(bf.readLine());
        StringTokenizer st;


        for(int i=0; i<n; i++){
            st = new StringTokenizer(bf.readLine());
            int V = Integer.parseInt(st.nextToken());
            int E = Integer.parseInt(st.nextToken());
            visited = new int[V+1];
            arr = new ArrayList[E+1];

            for(int j=0;j<E;j++){
                st = new StringTokenizer(bf.readLine());
                int v1 = Integer.parseInt(st.nextToken());
                int v2 = Integer.parseInt(st.nextToken());
                arr[v1].add(v2);
                arr[v2].add(v1);
            }

            for(int v=1; v<V+1;v++){
                visited[v] = 1;
                dfs(v);
            }

        }

    }
}
