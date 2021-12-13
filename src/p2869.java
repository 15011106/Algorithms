import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class p2869 {
    public static void main(String[] args) throws IOException {

        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer stz = new StringTokenizer(bf.readLine());
        int A = Integer.parseInt(stz.nextToken());
        int B = Integer.parseInt(stz.nextToken());
        int V = Integer.parseInt(stz.nextToken());

        long sol = 0;

        double ans = ((double)(V-B)/(double)(A-B));
        long val = (long) ans;
        if(ans%val>0){
            sol = (long)ans+1;
        }
        else {
            sol = (long)(ans);
        }
        System.out.println(sol);
    }
}
