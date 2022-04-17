import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class p15650 {
    static int M, N;
    static int[] answer;
    static int[] arr;


    static void com(int depth, int start) {

        if (depth == M) {
            for (int x : answer) {
                System.out.print(x + " ");
            }
            System.out.println();
        } else {
            for (int i = start; i < N+1; i++) {
                    answer[depth] = i;
                    com(depth + 1,i+1);
            }
        }
    }



    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        arr = new int[N];
        answer = new int[M];

        for (int i = 0; i < N; i++) {
            arr[i] = i + 1;
        }

        com(0,1);

    }
}
