import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class p0209 {

    public static int maxSum(int[] x, int n) {
        int sum = 0;
        for (int i = 0; i < n; i++) {
            sum += x[i];
        }
        return sum;

    }

    public static void main(String[] args) throws IOException {

        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(bf.readLine());
        int[][] arr = new int[n][n];
        int[][] row = new int[n][n];
        int max = 0;
        int tempMax;
        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(bf.readLine());
            for (int j = 0; j < n; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        for (int i = 0; i < n; i++) {
            tempMax = maxSum(arr[i], n);
            if (tempMax > max) {
                max = tempMax;
            }

        }

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                row[i][j] = arr[j][i];
            }
        }
        for (int i = 0; i < n; i++) {
            tempMax = maxSum(row[i], n);
            if (tempMax > max) {
                max = tempMax;
            }
        }
        tempMax =0;
        for(int i=0; i<n; i++){
            tempMax+=arr[i][i];
    }
        if (tempMax>max){
            max = tempMax;
        }

        System.out.println(max);

}
}
