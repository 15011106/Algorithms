import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class dijkstraMatrix {
    public static int INF = Integer.MAX_VALUE;
    static int [] dist;
    static int [][] arr;
    static boolean [] visited ;
    static int N;

    public static void dijkst(int start){

        dist[start] =0;
        int min = Integer.MAX_VALUE;
        int minIndex = 0;

        for (int i=0 ; i<N-1; i++){

            for(int j=0; j<N ; j++){
                if(!visited[j] && dist[j]<min){
                    min = dist[j];
                    minIndex = j;
                }
            }

            visited[minIndex] = true;

            for(int j=0; j<N; j++){

                if(!visited[j] && arr[minIndex][j] !=0)
                    if( dist[j] > arr[minIndex][j] + min ){
                        dist[j] = arr[minIndex][j] + min;
                    }
            }
        }
    }


    public static void main(String[] args) throws IOException {


        BufferedReader bf =new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;



        N = Integer.parseInt(bf.readLine());
        arr =new int[N][N];
        dist = new int[N];
        visited = new boolean[N];
        Arrays.fill(dist,INF);

        for (int i=0; i<N; i++){
            st = new StringTokenizer(bf.readLine());
            for(int j=0; j<N; j++){
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        while (N!=0){

            N = Integer.parseInt(bf.readLine());
            visited = new boolean[N];
            dist = new int[N];
            arr =new int[N][N];

            Arrays.fill(dist,INF);

            for (int i=0; i<N; i++){
                st = new StringTokenizer(bf.readLine());
                for(int j=0; j<N; j++){
                    arr[i][j] = Integer.parseInt(st.nextToken());
                }
            }

        }


    }
}
