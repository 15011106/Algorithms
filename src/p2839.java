import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class p2839 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String T = br.readLine();
        int num = Integer.parseInt(T);
        int val5 =0;
        int mod5=0;
        int ans=0;
        mod5=num%5;
        if (mod5==0){
            val5 = num/5;
            ans = val5;
        }
        else
        {
            while(num>=0){
                num -= 3;
                ans++;
                if(num%5==0){
                    ans += num/5;
                    break;
                }
            }
            if (num<0){
            ans=-1;
            }
        }
        System.out.println(ans);

    }}
