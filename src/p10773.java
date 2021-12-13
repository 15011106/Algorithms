import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class p10773 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        Stack<Long> stack = new Stack<>();
        Long sum = 0L;
        for(int i=0; i<T;i++){

            long testCase = Long.parseLong(br.readLine());
            if(testCase ==0){
                stack.pop();
            }
            else stack.push(testCase);
        }


        if (stack.isEmpty()){
            sum =0L;
        }
        else{
            int stackSize = stack.size();
            for (int i=0; i<stackSize;i++){
                sum+=stack.pop();
            }
        }
        System.out.println(sum);
    }

}
