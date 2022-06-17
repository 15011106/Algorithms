import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class p9372 {


    static ArrayList<Integer>[] arr;
    static int N, M;
    static boolean[] visited;

    static public int count(int x) {

        int cnt = 0;
        visited[x] = true;

        Queue<Integer> queue = new LinkedList<>();
        queue.offer(x);

        while(!queue.isEmpty()){
            int a = queue.poll();
            for(int next : arr[a]){
                if(!visited[next]){
                    visited[next] = true;
                    queue.offer(next);
                    cnt++;
                }
            }
        }

        return cnt;
    }


    public static void main(String[] args) throws IOException {

        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int n = Integer.parseInt(bf.readLine());

        for (int i = 0; i < n; i++) {

            st = new StringTokenizer(bf.readLine());

            N = Integer.parseInt(st.nextToken());
            M = Integer.parseInt(st.nextToken());

            arr = new ArrayList[N + 1];
            visited = new boolean[N + 1];

            for (int x = 0; x <= N; x++) {
                arr[x] = new ArrayList<>();
            }

            for (int j = 0; j < M; j++) {

                st = new StringTokenizer(bf.readLine());
                int a = Integer.parseInt(st.nextToken());
                int b = Integer.parseInt(st.nextToken());

                arr[a].add(b);
                arr[b].add(a);
            }

            System.out.println(count(1));

        }

    }
}
