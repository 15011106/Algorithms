import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class p4949 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        while(true){
            String testCase = br.readLine();
            if((".").equals(testCase)){
                break;
            }
            System.out.println(isVps(testCase));
        }

    }

    public static String isVps(String str){

        Stack<String> bracket = new Stack<>();
        String s;

        for (int i=0; i<str.length();i++){

            if(i == str.length()-1){
                s = str.substring(i);
            }
            else {
                s = str.substring(i, i + 1);
            }

            if ("(".equals(s)){
                bracket.push(s);
            }
            else if("[".equals(s)){
                bracket.push(s);
            }

            else if(")".equals(s) && !bracket.empty()) {
                if (bracket.peek().equals("(")) {
                    bracket.pop();
                }
                else {
                    return "no";
                }
            }

            else if ("]".equals(s) && !bracket.empty()){
                if (bracket.peek().equals("[")) {
                    bracket.pop();
                }
                else {
                    return "no";
                }
            }

            else if(")".equals(s) && bracket.empty()){
                return "no";
            }
            else if ("]".equals(s) && bracket.empty()){
                return "no";
            }

        }

        if(bracket.empty()) {
            return "yes";
        }
        else {
                return "no";
            }
        }
    }
