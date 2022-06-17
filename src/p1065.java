import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class p1065 {

    public static void main(String[] args) throws IOException {

        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

        int ans = 0;
        int n = Integer.parseInt(bf.readLine());
        boolean a;


        if (n < 100) {
            ans = n;
        } else {
            ans += 99;

            for(int i=100; i<=n; i++){

                a = true;
                String temp = String.valueOf(i);
                int dif = Character.getNumericValue(temp.charAt(0)) - Character.getNumericValue(temp.charAt(1));

                for(int j=0; j<temp.length()-1; j++){
                    if(Character.getNumericValue(temp.charAt(j)) - Character.getNumericValue(temp.charAt(j+1)) != dif)
                    {
                        a = false;
                        break;
                    }
                }
                if (a){
                    ans++;
                }
            }
        }
        System.out.println(ans);
    }
}
