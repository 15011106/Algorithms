import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class p16236 {
    public static int[][] arr;

    static int [] dx = {0,-1,0,1};
    static int [] dy = {1,0,1,0};
    static int n;
    static int cnt;
    static boolean [][] visited ;
    public static void bfs(int i,int j, int cnt, int level){

        Queue<int []> queue = new LinkedList<>();
        visited[i][j] = true;
        queue.offer(new int[] {i,j,cnt,level});

        while (!queue.isEmpty()){
            int [] temp = queue.poll();
            for(int k=0; k<4; k++){
                int nx = dx[k] + temp[0];
                int ny = dx[k] + temp[1];
                if(nx >=0 && ny >=0 && nx<n && ny <n){
                    if(!visited[nx][ny]){
                        if(temp[3] == arr[nx][ny]){
                            temp[3] ++;
                            temp[2] ++;
                            visited[nx][ny] =true;
                            arr[nx][ny] = 0;
                            queue.offer(new int [] {nx,ny,temp[2],temp[3]});
                        }
                    }
                }
            }
        }



    }

    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

        int [] start = new int [2];
        n = Integer.parseInt(bf.readLine());
        visited = new boolean[n][n];
        arr = new int [n][n];
        StringTokenizer st;

        for(int i=0; i<n; i++){
            st = new StringTokenizer(bf.readLine());
            for(int j=0; j<n ; j++){
                int temp = Integer.parseInt(st.nextToken());
                if (temp == 9){
                    start = new int[]{i, j};
                }
                arr[i][j] = Integer.parseInt(st.nextToken());
            }

            bfs(start[0], start[1], 0,0);
        }
    }
}
