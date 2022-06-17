import java.io.BufferedReader;
        import java.io.IOException;
        import java.io.InputStreamReader;

public class p10162 {

    public static void main(String[] args) throws IOException {

        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(bf.readLine());

        int a = 0;
        int b = 0;
        int c = 0;

        if (n >= 300) {
            a = n / 300;
            n = n % 300;
        }

        if (n >= 60) {
            b = n / 60;
            n = n % 60;
        }

        if (n >= 10) {
            c = n / 10;
            n = n % 10;
        }

        if (n > 0) {
            System.out.println(-1);
        } else {
            System.out.print(a + " " + b + " " + c);
        }
    }
}
