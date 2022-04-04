import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;
import java.util.stream.Collectors;

public class p0206 {
    boolean IsPrimeNum(int a){
        int isprime = (int) Math.sqrt(a);
        if(a == 1){
            return false;
        }
        for(int i=2; i<=isprime; i++){
            if(a%i==0){
                return false;
            }

        }
        return true;
    }
    public static void main (String [] args) throws IOException {
        p0206 t = new p0206();
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(bf.readLine());
        StringTokenizer st = new StringTokenizer(bf.readLine());

        ArrayList<String> arr = new ArrayList<>();
        ArrayList<Integer> answer = new ArrayList<>();

        for(int i =0;i<n;i++){
            String s = st.nextToken();

            for(int j=s.length()-1; j>=0;j--){
                arr.add(String.valueOf(s.charAt(j)));
            }

            int x = Integer.parseInt(arr.stream().collect(Collectors.joining("")));
            arr.clear();
            if(t.IsPrimeNum(x)){
                System.out.print(x+" ");
            };


        }

    }
}
