import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class p1541 {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int sum = 0;
        String [] exp = br.readLine().split("-");
        ArrayList<Integer> answer = new ArrayList<>();

        if(exp.length > 1){
        for(String add :exp){
            String [] exps = add.split("\\+");
            int addnum = 0;
            for(String num : exps){
                 addnum += Integer.parseInt(num);
            }
            answer.add(addnum);
        }
        for(int i=0; i<answer.size();i++){
            if (i==0){
                sum += answer.get(i);
            }
            else {
                sum -= answer.get(i);
            }
        }
        }

        else {
            for(String add :exp){
                String [] exps = add.split("\\+");
                for(String num : exps){
                    sum+= Integer.parseInt(num);
                }
            }

        }
        System.out.println(sum);
    }
}
