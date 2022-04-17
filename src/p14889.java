import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;

public class p14889 {

    static int[][] arr;
    static int n;
    static int [] comArr;
    static int [] perArr;
    static int min = Integer.MAX_VALUE;
    static ArrayList<Integer> opposite;
    static int sum = 0;
    static boolean [] visited;
    static int [] index;
    static boolean [] perVisited;



    public static void com(int depth , int start, boolean[] visited){

        if( depth == n/2){
            for(int x : comArr){
                if(x >0)
                {
                    visited[x-1] = true;
                }
            }

            for(int i=0; i<n; i++){
                if(!visited[i]){
                    opposite.add(i+1);
                }
            }
            int [] tempOpposite = new int[n/2];

            for(int i=0; i<n/2; i++){
                tempOpposite[i] = opposite.get(i);
            }


            int teamOne = per(0,0, comArr);
            sum=0;
            int teamTwo = per(0,0 ,tempOpposite);
            sum=0;

            if(min > Math.abs(teamOne-teamTwo)){
                min = Math.abs(teamOne-teamTwo);
            }
            for(int i=0; i<n; i++){
                visited[i] = false;
            };
        }

        else {
            for(int i=start; i<n; i++){
                comArr[depth] = index[i];
                com(depth+1, i+1,visited);
            }
        }
    }

    public static int per(int depth,int start, int [] tempArr){

        if(depth == 2){
            System.out.println(Arrays.toString(perArr));
            sum += arr[perArr[0]][perArr[1]] + arr[perArr[1]][perArr[0]];
        }

        else {
            for(int i=start; i<n/2; i++){
                    perArr[depth] = tempArr[i]-1;
                    per(depth+1, i+1,tempArr);
            }
        }

        return sum;
    }

    public static void main(String[] args) throws IOException {

        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        n = Integer.parseInt(bf.readLine());
        arr = new int[n][n];
        opposite = new ArrayList<>();
        comArr = new int [n];
        perArr = new int[n/2];
        perVisited = new boolean [n];
        index = new int [n];
        for(int i=0;i <n;i++){
            index[i] = i+1;
        }

        visited = new boolean[n];

        for(int i =0;i<n;i++){
            st = new StringTokenizer(bf.readLine());
            for(int j=0; j<n; j++){
                arr[i][j] =Integer.parseInt(st.nextToken());
            }
        }

        com(0,0,visited);
        System.out.println(min);
    }
}
