import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.StringTokenizer;

public class p11866 {
    public static void main(String[] args) throws IOException {
        Deque<Integer> deque = new ArrayDeque<>();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());
        ArrayList<Integer> numArray = new ArrayList<>();
        StringBuilder answer = new StringBuilder();

        for(int i=0;i<N;i++){
            deque.offer(i+1);
        }

        for(int i=0; i<N; i++){

            for (int j = 0; j < K - 1; j++) {
                deque.addLast(deque.removeFirst());
            }
            numArray.add(deque.removeFirst());
        }


        answer.append("<");
        for (Integer integer : numArray) {
            answer.append(integer).append(", ");
        }
        answer.delete(answer.length()-2,answer.length());
        answer.append(">");
        System.out.println(answer);
    }

    }