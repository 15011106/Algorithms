import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class p10828 {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        Stack<Integer> answer = new Stack<>();
        for (int i =0; i<T; i++){
            String [] testCase = br.readLine().split(" ");
            if (testCase.length ==2){
                int num = Integer.parseInt(testCase[1]);
                answer.push(num);
            }
            else if("top".equals(testCase[0])){
                 if(answer.isEmpty()){
                     System.out.println("-1");
                 }
                 else {
                     System.out.println(answer.peek());
                 }
            }
            else if("size".equals(testCase[0])){
                System.out.println(answer.size());
            }
            else if("empty".equals(testCase[0])){
                if(answer.isEmpty()){
                    System.out.println("1");
                }
                else {
                    System.out.println("0");
                }
            }
            else if("pop".equals(testCase[0])){
                if (!answer.isEmpty()){
                    System.out.println(answer.pop());
                }
                else {
                    System.out.println("-1");
                }
            }
        }
    }
}
