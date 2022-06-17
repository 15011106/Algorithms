import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class p1647 {
    static class Node implements Comparable<Node> {
        int s;
        int d;
        int w;

        public Node(int s, int d, int w) {
            this.s = s;
            this.d = d;
            this.w = w;
        }

        public int compareTo(Node o) {
            return w - o.w;
        }
    }

        static void union(int x, int y) {

            x = find(x);
            y = find(y);

            if (x < y) {
                parent[y] = x;
            } else {
                parent[x] = y;
            }


        }

        static int find(int x) {

            if (parent[x] == x) {
                return x;
            } else {
                parent[x] = find(parent[x]);
                return parent[x];
            }
        }

        static int[] parent;

        public static void main(String[] args) throws IOException {

            BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
            StringTokenizer st = new StringTokenizer(bf.readLine());
            PriorityQueue<Node> arr = new PriorityQueue<>();

            int max = Integer.MIN_VALUE;
            int sum = 0;

            int N = Integer.parseInt(st.nextToken());
            int M = Integer.parseInt(st.nextToken());

            parent = new int[N + 1];

            for (int i = 0; i <= N; i++) {
                parent[i] = i;
            }
            for (int i = 0; i < M; i++) {
                st = new StringTokenizer(bf.readLine());

                int s = Integer.parseInt(st.nextToken());
                int d = Integer.parseInt(st.nextToken());
                int v = Integer.parseInt(st.nextToken());

                arr.add(new Node(s, d, v));

            }

            while (!arr.isEmpty()) {
                Node current = arr.poll();
                if (find(current.s) != find(current.d)) {
                    union(current.s, current.d);
                    sum += current.w;
                    if (max < current.w) {
                        max = current.w;
                    }
                }
            }

            System.out.println(sum - max);


        }
    }
