import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.stream.Collectors;

public class p9 {
    public static void main(String [] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        String s = bf.readLine();
        String answer;
        ArrayList <Integer> arr = new ArrayList<>();
        for(int i=0; i<s.length();i++){
            if(Character.isDigit(s.charAt(i))){
                arr.add(Integer.parseInt(String.valueOf(s.charAt(i))));
            }
        }
        System.out.println(Integer.parseInt(arr.stream().
                map(String::valueOf).
                collect(Collectors.joining())));
    }
}
