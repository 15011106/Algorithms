import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class p0801 {

    public void DFS(int n, int a, int [] arr){
        boolean[] visited = new boolean[arr.length+1];
        visited[a] = true;
        String answer = "NO";
        boolean flag = false;
        int sum=0,total =0;

        for(int i : arr){
            sum +=i;
        }

        if(a+1==n){
            if(total-sum==sum){
                answer = "YES";
                flag = true;

            }
        }


    }
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(bf.readLine());
        int [] arr = new int[n];
        StringTokenizer st = new StringTokenizer(bf.readLine());

        for(int i=0; i<n;i++){
            arr[i] = Integer.parseInt(st.nextToken());
        }


    }
}
