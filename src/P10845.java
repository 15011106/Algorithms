import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class P10845 {

    public static void main(String[] args) throws IOException {

        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st ;

        Queue<Integer> q = new LinkedList<>();
        int n = Integer.parseInt(bf.readLine());
        int num =0;

        for(int i=0; i<n;i++){
            st = new StringTokenizer(bf.readLine());
            String o = st.nextToken();
            if(st.hasMoreTokens()){
                num = Integer.parseInt(st.nextToken());
            }

            switch (o){
                case "push" :
                    q.offer(num);
                    break;
                case "pop":
                    if(!q.isEmpty()){
                        System.out.println(q.poll());
                    }
                    else
                        System.out.println("-1");
                    break;

                case"size":
                    System.out.println(q.size());
                    break;
                case"empty":
                    if(q.isEmpty()){
                        System.out.println("1");
                    }
                    else
                        System.out.println("0");
                    break;
                case"front":
                    if(!q.isEmpty()){
                        System.out.println(q.peek());
                    }
                    else
                        System.out.println("-1");
                    break;
                case"back":
                    if(!q.isEmpty()){
                        System.out.println(num);
                    }
                    else
                        System.out.println("-1");
                    break;
            }
        }
    }
}
