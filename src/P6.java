import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Objects;
import java.util.stream.Collectors;

public class P6 {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        char[] s = bf.readLine().toCharArray();
        int[] a = new int[26];
        ArrayList<String> answer = new ArrayList<>();
        for (int i = 0; i < s.length; i++) {
            int num = s[i]-97;
            if (a[num] == 0) {
                a[num]++;
                String tmp = Character.toString(s[i]);
                answer.add(tmp);
            }
        }
        String ans = answer.stream().map(Objects::toString)
                .collect(Collectors.joining());
        System.out.println(ans);
    }
}
