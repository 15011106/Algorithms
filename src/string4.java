import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashSet;
import java.util.StringTokenizer;

public class string4 {
    public static void main(String[] args) throws IOException {

        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();;
        int num = 0;
        int ans = 0;

        int n = Integer.parseInt(bf.readLine());

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(bf.readLine());

            String o = st.nextToken();
            if (st.hasMoreTokens()) {
                num = Integer.parseInt(st.nextToken());
            }

            switch (o) {

                case "add":
                    ans = ans | (1 << num);
                    break;

                case "remove":
                    ans = ans & ~(1 << num);
                    break;

                case "check":
                    sb.append((ans & (1 << num)) >> num).append('\n');
                    break;

                case "toggle":
                    ans = ans ^ (1 << num);
                    break;

                case "all":
                    ans = ans | (1<<21) -1;
                    break;

                case "empty":
                    ans =0;
                    break;
            }

        }
        System.out.println(sb);

    }
}
