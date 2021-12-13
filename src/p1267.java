import java.util.Scanner;

public class p1267 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int num = sc.nextInt();
        int Y = 0;
        int M = 0;
        for (int i =0 ; i<num; i++){
            double cost = sc.nextDouble();

            int cost_y = (int) Math.ceil((cost+1)/30) * 10;
            Y += cost_y;
            int cost_m = (int) Math.ceil((cost+1)/60) * 15;
            M +=cost_m;
        }
        if(Y>M){
            System.out.println("M"+" "+M);
        }
        else if(Y<M){
            System.out.println("Y"+" "+Y);
        }
        else {
            System.out.println("Y"+" "+"M"+" "+Y);
        }

    }
}
