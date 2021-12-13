import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class p1110 {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());
        int cnt = 0;
        int number = cycle(t);

        while(true){
            cnt++;
            if (number == t){
                break;
            }
            number= cycle(number);
        }
        System.out.println(cnt);
    }
        public static int cycle ( int num){

            int sum = 0;
            if (num < 10) {
                sum = num * 10+num;

                return sum;
            } else {
                String number = String.valueOf(num);
                String first = number.substring(0,1);
                String second = number.substring(1,2);

                int i = Integer.parseInt(first) + Integer.parseInt(second);
                String v = String.valueOf(i);

                if (i <10)
                {
                    return Integer.parseInt(second+v);
                }

                return Integer.parseInt(second+v.charAt(1));
            }
        }
    }
