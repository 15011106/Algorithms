import java.io.*;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.StringTokenizer;

public class p18258 {
    public static void main(String[] args) throws IOException {

        Deque<Integer> deque = new ArrayDeque<>();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int T = Integer.parseInt(br.readLine());
        ArrayList<Integer> answer = new ArrayList<>();

        for (int i = 0; i < T; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            String input = st.nextToken();

            if (st.hasMoreTokens()) {
                deque.add(Integer.parseInt(st.nextToken()));
            } else if ("pop".equals(input)) {
                if (deque.isEmpty()) {
                    bw.write("-1");
                } else {
                    bw.write(deque.pollFirst().toString());
                }
                bw.newLine();
            } else if ("size".equals(input)) {
                bw.write(String.valueOf(deque.size()));
                bw.newLine();
            } else if ("empty".equals(input)) {
                if (deque.isEmpty()) {
                    bw.write("1");
                } else {
                    bw.write("0");
                }
                bw.newLine();
            } else if ("front".equals(input)) {
                if (deque.isEmpty()) {
                    bw.write("-1");
                } else {
                    bw.write(deque.getFirst().toString());
                }
                bw.newLine();
            } else if ("back".equals(input)) {
                if (deque.isEmpty()) {
                    bw.write("-1");
                } else {
                    bw.write(deque.getLast().toString());
                }
                bw.newLine();
            }
        }
        bw.flush();

    }

}
