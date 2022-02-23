import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.StringTokenizer;

public class p11399 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        int sum =0;
        int add = 0;
        StringTokenizer st = new StringTokenizer(br.readLine());
        ArrayList<Integer> time = new ArrayList<>();
        for(int i =0; i<T;i++){
            time.add(Integer.parseInt(st.nextToken()));
        }
        time.sort(Comparator.naturalOrder());

        for(int answer : time){
            add = add+answer;
            sum = sum+add;
        }
        System.out.println(sum);
    }
}
