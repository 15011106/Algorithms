import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class p7562 {

    static int [] dx = {-1,1,-1,1,-2,2,-2,2};
    static int [] dy = {2,-2,-2,2,1,1,-1,-1};
    static int size;
    static int x,y,dstX,dstY;
    static boolean [][] visited;

    public static int dfs(int a,int b,int cnt){
        visited[a][b] = true;

        for(int i=0; i<8 ;i++){
            int nx = dx[i] + a;
            int ny = dy[i] + b;

            if(nx >=0 && ny >=0 && nx<size && ny <size){
                if(!visited[nx][ny]){

                    if(nx == dstX && ny == dstY)
                    {
                        return cnt;
                    }
                    else{
                        dfs(nx,ny,cnt+1);

                    }
                }
            }
        }

        return cnt;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(bf.readLine());
        StringTokenizer st ;
        int cnt ;

        for( int i=0; i<n ; i++){
            for(int j=0; j<3; j++){

                cnt =0;

                size = Integer.parseInt(bf.readLine());
                visited = new boolean[size][size];

                st = new StringTokenizer(bf.readLine());
                x = Integer.parseInt(st.nextToken());
                y = Integer.parseInt(st.nextToken());

                st = new StringTokenizer(bf.readLine());
                dstX = Integer.parseInt(st.nextToken());
                dstY = Integer.parseInt(st.nextToken());

                System.out.println(dfs(x,y,cnt));
            }
        }
    }
}
