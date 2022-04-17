import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class p15649 {
    static boolean[] visited;
    static int M, N;
    static int[] answer;
    static int[] arr;


    static void per(int depth) {

        if (depth == M) {
            for (int x : answer) {
                System.out.print(x + " ");
            }
            System.out.println();
        } else {
            for (int i = 0; i < N; i++) {
                if (!visited[i]) {
                    answer[depth] = arr[i];
                    visited[i] = true;
                    per(depth + 1);
                    visited[i] = false;
                }
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
        visited = new boolean[N];

        for (int i = 0; i < N; i++) {
            arr[i] = i + 1;
        }

        per(0);

    }
}
