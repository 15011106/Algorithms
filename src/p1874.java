import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Stack;

public class p1874 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());
        ArrayList<String> sign = new ArrayList<>();
        Stack<Integer> stack = new Stack<>();
        int now =1;
        for (int i=0; i<t;i++){
            int testCase = Integer.parseInt(br.readLine());
            if (testCase>=now){
                for(int j=now; j<=testCase; j++){
                    stack.push(j);
                    now++;
                    sign.add("+");
                }
            }
            else if (stack.peek()!=testCase){
                System.out.println("NO");
                return;
            }
            stack.pop();
            sign.add("-");

        }
        for (String s : sign) {
            System.out.println(s);
        }
    }

}

