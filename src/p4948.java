import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class p4948 {

    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

        while(true){
            int primecount =0;
            int t = Integer.parseInt(bf.readLine());
            if (t==0){
                break;
            }
            for (int i=t+1; i<=2*t; i++){
                if (isprime(i)){
                    primecount++;
                }
            }
            System.out.println(primecount);
        }
    }

    public static boolean isprime(int n){

        if (n==1){
            return false;
        }
            for(int i=2; i<=(int)Math.sqrt(n);i++){
                if(n%i==0) {
                    return false;
                }
            }
                return true;
    }
}
