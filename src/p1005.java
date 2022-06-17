import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class p1005 {

    static ArrayList<Integer>[] arr;
    static int[] weight, inDegree, ans;
    static int w, n, k;

    static void topology() {
        Queue<Integer> queue = new LinkedList<>();

        for (int i = 1; i <= n; i++) {
            if (inDegree[i] == 0) {
                ans[i] = weight[i];
                queue.add(i);
            }
        }

        while(!queue.isEmpty()) {

            Integer x = queue.poll();

            for (int next : arr[x]) {

                if (ans[next] < ans[x] + weight[next]) {
                    ans[next] = ans[x] + weight[next];
                }

                inDegree[next] = inDegree[next]-1;

                if (inDegree[next] == 0) {
                    queue.add(next);
                }
            }
        }
    }

    public static void main(String[] args) throws IOException {

        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(bf.readLine());
        StringTokenizer st;

        for (int i = 0; i < t; i++) {

            st = new StringTokenizer(bf.readLine());

            n = Integer.parseInt(st.nextToken());
            k = Integer.parseInt(st.nextToken());

            weight = new int[n + 1];
            inDegree = new int[n + 1];
            ans = new int[n + 1];
            arr = new ArrayList[n + 1];

            for (int j = 0; j <= n; j++) {
                arr[j] = new ArrayList<>();
            }

            st = new StringTokenizer(bf.readLine());

            for (int j = 1; j <= n; j++) {
                weight[j] = Integer.parseInt(st.nextToken());
            }

            for (int j = 0; j < k; j++) {

                st = new StringTokenizer(bf.readLine());
                int s = Integer.parseInt(st.nextToken());
                int d = Integer.parseInt(st.nextToken());

                arr[s].add(d);
                inDegree[d]++;
            }

            w = Integer.parseInt(bf.readLine());
            topology();
            System.out.println(ans[w]);
        }

    }
}
