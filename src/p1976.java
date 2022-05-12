import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class p1976 {


    public static void union(int x, int y){

        x = find(x);
        y = find(y);

        if (x < y){
            parent[y] = x;
        }
        else
            parent[x] = y;

    }

    public static int find(int x){

        if(parent[x] == x){
            return parent[x];
        }

        else
        {
            parent[x] = find(parent[x]);
            return parent[x];
        }

    }

    public static boolean isSameParent(int x, int y){

        x = find(x);
        y = find(y);

        if( x == y){
            return true;
        }
        else
            return false;
    }


    static int [] parent;
    public static void main(String[] args) throws IOException {

        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int N = Integer.parseInt(bf.readLine());
        int M = Integer.parseInt(bf.readLine());


        parent = new int [N+1];

        boolean flag = true;
        int [] temp = new int [N+1];
        int [] dst = new int [M+1];

        for(int i=1; i<=N; i++){
            parent[i] = i;
        }

        for(int i=1 ;i<=N ;i++){
            st = new StringTokenizer(bf.readLine());
            for(int j=1; j<=N ; j++){
                temp[j] = Integer.parseInt(st.nextToken());
                if(temp[j] == 1){
                    union(i,j);
                }
            }
        }

        st = new StringTokenizer(bf.readLine());

        for(int i=1; i<=M; i++){
            dst[i] = Integer.parseInt(st.nextToken());
        }

        for(int i=1; i<M; i++){
            flag = isSameParent(dst[i],dst[i+1]);
            if (!flag){
                break;
            }
        }

        if(!flag){
            System.out.println("NO");
        }
        else
            System.out.println("YES");
    }
}
