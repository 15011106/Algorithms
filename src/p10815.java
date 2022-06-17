import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.StringTokenizer;

public class p10815 {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(bf.readLine());
        HashSet<Integer> arr = new HashSet<>();
        StringTokenizer st=  new StringTokenizer(bf.readLine());
        for(int i =0; i<n;i++){
            int temp = Integer.parseInt(st.nextToken());
            arr.add(temp);
        }
        int m = Integer.parseInt(bf.readLine());
        st=  new StringTokenizer(bf.readLine());

        for(int i=0; i<m ;i++ ){
            int temp = Integer.parseInt(st.nextToken());
            if(arr.contains(temp))
                System.out.print(1+" ");
            else
                System.out.print(0+" ");
        }

    }
}
