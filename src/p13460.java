import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class p13460 {

    static class Node {

        int rx;
        int ry;
        int bx;
        int by;
        int cnt;

        public Node() {

        }

        public Node(int rx, int ry, int bx, int by, int cnt) {
            this.rx = rx;
            this.ry = ry;
            this.bx = bx;
            this.by = by;
            this.cnt = cnt;

        }
    }

    static char[][] arr;
    static int N, M;
    static int[] dx = {0, 0, 1, -1};
    static int[] dy = {1, -1, 0, 0};

    static boolean[][][][] visited;

    static void bfs(int rX, int rY, int bX, int bY) {

        Queue<Node> queue = new LinkedList<>();
        queue.add(new Node(rX, rY, bX, bY, 0));

        while (!queue.isEmpty()) {

            Node current = queue.poll();
            visited[current.rx][current.ry][current.bx][current.by] = true;

            if (current.cnt >= 10) {
                System.out.println("-1");
                return;
            }

            int rx = current.rx;
            int ry = current.ry;
            int bx = current.bx;
            int by = current.by;



            for (int i = 0; i < 4; i++) {

                int nrx = rx;
                int nry = ry;
                int nbx = bx;
                int nby = by;

                boolean isBlueDone = false;
                boolean isRedDone = false;

                switch (i) {
                    case 0:
                        while (arr[nbx][nby+1] != '#') {
                            nby++;
                            if (arr[nbx][nby] == 'O') {
                                isBlueDone = true;
                                break;
                            }
                        }
                        break;

                    case 1:
                        while (arr[nbx][nby-1] != '#') {
                            nby--;
                            if (arr[nbx][nby] == 'O') {
                                isBlueDone = true;
                                break;
                            }
                        }
                        break;

                    case 2:
                        while (arr[nbx+1][nby] != '#') {
                            nbx++;
                            if (arr[nbx][nby] == 'O') {
                                isBlueDone = true;
                                break;
                            }
                        }
                        break;

                    case 3:
                        while (arr[nbx-1][nby] != '#') {
                            nbx--;
                            if (arr[nbx][nby] == 'O') {
                                isBlueDone = true;
                                break;
                            }
                        }
                        break;
                }

                switch (i) {
                    case 0:
                        while (arr[nrx][nry+1] != '#') {
                            nry++;
                            if (arr[nrx][nry] == 'O') {
                                isRedDone = true;
                                break;
                            }
                        }
                        break;

                    case 1:
                        while (arr[nrx][nry-1] != '#') {
                            nry--;
                            if (arr[nrx][nry] == 'O') {
                                isRedDone = true;
                                break;
                            }
                        }
                        break;

                    case 2:
                        while (arr[nrx+1][nry] != '#') {
                            nrx++;
                            if (arr[nrx][nry] == 'O') {
                                isRedDone = true;
                                break;
                            }
                        }
                        break;

                    case 3:
                        while (arr[nrx-1][nry] != '#') {
                            nrx--;
                            if (arr[nrx][nry] == 'O') {
                                isRedDone = true;
                                break;
                            }
                        }
                        break;
                }


                if (isBlueDone)
                    continue;

                if (isRedDone) {
                    System.out.println(current.cnt + 1);
                    return;
                }


                if (nbx == nrx && nby == nry) {
                    switch (i) {
                        case 0:
                            if (ry > by) {
                                nby--;
                            } else
                                nry--;
                            break;

                        case 1:
                            if (ry > by) {
                                nry++;
                            } else
                                nby++;
                            break;

                        case 2:
                            if (rx > bx) {
                                nbx--;
                            } else
                                nrx--;
                            break;

                        case 3:
                            if (rx > bx) {
                                nrx++;
                            } else
                                nbx++;
                            break;

                    }
                }

                if (!visited[nrx][nry][nbx][nby]) {
                    queue.offer(new Node(nrx, nry, nbx, nby, current.cnt+1));
                }

            }

        }
        System.out.println("-1");
    }


    public static void main(String[] args) throws IOException {

        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        int rx = 0, ry = 0, bx = 0, by = 0;
        visited = new boolean[N][M][N][M];
        arr = new char[N][M];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(bf.readLine());
            String temp = st.nextToken();
            for (int j = 0; j < M; j++) {
                arr[i][j] = temp.charAt(j);
                if (arr[i][j] == 'R') {
                    rx = i;
                    ry = j;
                } else if (arr[i][j] == 'B') {
                    bx = i;
                    by = j;
                }
            }
        }

        bfs(rx, ry, bx, by);


    }
}
