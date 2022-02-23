import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.Buffer;

public class p11s {
    public static String solution(String s){

        StringBuilder answer = new StringBuilder();
        s=s+" ";
        int cnt =1;
        for(int i=0; i<s.length()-1;i++){
            if(s.charAt(i)==s.charAt(i+1)){
                cnt++;
            }
            else {
                answer.append(s.charAt(i));
                if(cnt>1){
                    answer.append(cnt);
                }
                cnt =1;
            }
        }

        return answer.toString();
    }
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        String s = bf.readLine();
        System.out.println(solution(s));
    }
}
