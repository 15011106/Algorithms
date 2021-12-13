import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class p1929 {

    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine()," ");
        int s = Integer.parseInt(st.nextToken());
        int e =Integer.parseInt(st.nextToken());

        for(int i=s;i<=e;i++){
            if(isprime(i)){
                System.out.println(i);
            }
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
