import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class p14888 {

    static int n;
    static int min, max;
    static int [] arr;
    static int [] sym;

    public static void cal(int depth, int ans){

        if(depth == n){
            if(max < ans){
                max = ans;
            }
            if(min > ans){
                min = ans;
            }
            return;
        }

        for(int i=0; i<4;i++){
            if(sym[i]>0){
                sym[i]--;

                if(i==0){
                    cal(depth+1, ans + arr[depth]);
                }
                else if(i==1){
                    cal(depth+1, ans - arr[depth]);
                }
                else if(i==2){
                    cal(depth+1, ans * arr[depth]);
                }
                else {
                    cal(depth+1, ans / arr[depth]);
                }
                sym[i]++;
            }

        }


    }

    public static void main(String[] args) throws IOException {

        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        n = Integer.parseInt(bf.readLine());
        arr = new int[n];

        max = Integer.MIN_VALUE;
        min = Integer.MAX_VALUE;

        sym = new int[4];

        st = new StringTokenizer(bf.readLine());
        for(int i=0;i<n;i++){
            arr[i] = Integer.parseInt(st.nextToken());
        }

        st= new StringTokenizer(bf.readLine());
        for(int i=0; i<4; i++){
            sym[i] = Integer.parseInt(st.nextToken());
        }

        cal(1,arr[0]);

        System.out.println(max);
        System.out.println(min);

    }
}
