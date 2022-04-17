import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.StringTokenizer;

public class p1026 {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(bf.readLine());
        Integer[] arr1 = new Integer[n];
        Integer[] arr2 = new Integer[n];
        int answer = 0;

        StringTokenizer st = new StringTokenizer(bf.readLine());
        for(int i = 0; i<n ; i++){
            arr1[i] = Integer.parseInt(st.nextToken());
        }

        st = new StringTokenizer(bf.readLine());
        for(int i = 0; i<n ; i++){
            arr2[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(arr1);
        Arrays.sort(arr2, Collections.reverseOrder());


        for(int i=0; i<n;i++){
            answer = arr1[i]*arr2[i]+answer;
        }
        System.out.println(answer);
    }
}
