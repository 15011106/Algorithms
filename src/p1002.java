import java.io.*;
import java.util.StringTokenizer;

public class p1002 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int t = Integer.parseInt(br.readLine());

        for (int i = 0; i < t; i++) {
            st = new StringTokenizer(br.readLine());
            int x1 = Integer.parseInt(st.nextToken());
            int y1 = Integer.parseInt(st.nextToken());
            int r1 = Integer.parseInt(st.nextToken());
            int x2 = Integer.parseInt(st.nextToken());
            int y2 = Integer.parseInt(st.nextToken());
            int r2 = Integer.parseInt(st.nextToken());
            int dx = (int) Math.pow(x2 - x1, 2.0);
            int dy = (int) Math.pow(y2 - y1, 2.0);

            double d =  Math.sqrt(dx + dy);

            if (d == 0 && r1 == r2) {
                System.out.println("-1");
            } else if (d > Math.abs(r2 - r1) && d < r1 + r2) {
                System.out.println("2");
            } else if (Math.abs(r2 - r1) == d || r2 + r1 == d) {
                System.out.println("1");
            } else if (r1 + r2 < d || Math.abs(r2 - r1) > d || d == 0) {
                System.out.println("0");
            }
        }
    }
}