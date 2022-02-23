import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.stream.Collectors;

public class p12 {
    public static char signTochar(String sign){
        ArrayList<String> arr = new ArrayList<>();
        for (int a : sign.toCharArray()){
            if ('#'== a){
                a =1;
            }
            else {
                a= 0;
            }
        arr.add(String.valueOf(a));
        }
        int ans = Integer.valueOf(arr.stream().collect(Collectors.joining("")),2);

        return (char) ans;
    }
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        int s = Integer.parseInt(bf.readLine());
        String a = bf.readLine();
        ArrayList<String> temp = new ArrayList<>();
        ArrayList<String> answer = new ArrayList<>();
        int cnt =1;
        for(char index : a.toCharArray()){
            if(cnt ==7){
                temp.add(String.valueOf(index));

                answer.add(String.valueOf(signTochar(temp.stream().collect(Collectors.joining("")))));
                cnt =1;
                temp.clear();
                continue;
            }
            else if (cnt <8){
                temp.add(String.valueOf(index));
            }
            cnt++;
        }

        System.out.println(String.join("", answer));

    }
}
