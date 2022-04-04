import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Collections;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class p11724 {

    static boolean [] visited;
    static int N,M;
    static LinkedList<Integer>[] arr;
    public static void dfs(int v){
        visited[v] = true;

        for(int i=0; i<N+1;i++){
            for(int j=0; j<arr[i].size();i++){

                if(!visited[arr[i].get(j)]){
                    dfs(arr[i].get(j));
                }
            }
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        int cnt = 0;

        arr = new LinkedList[N+1];
        visited = new boolean[N+1];

        for (int i=1;i<M+1; i++){
            st = new StringTokenizer(bf.readLine());
            int v1 =Integer.parseInt(st.nextToken());
            int v2 = Integer.parseInt(st.nextToken());
            arr[v1].add(v2);
            arr[v2].add(v1);
        }

        for(int i=1; i<N+1; i++){
            Collections.sort(arr[i]);
        }

        for(int i=1;i<N+1;i++){
            if(!visited[i]){
                cnt++;
                dfs(i);
            }
        }
        System.out.println(cnt);
    }
}
