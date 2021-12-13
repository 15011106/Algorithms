import java.util.Scanner;

public class p1011 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int num = sc.nextInt();

        for(int i= 0;i<num; i++){
            int x = sc.nextInt();
            int y = sc.nextInt();

            int dis = y-x;
            int max =(int) Math.sqrt(dis);
            int sol = answer(dis,max);
            System.out.println(sol);
        }
    }
    public static int answer(int dis, int max){
        if (dis > max*max+max){
            return 2*max+1;
        }
        else if (dis == max*max){
            return 2*max-1;
        }
        else
        {
            return 2*max;
        }
    }
}
