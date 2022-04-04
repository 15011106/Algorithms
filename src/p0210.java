import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class p0210 {

    public boolean isPeak (int[][] array, int a, int b){

        if(array[a][b]>array[a-1][b] && array[a][b]>array[a][b-1])
        {
            if (array[a][b]>array[a+1][b] && array[a][b]>array[a][b+1]){
                return true;
            };

        }

        return false;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(bf.readLine());
        int [][] arr = new int[n+2][n+2];
        int cnt = 0;

        p0210 sol = new p0210();
        for(int i=0; i<n+2; i++){
            for(int j=0;j<n+2; j++){
                if(i==0 || j==0){
                    arr[i][j] = 0;
                }
                else if(i==n || j==n){
                    arr[i][j]=0;
                }
            }
        }


        for(int i=1; i<n+1; i++){
            StringTokenizer st = new StringTokenizer(bf.readLine());
            for (int j=1;j<n+1;j++){
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        for(int i=1; i<n+1; i++){
            for (int j=1;j<n+1;j++){
                if(sol.isPeak(arr,i,j)){
                    cnt++;
                }
            }
        }

        System.out.println(cnt);
    }
}
