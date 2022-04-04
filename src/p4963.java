import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class p4963 {
    static boolean[][] visited;
    static int W,H;
    static int[][] arr;
    int [] dx = {0,0,-1,1,1,-1,1,-1};
    int [] dy = {1,-1,0,0,1,-1,-1,1};

    public void dfs(int i,int j, int maxH,int maxW){
        visited[i][j]= true;
        for(int x=0; x<8;x++){
            int nx = i+dx[x];
            int ny = i+dy[x];
            if (nx>=0 && ny>=0 && nx<maxH && ny <maxW){
                if(arr[nx][ny] ==1 && !visited[nx][ny]){
                    dfs(nx,ny,maxH,maxW);
                }
            }
        }
    }
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

        p4963 sol = new p4963();
        int cnt =0;

        StringTokenizer st = new StringTokenizer(bf.readLine());
        W = Integer.parseInt(st.nextToken());
        H = Integer.parseInt(st.nextToken());

        visited = new boolean[H][W];
        arr = new int[H][W];

        for(int i=0;i<H;i++){
            st= new StringTokenizer(bf.readLine());
            for(int j=0; j<W;j++){
                arr[i][j]=Integer.parseInt(st.nextToken());
            }
        }

        System.out.println(Arrays.deepToString(arr));

        for(int i=0;i<H;i++){
            for(int j=0; j<W; j++){
                if(arr[i][j] == 1 && !visited[i][j]){
                    sol.dfs(i,j,H,W);
                    cnt++;
                }
            }
        }
        System.out.println(cnt);
    }
}
