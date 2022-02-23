import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class p1436 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        int val = 666;

        for (int i=1; i<n;){
            val++;
            if(String.valueOf(val).contains("666")){
                i++;
            }
        }
        System.out.println(val);
    }
}
