import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;

public class p2667 {

    static boolean [][] visited ;
    static int [][] arr;
    static int n;
    static int [] dx = {0,0,1,-1};
    static int [] dy = {1,-1,0,0};
    static int cnt;
    static ArrayList<Integer> result;

    public void dfs(int x, int y){

        visited[x][y] = true;
        cnt++;

        for(int i=0; i<4;i++){
            int nx = x + dx[i];
            int ny = y + dy[i];

            if(nx >=0 && ny>=0 && nx < n && ny < n)
            {
                if(arr[nx][ny] ==1 && !visited[nx][ny]){
                    dfs(nx,ny);

                }
            }
        }
    }



    public static void main(String[] args) throws IOException {

        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(bf.readLine());

        p2667 sol = new p2667();
        arr = new int [n][n];
        visited = new boolean[n][n];
        result = new ArrayList<>();
        char[] temp;
        int complex =0;

        for (int i=0; i<n ;i++){
            temp = bf.readLine().toCharArray();
            for(int j=0; j<n; j++){
                arr[i][j] = Integer.parseInt(String.valueOf(temp[j]));
            }
        }

        for(int i=0; i<n; i++){
            for(int j=0; j<n; j++){
                if(arr[i][j] == 1 && !visited[i][j]){
                    cnt=0;
                    complex++;
                    sol.dfs(i,j);
                    result.add(cnt);
                }
            }
        }

        Collections.sort(result);
        System.out.println(complex);
        for(int i : result){
            System.out.println(i);
        }
    }
}
