import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class p0205 {
    public static boolean isPrimeNum(int i){

        int x = (int) Math.sqrt(i);
        for(int a=2; a<=x; a++){
            if(i%a == 0){
                return false;
            }
        }
        return true;
    }
    public static void main(String[] args) throws IOException {

        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(bf.readLine());
        int cnt=0;
        for (int i=2; i<n ; i++){
            if(isPrimeNum(i)){
                cnt++;
            };
        }
        System.out.println(cnt);

    }
}
