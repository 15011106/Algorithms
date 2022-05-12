import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class p5719 {

    static class Node implements Comparable<Node> {
        int d;
        int w;

        public Node(int d, int w) {
            this.d = d;
            this.w = w;

        }

        public int compareTo(Node o) {
            return w - o.w;
        }
    }

//    static void dfs (int current, int sum) {
//
//        if (current == d) {
//            ans.add(sum);
//            System.out.println(ans);
//
//        } else {
//            for (int i = 0; i < n; i++) {
//                if (arr[current][i] != 0 && !visited[current]) {
//                    visited[current]= true;
//                    sum += arr[current][i];
//                    current = i;
//                    dfs(current, sum);
//                    visited[current] = false;
//                }
//
//            }
//        }
//    }

//    static void remove(int current){
//
//        if(route[current].size() == 0){
//            return;
//        }
//
//        for(int i=0; i<route[current].size(); i++){
//            int before = route[current].get(i);
//            for(int j=0 ; j<list[before].size(); j++){
//                if(list[before].get(j).d == current){
//                    list[before].remove(j);
//                }
//            }
//            if()
//            remove(before);
//        }
//    }


    static void remove(int current){

        if ( current == s){
            return;
        }

        for(int before : route[current]){
            if(!visited[before][current]){
                visited[before][current] = true;
                remove(before);
            }
        }
    }

    static void dijkstra(int start) {
        PriorityQueue<Node> pq = new PriorityQueue<>();
        pq.offer(new Node(start, 0));
        dist[start] = 0;

        while (!pq.isEmpty()) {

            Node curNode = pq.poll();
            int curW = curNode.w;

            if (dist[curNode.d] < curW)
                continue;

            for (Node nextNode : list[curNode.d]) {

                if(visited[curNode.d][nextNode.d]){
                    continue;
                }

                if (dist[nextNode.d] > nextNode.w + dist[curNode.d]) {
                    dist[nextNode.d] = nextNode.w + dist[curNode.d];

                    pq.offer(new Node(nextNode.d, dist[nextNode.d]));
                    route[nextNode.d].clear();
                    route[nextNode.d].add(curNode.d);
                } else if (dist[nextNode.d] == nextNode.w + dist[curNode.d]) {
                    route[nextNode.d].add(curNode.d);
                }
            }


        }
    }

    static ArrayList<Node>[] list;
    static int[] dist;
    static int[][] arr;
    static int s, d, n, m, sum;
    static boolean[][] visited;
    static ArrayList<Integer>[] route;
    static boolean[][] bRoute;
    static int INF = Integer.MAX_VALUE;

    public static void main(String[] args) throws IOException {


        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;



        while (true){

            st = new StringTokenizer(bf.readLine());
            n = Integer.parseInt(st.nextToken());
            m = Integer.parseInt(st.nextToken());

            if(n == 0 && m ==0)
                break;

            arr = new int[n][n];
            list = new ArrayList[n];
            bRoute = new boolean[n][n];
            dist = new int[n];

            route = new ArrayList[n];
            sum = 0;

            visited = new boolean[n][n];

            for (int i = 0; i < n; i++) {
                list[i] = new ArrayList<>();
                route[i] = new ArrayList<>();
            }

            Arrays.fill(dist, INF);

            st = new StringTokenizer(bf.readLine());

            s = Integer.parseInt(st.nextToken());
            d = Integer.parseInt(st.nextToken());

            for (int i = 0; i < m; i++) {

                st = new StringTokenizer(bf.readLine());

                int u = Integer.parseInt(st.nextToken());
                int v = Integer.parseInt(st.nextToken());
                int p = Integer.parseInt(st.nextToken());

                list[u].add(new Node(v, p));

            }

            dijkstra(s);
            remove(d);

//            Stack<Integer> stack = new Stack<>();
//            while (!route[d].isEmpty()) {
//
//                int current = d;
//                while (current != s) {
//                    stack.push(current);
//                    int before = current;
//
//                    current = route[current].get(route[current].size() - 1);
//                    route[before].remove(route[before].size() - 1);
//
//                }
//
//                while (!stack.empty()) {
//                    sRoute.add(stack.pop());
//                }
//
//                for (int x : sRoute) {
//                    for (int i = 0; i < list[current].size(); i++) {
//                        if (list[current].get(i).d == x) {
//                            list[current].remove(i);
//                            current = x;
//                        }
//                    }
//                }
//
//            }

            Arrays.fill(dist, INF);
            dijkstra(s);
            if(dist[d] != INF){
                System.out.println(dist[d]);
            }
            else
                System.out.println("-1");

        }
    }
}