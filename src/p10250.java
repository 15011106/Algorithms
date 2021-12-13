import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class p10250 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String T = br.readLine();
        int num = Integer.parseInt(T);

        for (int i = 0; i<num;i++){
            String s = br.readLine();
            StringTokenizer st = new StringTokenizer(s);
            int H = Integer.parseInt(st.nextToken());
            int W = Integer.parseInt(st.nextToken());
            int N = Integer.parseInt(st.nextToken());
            roomNumber(H,N);
        }
    }

    public static void roomNumber(int H, int N) {
        int N_H = 0;
        int N_W = 1;
        for (int i = 0; i < N; i++) {
            N_H++;
            if (N_H > H) {
                N_H = 1;
                N_W++;
            }
        }

        String n_h = String.valueOf(N_H);
        String n_w = String.valueOf(N_W);
        if (N_W < 10) {
            n_w = "0"+n_w;
            String ans = n_h + n_w;
            System.out.println(ans);
        } else {
            String ans = n_h + n_w;
            System.out.println(ans);

        }
    }
}
