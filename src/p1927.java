import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;

public class p1927 {
    public static void main(String[] args) throws IOException {
        PriorityQueue<Integer> heap = new PriorityQueue<>();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());

        for(int i=0;i<T;i++){
            int num = Integer.parseInt(br.readLine());
            if(num ==0){
                if (heap.size() ==0){
                    System.out.println("0");
                }
                else {
                    System.out.println(heap.poll());
                }
            }
            else {
                heap.add(num);
            }
        }
    }
}
