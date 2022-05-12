import java.io.*;
import java.util.*;

public class p15663 {

    static int[] arr;
    static int[] ans;
    static StringBuilder sb;
    static boolean [] visited;
    static LinkedHashSet<String> hashSet = new LinkedHashSet<>();


    static int N, M;

    public static void per(int depth) throws IOException {

        if (depth == M) {
            sb=new StringBuilder();
            for(int x : ans){
                sb.append(x).append(" ");
            }
            hashSet.add(sb.toString());

        } else {
            for (int i = 0; i < N; i++) {
                if(!visited[i]){
                    visited[i] =true;
                    ans[depth] = arr[i];
                    per(depth + 1);
                    visited[i]= false;
                }
            }
        }
    }

    public static void main(String[] args) throws IOException {

        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        ArrayList<Integer> array = new ArrayList<>();

        st = new StringTokenizer(bf.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        visited = new boolean [N];

        arr = new int[N];
        ans = new int[M];

        st = new StringTokenizer(bf.readLine());
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(arr);
        per(0);

        for(String x : hashSet){
            System.out.println(x);
        }
    }
}
