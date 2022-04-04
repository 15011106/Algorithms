import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;
import java.util.stream.Collectors;

public class p13 {

    public static void main(String [] args) throws IOException
    {
        BufferedReader bf= new BufferedReader(new InputStreamReader(System.in));
        int s = Integer.parseInt(bf.readLine());
        StringTokenizer st = new StringTokenizer(bf.readLine());
        int temp;
        int pre=0;
        ArrayList<Integer> answer = new ArrayList<>();

        for(int i=0; i<s; i++){
            temp=Integer.parseInt(st.nextToken());
            if(i==0){
                answer.add(temp);
            }
            else {
                if(temp>pre){
                    answer.add(temp);
                }
            }
            pre = temp;
        }
        System.out.println(answer.stream().map(Object::toString).collect(Collectors.joining(" ")));

    }
}
