import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class p10026 {
    static boolean [][] visited, visited2;
    static int [] dx = {0,0,1,-1};
    static int [] dy = {1,-1,0,0};
    static int n;
    static char [][] arr,arr2;

    public static void dfs(char x,int a, int b,boolean [][] visit,char [][] array){

        visit[a][b] = true;

        for(int i=0; i<4; i++){
            int nx = a + dx[i];
            int ny = b + dy[i];

            if(nx >=0 && ny >=0 && nx < n && ny<n){
                if(!visit[nx][ny]&& array[nx][ny] == x){
                    dfs(x, nx, ny,visit,array);
                }
            }
        }
    }
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(bf.readLine());
        arr =new char[n][n];
        arr2= new char[n][n];
        int cnt1 =0;
        int cnt2 =0;

        char [] str = {'R','G','B'};
        visited = new boolean[n][n];
        visited2 = new boolean[n][n];

        for(int i=0; i<n; i++){
            String temp = bf.readLine();
            for(int j=0;j<n; j++){
                char x = temp.charAt(j);

                if (x != 'B')
                {
                    arr2[i][j] = 'R';
                }
                else arr2[i][j] = x;

                arr[i][j] =x;
            }
        }

        for(char x : str) {
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    if (arr[i][j] == x && !visited[i][j]) {
                        dfs(x,i,j,visited,arr);
                        cnt1++;
                    }
                }
            }
        }
        System.out.println(cnt1);

        for(char x : str) {
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    if (arr2[i][j] == x && !visited2[i][j]) {
                        dfs(x,i,j,visited2,arr2);
                        cnt2++;
                    }
                }
            }
        }

        System.out.println(cnt2);

    }
}
