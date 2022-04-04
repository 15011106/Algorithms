import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class p0202 {
    public static void main(String[] args) throws IOException {

        BufferedReader bf= new BufferedReader(new InputStreamReader(System.in));
        int n= Integer.parseInt(bf.readLine());
        StringTokenizer st = new StringTokenizer(bf.readLine());
        ArrayList<Integer> answer = new ArrayList<>();
        int max=0;
        int temp;

        for(int i=0;i<n;i++){
            if (i==0){
            max = Integer.parseInt(st.nextToken());
            answer.add(max);
        }
            else{
                temp = Integer.parseInt(st.nextToken());
                if(max < temp){
                    answer.add(temp);
                    max = temp;
                }
            }
        }

        System.out.println(answer.size());
    }
}
