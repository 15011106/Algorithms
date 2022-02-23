import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.lang.reflect.Array;
import java.util.*;
import java.util.stream.Collectors;

public class p10 {
    public static void main(String [] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st= new StringTokenizer(bf.readLine());

        String s = st.nextToken();
        String t = st.nextToken();
        List<String> strings = new ArrayList<>(Collections.singletonList(s));
        ArrayList<Integer> answer = new ArrayList<>();

        for(int i =0; i<s.length(); i++){
            int max = 0;
            int cnt =0;
            int cnt2= 0;
            int max2 = 0;
            for(int j =i; j<s.length(); j++){
                if(t.charAt(0)!=(strings.get(0).charAt(j))){
                    max++;
                }
                else
                {
                    cnt++;
                    break;}
            }
            for(int k=i; k>=0; k--){
                if(t.charAt(0)!=(strings.get(0).charAt(k))){
                    max2++;
                }
                else{
                    cnt2++;
                    break;}
            }
            if(cnt >0 && cnt2>0){
                answer.add(Math.min(max, max2));
            }
            else if(cnt==0 && cnt2>0){
                answer.add(max2);
            }
            else answer.add(max);

        }
        System.out.println(answer.stream().map(Object::toString).collect(Collectors.joining(" ")));
    }
}
