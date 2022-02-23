import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.stream.Collectors;

public class p11 {
    public static void main(String[] args)throws IOException {

        int [] alphabet = new int[27];
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        String s = bf.readLine();
        int index = 0;
        ArrayList<String> answer = new ArrayList<>();
        ArrayList<String> solution = new ArrayList<>();
        for (int i =0; i<s.length();i++){
            if(alphabet[s.charAt(i)-65]==0){
                answer.add(String.valueOf(s.charAt(i)));
            }
            alphabet[s.charAt(i)-65]++;
        }
        for (String value : answer) {
            char charTmp = value.charAt(0);
            solution.add(String.valueOf(charTmp));
            if(alphabet[(int) value.charAt(0)-65]>1){
                int numTmp= alphabet[(int) value.charAt(0)-65];
                solution.add(String.valueOf(numTmp));
            }
        }
        System.out.println(solution.stream().collect(Collectors.joining("")));
    }
}
