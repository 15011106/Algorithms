import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class P15655 {

    static int [] arr,ans;
    static BufferedWriter bw;

    static int N,M;

    public static void com(int depth, int start) throws IOException {

        if( depth == M){
            for(int i : ans){
                bw.write(i+" ");
            }
            bw.newLine();
            bw.flush();
        }

        else {
            for(int i = start ; i<N ; i++){
                ans[depth] = arr[i];
                com(depth+1,i+1);
            }
        }
    }

    public static void main(String[] args) throws IOException {
        bw = new BufferedWriter(new OutputStreamWriter(System.out));
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        arr = new int [N];
        ans = new int [M];

        st= new StringTokenizer(bf.readLine());

        for( int i=0; i<N; i++){
            arr[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(arr);

        com(0,0);

    }
}
