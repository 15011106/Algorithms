import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class p10815v2 {
    static int [] arr;
    static public boolean binarySearch(int key, int low, int high){

        int mid ;

        if(low <= high ){
            mid = (low+high) /2;

            if(key == arr[mid]){
                return true;
            }
            else if(key < arr[mid]){
                return binarySearch(key,low,mid-1);
            }
            else
                return binarySearch(key,mid+1,high);
        }
        return false;
    }
    public static void main(String[] args) throws IOException {

        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(bf.readLine());
        arr = new int[n];

        StringTokenizer st = new StringTokenizer(bf.readLine());

        for(int i=0 ;i<n; i++){
            arr[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(arr);
        int m = Integer.parseInt(bf.readLine());
        st = new StringTokenizer(bf.readLine());

        for(int i=0 ;i<m; i++){
            int temp = Integer.parseInt(st.nextToken());

            if(binarySearch(temp,0,arr.length-1)){
                System.out.print("1"+" ");
            }
            else
                System.out.print("0"+" ");
        }
    }
}
