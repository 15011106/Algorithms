import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class p7 {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        String s = bf.readLine();
        int mid;
        String ans;
        String rAns;
        if (s.length()%2==1){
            mid = (int) s.length()/2;
            ans = s.substring(0,mid+1);
        }
        else {
            mid = s.length()/2;
            ans = s.substring(0,mid);
        }
        rAns = s.substring(mid,s.length());

        StringBuilder sb = new StringBuilder(rAns);
        String a = sb.reverse().toString();

        if (ans.equals(a)){
            System.out.println("YES");
        }
        else System.out.println("NO");
    }

}