import java.awt.print.Pageable;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class p0203 {

    public static char game(int a, int b){
        if(a==1){
            if(b==1){
                return 'D';
            }
            else if(b==2){
                return 'B';
            }
            else
                return 'A';

        }
        else if(a==2){
            if(b==1){
                return 'A';
            }
            else if(b==2) {
                return 'D';
            }
            else
                return 'B';
        }

        else {
            if(b==1){
                return 'B';
            }
            else if(b==2){
                return 'A';
            }
            else {
                return 'D';
            }
        }
    }
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(bf.readLine());
        int [] A = new int[n];
        int [] B = new int[n];
        StringTokenizer st = new StringTokenizer(bf.readLine());
        StringTokenizer st2 = new StringTokenizer(bf.readLine());
        for(int i=0; i<n;i++){
            A[i]=Integer.parseInt(st.nextToken());
        }
        for(int i=0; i<n;i++){
            B[i]=Integer.parseInt(st2.nextToken());
        }

        for(int i=0; i<n;i++){
            System.out.println(game(A[i],B[i]));

        }
    }
}
