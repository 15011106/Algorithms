import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class p2178 {
    static int [] dx = {0,0,1,-1};
    static int [] dy = {1,-1,0,0};
    static int N,M;
    static boolean[][] visited;
    static int [][] arr;

    public static void bfs(int i,int j){
        Queue<int []> queue = new LinkedList<>();
        int [] a = {i,j};
        queue.offer(a);
        visited[i][j] = true;

        while(!queue.isEmpty()){
            int [] x = queue.poll();
            int N_x = x[0];
            int N_y = x[1];

            for(int n =0; n<4; n++){
                int nx = N_x + dx[n];
                int ny = N_y + dy[n];
                if (nx >=0 && ny >=0 && nx<N && ny <M){
                    if(arr[nx][ny] ==1 && !visited[nx][ny]){
                        queue.offer(new int[] {nx,ny});
                        visited[nx][ny] = true;
                        arr[nx][ny] = arr[N_x][N_y]+1;
                    }
                }
            }

        }


    }
    public static void main(String[] args) throws IOException {

        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(bf.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        visited = new boolean[N][M];
        arr = new int[N][M];

        for (int i=0; i<N;i++){
            String s = bf.readLine();
            for (int j=0; j<M; j++){
                arr[i][j] =s.charAt(j);
            }
        }
        for (int i=0; i<N;i++){
            for (int j=0; j<M; j++){
                if(arr[i][j] ==1 && !visited[i][j])
                {
                    bfs(i,j);
                }
            }
        }

        System.out.println(Arrays.deepToString(arr));
    }

}
