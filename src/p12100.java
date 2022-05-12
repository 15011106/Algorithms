import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import java.util.Arrays;
import java.util.StringTokenizer;

public class p12100 {
    static int N;
    static int max = Integer.MIN_VALUE;
    static int[] ans;
    static int[][] copyArr, array;


    static void left() {

        for (int i = 0; i < N; i++) {

            int temp = 0;
            int index = 0;

            for (int j = 0; j < N; j++) {
                if (copyArr[i][j] != 0) {
                    if (copyArr[i][j] == temp) {
                        copyArr[i][index - 1] = copyArr[i][j] * 2;
                        copyArr[i][j] = 0;
                        temp = 0;

                    } else {
                        temp = copyArr[i][j];
                        copyArr[i][j] = 0;
                        copyArr[i][index] = temp;
                        index++;
                    }
                }
            }
        }
    }

    static void right() {

        for (int i = 0; i < N; i++) {

            int temp = 0;
            int index = N - 1;

            for (int j = N - 1; j >= 0; j--) {

                if (copyArr[i][j] != 0) {
                    if (copyArr[i][j] == temp) {
                        copyArr[i][index + 1] = copyArr[i][j] * 2;
                        copyArr[i][j] = 0;
                        temp = 0;

                    } else {
                        temp = copyArr[i][j];
                        copyArr[i][j] = 0;
                        copyArr[i][index] = temp;
                        index--;
                    }
                }
            }
        }
    }


    static void down() {

        for (int i = 0; i < N; i++) {

            int temp = 0;
            int index = N - 1;

            for (int j = N - 1; j >= 0; j--) {

                if (copyArr[j][i] != 0) {
                    if (copyArr[j][i] == temp) {
                        copyArr[index + 1][i] = copyArr[j][i] * 2;
                        copyArr[j][i] = 0;
                        temp = 0;

                    } else {
                        temp = copyArr[j][i];
                        copyArr[j][i] = 0;
                        copyArr[index][i] = temp;
                        index--;
                    }
                }
            }
        }

    }

    static void up() {

        for (int i = 0; i < N; i++) {

            int temp = 0;
            int index = 0;

            for (int j = 0; j < N; j++) {
                if (copyArr[j][i] != 0) {
                    if (copyArr[j][i] == temp) {
                        copyArr[index - 1][i] = copyArr[j][i] * 2;
                        copyArr[j][i] = 0;
                        temp = 0;

                    } else {
                        temp = copyArr[j][i];
                        copyArr[j][i] = 0;
                        copyArr[index][i] = temp;
                        index++;
                    }
                }
            }
        }

    }


    static void sol(int depth) {

        if (depth == 5) {

            copyArr = new int[N][N];

            for (int i = 0; i < N; i++) {
                System.arraycopy(array[i], 0, copyArr[i], 0, N);
            }

            for (int i = 0; i < 5; i++) {
                move(ans[i]);
            }

            for (int i = 0; i < N; i++) {
                for (int j = 0; j < N; j++) {
                    if (max < copyArr[i][j])
                        max = copyArr[i][j];
                }
            }

        } else {
            for (int i = 0; i < 4; i++) {
                ans[depth] = i;
                sol(depth + 1);
            }
        }
    }

    static void move(int x) {
        if (x == 0)
            up();
        else if (x == 1)
            down();
        else if (x == 2)
            left();
        else
            right();
    }

    public static void main(String[] args) throws IOException {

        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        N = Integer.parseInt(bf.readLine());

        array = new int[N][N];
        ans = new int[5];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(bf.readLine());
            for (int j = 0; j < N; j++) {
                array[i][j] = Integer.parseInt(st.nextToken());

            }
        }


        sol(0);
        System.out.println(max);


    }
}
