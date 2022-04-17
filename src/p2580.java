import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class p2580 {

    static int[][] arr;
    static boolean[] select = new boolean[9];


    public static void sol(int depth) {

        if (depth == 81) {
            for (int i = 0; i < 9; i++) {
                for (int j = 0; j < 9; j++) {
                    System.out.print(arr[i][j] + " ");
                }
                System.out.println();
            }
        System.exit(0);
        } else {
            if (arr[depth / 9][depth % 9] != 0) {
                sol(depth + 1);
            } else {
                for (int i = 0; i < 9; i++) {
                    visit(depth / 9, depth % 9);
                    if (!select[i]) {
                        arr[depth / 9][depth % 9] = i + 1;
                        select = new boolean[9];
                        sol(depth + 1);
                        arr[depth / 9][depth % 9] = 0;
                    }
                }
            }
        }

    }

    public static void visit(int i, int j) {
        select = new boolean[9];

        for (int k : arr[i]) {
            if (k != 0) {
                select[k - 1] = true;
            }
        }
        for (int k = 0; k < 9; k++) {
            if (arr[k][j] != 0) {
                select[arr[k][j] - 1] = true;
            }
        }

        int x = (i / 3) * 3;
        int y = (j / 3) * 3;

        for (int k = x; k < x + 3; k++) {
            for (int l = y; l < y + 3; l++) {
                if (arr[k][l] != 0) {
                    select[arr[k][l] - 1] = true;

                }
            }
        }

    }


    public static void main(String[] args) throws IOException {

        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        arr = new int[9][9];

        for (int i = 0; i < 9; i++) {
            st = new StringTokenizer(bf.readLine());
            for (int j = 0; j < 9; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        sol(0);
    }
}

