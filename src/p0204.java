import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class p0204 {

    static Integer [] mem = new Integer[10000];
    public static int fib(int a){
        if(a<=1){
            return a;
        }

        else if(mem[a] !=null){
            return mem[a];
        }
        else
            return mem[a] = fib(a-2)+fib(a-1);
    }
    public static void main(String[] args) throws IOException {

        BufferedReader bf= new BufferedReader(new InputStreamReader(System.in));
        int n= Integer.parseInt(bf.readLine());
        for(int i=1;i<n+1;i++){
            System.out.print(fib(i)+" ");
        }
    }
}
