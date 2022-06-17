import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class p11404 {

    static int[][] dist;
    static int INF = 10000000;
    static int n, m;

    public static void main(String[] args) throws IOException {

        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        n = Integer.parseInt(bf.readLine());
        m = Integer.parseInt(bf.readLine());
        dist = new int[n + 1][n + 1];

        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= n; j++) {
                if (i == j) {
                    dist[i][j] = 0;
                } else
                    dist[i][j] = INF;
            }
        }

        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(bf.readLine());

            int s = Integer.parseInt(st.nextToken());
            int d = Integer.parseInt(st.nextToken());
            int w = Integer.parseInt(st.nextToken());

            dist[s][d] = Math.min(dist[s][d], w);

        }


        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= n; j++) {
                for (int k = 1; k <= n; k++) {
                    dist[j][k] = Math.min(dist[j][k], dist[j][i] + dist[i][k]);
                }
            }
        }


        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= n; j++) {

                if(dist[i][j] >= INF){
                    System.out.print ("0"+" ");
                }
                else System.out.print(dist[i][j] + " ");
            }
            System.out.println();
        }
    }

}

