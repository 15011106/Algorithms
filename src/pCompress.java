import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class pCompress {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String testCase = br.readLine();
        int num = testCase.length()/2;
        int index =0;
        int min = testCase.length();
        for (int i=2; i<=num; i++){
            for(int k=index;k<testCase.length();k++){
                for(int j=index;j<i;j++){
                    if(testCase.charAt(index) == testCase.charAt(j)){

                    }
                }
            }
        }
    }
}
