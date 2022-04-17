import java.io.*;
import java.util.StringTokenizer;

public class P15651 {

    static int n,c;
    static BufferedWriter bw;
    static int [] ans,num;

    public static void per(int depth,int start) throws IOException {
        if(depth == c){
            for(int i : ans){
                bw.write(i +" ");
            }
            bw.newLine();
        }

        else {
            for (int i = start; i < n; i++) {
                ans[depth] = num[i];
                per(depth + 1,i);
            }
        }
    }


    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st= new StringTokenizer(bf.readLine());

        n = Integer.parseInt(st.nextToken());
        num = new int[n];
        for (int i=0; i<n; i++){
            num[i] = i+1;
        }
        c = Integer.parseInt(st.nextToken());

        ans = new int[c];
        per(0, 0);
        bw.close();
        bf.close();

    }
}
