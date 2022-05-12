import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class P11720 {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(bf.readLine());
        int ans =0;

        String M = bf.readLine();

        for(int i=0; i<n; i++){

            ans += Integer.parseInt(String.valueOf(M.charAt(i)));
        }

        System.out.println(ans);
    }
}
