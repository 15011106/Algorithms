import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class p7785 {
    public static void main(String[] args) throws IOException {

        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

        HashSet<String> arr  = new HashSet<>();
        StringTokenizer st;
        int n = Integer.parseInt(bf.readLine());

        for (int i=0; i< n; i++){
            st = new StringTokenizer(bf.readLine());
            String name = st.nextToken();
            String state = st.nextToken();

            if(state.equals("enter")){
                arr.add(name);
            }
            else{
                arr.remove(name);
            }

        }
        ArrayList<String> ans= new ArrayList<>(arr);
        ans.sort(Collections.reverseOrder());

        for(String temp : ans){
            System.out.println(temp);
        }
    }
}
