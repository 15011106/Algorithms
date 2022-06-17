import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class p1259 {
    public static void main(String[] args) throws IOException {

        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb;
        while(true){
            String temp = bf.readLine();
            if (temp.equals("0"))
            {
                break;
            }


            if(temp.length()%2 == 0){

                String first = temp.substring(0,temp.length()/2);
                String second = temp.substring(temp.length()/2);

                sb = new StringBuilder(second);
                if(first.equals(sb.reverse().toString())){
                    System.out.println("yes");
                }
                else
                    System.out.println("no");
            }

            else {
                String first = temp.substring(0,temp.length()/2);
                String second = temp.substring((temp.length()/2)+1);

                sb = new StringBuilder(second);
                if(first.equals(sb.reverse().toString())){
                    System.out.println("yes");
                }
                else
                    System.out.println("no");
            }
        }
    }
}
