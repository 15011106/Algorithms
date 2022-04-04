import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class p0708 {
    int answer = 0;
    int [] dis = {1,-1,5};
    boolean [] visited;
    Queue<Integer> Q = new LinkedList<>();
    public int BFS(int x, int y){
        visited = new boolean[10001];
        visited[x] = true;
        Q.offer(x);
        int L =0;
        while (!Q.isEmpty()){
            int s = Q.size();
            for(int i=0; i<s; i++ ){
                int num = Q.poll();
                if(num == y) return L;

                for (int n:dis) {
                    int nx = num + n;
                    if(nx>1 && nx<10001){
                        if(!visited[nx]){
                            visited[nx] = true;
                            Q.offer(nx);
                        }
                    }
                }
            }
            L++;
        }
        return 0;
    }


    public static void main(String [] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

        String[] arr = bf.readLine().split(" ");
        int x = Integer.parseInt(arr[0]);
        int y =Integer.parseInt(arr[1]);

        p0708 sol = new p0708();

        System.out.println(sol.BFS(x,y));
    }
}
