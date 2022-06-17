import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.Buffer;

public class p11721 {
    public static void main(String[] args) throws IOException {

        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        int idx=0;
        String temp = bf.readLine();
        int q = temp.length() / 10;
        int r = temp.length() % 10;

        if(q>=1){
            for(int i=0; i<q; i++){
                for(int j=idx; j<idx+10; j++){
                    System.out.print(temp.charAt(j));
                }
                System.out.println();
                idx = idx+10;
            }
        }

        for(int i=idx;i<idx+r; i++){
            System.out.print(temp.charAt(i));
        }

    }
}
