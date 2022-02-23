import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.StringTokenizer;

public class p11047 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());
        int value = 0;
        ArrayList<Integer> coins = new ArrayList<>();
        for(int i = 0; i<N;i++){
            coins.add(Integer.parseInt(br.readLine()));
        }
        coins.sort((o1, o2) -> o2-o1);

        for(int coin : coins){
            if(K==0){
                break;
            }
            else if(K/coin >= 1){
                value += K/coin;
                K = K-(K/coin)*coin;
            }
        }
        System.out.println(value);
    }
}
