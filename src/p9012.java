import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class p9012 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int num = Integer.parseInt(br.readLine());

        for (int i = 0; i < num; i++) {
            String str = br.readLine();
            System.out.println(isVps(str));

        }
    }

    public static String isVps(String str) {

        Stack<String> stack = new Stack<>();

        for (int i = 0; i < str.length(); i++) {

            if (i == str.length() - 1) {
                String s = str.substring(i);
            }
            String s = str.substring(i, i + 1);

            if ("(".equals(s)) {
                stack.push(s);
            } else if (")".equals(s) && !stack.empty()) {
                stack.pop();
            } else if (")".equals(s) && stack.empty()) {
                return "NO";
            }
        }

        if (stack.empty()) {
            return "YES";
        } else {
            return "NO";
        }


    }
}