import java.util.Scanner;

public class p1296 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int L = 0;
        int O = 0;
        int V = 0;
        int E = 0;

        String y = sc.nextLine();

        for(int j=0; j<y.length();j++){
            if (y.charAt(j) =='L')
                L++;
        }
        for(int j=0; j<y.length();j++){
            if (y.charAt(j) =='O')
                O++;
        }
        for(int j=0; j<y.length();j++){
            if (y.charAt(j) =='V')
                V++;
        }
        for(int j=0; j<y.length();j++){
            if (y.charAt(j) =='E')
                E++;
        }

        int num = sc.nextInt();
        String winner = sc.next();
        int maxrate = count(winner,L,O,V,E);

        for(int i =0; i<(num-1); i++){
            String name = sc.next();

            int temp = count(name,L,O,V,E);
            if(maxrate<temp) {
                winner = name;
                maxrate = temp;
            }
            else if(maxrate == temp){
                int a = winner.compareTo(name);
                if (a>0){
                    winner=name;
                }
            }
        }
        System.out.println(winner);
    }

    public static int count (String name, int L, int O, int V, int E){
        for(int j=0; j<name.length();j++){
            if (name.charAt(j) =='L')
                L++;
        }
        for(int j=0; j<name.length();j++){
            if (name.charAt(j) =='O')
                O++;
        }
        for(int j=0; j<name.length();j++){
            if (name.charAt(j) =='V')
                V++;
        }
        for(int j=0; j<name.length();j++){
            if (name.charAt(j) =='E')
                E++;
        }
        int ans = ((L+O)*(L+V)*(L+E)*(O+V)*(O+E)*(V+E))%100;
        return ans;
    }
}
