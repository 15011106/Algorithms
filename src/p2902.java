import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class p2902 {
    public static void main(String[] args) throws IOException {

        BufferedReader bf= new BufferedReader(new InputStreamReader(System.in));

        String temp  = bf.readLine();

        String[] arr = temp.split("-");

        for(String s : arr){
            System.out.print(s.charAt(0));
        }
    }
}
