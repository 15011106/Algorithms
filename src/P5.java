import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class P5 {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        String s = bf.readLine();
        char [] strings = s.toCharArray();
        char tmp;
        int rt = s.length()-1;

        for (int lt=0; lt<rt;)
        {
            if(Character.isAlphabetic(strings[lt])){
                if(Character.isAlphabetic(strings[rt])){
                    tmp = strings[lt];
                    strings[lt] = strings[rt];
                    strings[rt] = tmp;
                    rt--;
                    lt++;
                }
                else
                    rt--;
            }

            else if(!Character.isAlphabetic(strings[lt])){
                lt++;
                if(!Character.isAlphabetic(strings[rt])){
                    rt--;
                }
            }
            }

        System.out.println(strings);
        }
    }
