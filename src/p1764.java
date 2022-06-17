import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.StringTokenizer;

public class p1764 {

    public static void main(String[] args) throws IOException {

        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine());

        HashSet<String> hear;
        String [] see;

        ArrayList<String> ans = new ArrayList<>();

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        hear= new HashSet<>();
        see = new String[m];

        for (int i=0 ; i <n ; i++){
            hear.add(bf.readLine());
        }

        for(int i=0; i<m; i++){
            see[i] = bf.readLine();
            if(hear.contains(see[i]))
                ans.add(see[i]);
        }

        Collections.sort(ans);
        System.out.println(ans.size());

        for (String an : ans) {
            System.out.println(an);
        }



    }
}
