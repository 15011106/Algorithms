import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class p1021 {
    public static void main(String[] args) throws IOException {

        Deque<Integer> deque = new ArrayDeque<>();
        Deque<Integer> deque2 = new ArrayDeque<>();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int M = Integer.parseInt(st.nextToken());
        int N = Integer.parseInt(st.nextToken());
        StringTokenizer st2 = new StringTokenizer(br.readLine());
        int [] num = new int[N];
        int min = 0;
        int min2 = 0;
        int sum = 0;

        for(int i=0; i<N; i++){
            num[i] = Integer.parseInt(st2.nextToken());
        }

        for(int i=0; i<M; i++){
            deque.offer(i+1);
            deque2.offer(i+1);
        }


        for(int i=0; i<N; i++){
            int a =num[i];

            for(int j=0; j<deque.size(); j++){
                if (deque.getFirst() == a){
                    min = j;
                    deque.removeFirst();
                    break;
                }
                else {
                    deque.addFirst(deque.removeLast());
                }
            }

            for(int j=0; j<deque2.size(); j++){
                if (deque2.getFirst() == a){
                    min2 = j;
                    deque2.removeFirst();
                    break;
                }
                else {
                    deque2.addLast(deque2.removeFirst());
                }
            }

            sum += Math.min(min, min2);
        }

        System.out.println(sum);

    }

}
