import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class p15656 {

    static int[] arr;
    static int[] ans;
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static StringBuilder sb = new StringBuilder();

    static int N, M;

    public static void per(int depth) throws IOException {

        if (depth == M) {
            for(int x : ans){
                sb.append(x).append(" ");
            }
            sb.append("\n");

        } else {
            for (int i = 0; i < N; i++) {
                ans[depth] = arr[i];
                per(depth + 1);
            }
        }
    }

    public static void main(String[] args) throws IOException {

        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(bf.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        arr = new int[N];
        ans = new int[M];

        st = new StringTokenizer(bf.readLine());
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(arr);
        per(0);
        System.out.println(sb);
    }
}
