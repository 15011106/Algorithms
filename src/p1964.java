import java.util.Scanner;

public class p1964 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        long num = scanner.nextLong();
        scanner.close();
        long sum = 1;
        long answer=0;
        for (int i = 1; i <= num; i++) {
            sum = sum+i*3L+1;
            answer = sum % 45678;
        }
        System.out.println(answer);
    }
}
