import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;


public class p4485 {

    static class Node implements Comparable<Node> {
        int x, y, w;

        public Node(int x, int y, int w) {
            this.x = x;
            this.y = y;
            this.w = w;
        }

        @Override
        public int compareTo(Node o) {
            return w - o.w;
        }
    }

    public static int INF = Integer.MAX_VALUE;
    static int[][] dist;
    static int[][] arr;
    static int N;
    static int M;
    static int[] dx = {0, 0, 1, -1};
    static int[] dy = {1, -1, 0, 0};


    public static void bfs(int x, int y) {

        PriorityQueue<Node> pq = new PriorityQueue<>();
        pq.offer(new Node(x,y,arr[x][y]));

        while(!pq.isEmpty()){
            Node curNode = pq.poll();
            int curX = curNode.x;
            int curY = curNode.y;
            int curW = curNode.w;

            for(int i=0; i<4; i++){
                int nx = curX + dx[i];
                int ny = curY + dy[i];

                if(nx >=0 && ny >=0 && nx<N && ny <N){
                    if(dist[nx][ny] > curW + arr[nx][ny]){
                        dist[nx][ny] = curW + arr[nx][ny];
                        pq.offer(new Node(nx,ny,dist[nx][ny]));
                    }
                }
            }
        }
        System.out.println("Problem " +M + ": " + dist[N-1][N-1]);
        M++;

    }


    public static void main(String[] args) throws IOException {


        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        M=1;


        while (true) {

            N = Integer.parseInt(bf.readLine());
            if(N == 0){
                break;
            }

            dist = new int[N][N];
            arr = new int[N][N];

            for(int i=0; i<N;i++){
                Arrays.fill(dist[i], INF);
            }

            for (int i = 0; i < N; i++) {
                st = new StringTokenizer(bf.readLine());
                for (int j = 0; j < N; j++) {
                    arr[i][j] = Integer.parseInt(st.nextToken());
                }
            }

            bfs(0,0);
        }
    }
}
