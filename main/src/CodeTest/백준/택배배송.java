package CodeTest.백준;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

// 5972
public class 택배배송 {

    static int N, M;
    static List<List<Node>> map;
    static boolean[] visit;
    static int[] path;

    static class Node implements Comparable<Node> {
        private int end;
        private int weight;

        public Node(int end, int weight) {
            this.end = end;
            this.weight = weight;
        }

        @Override
        public int compareTo(Node o) {
            return this.weight - o.weight;
        }
    }

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        visit = new boolean[N + 1];
        path = new int[N + 1];
        map = new ArrayList<>();

        for(int i = 0; i < N + 1; i++) {
            map.add(new ArrayList<>());
        }

        Arrays.fill(path, Integer.MAX_VALUE);
        for(int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int weight = Integer.parseInt(st.nextToken());

            map.get(b).add(new Node(a, weight));
            map.get(a).add(new Node(b, weight));
        }

        System.out.println(dijkstra(1));
    }

    public static int dijkstra(int start) {

        PriorityQueue<Node> pq = new PriorityQueue<>();
        path[start] = 0;
        pq.add(new Node(start, 0));

        while(!pq.isEmpty()) {
            Node cur = pq.poll();

            if(!visit[cur.end]) {
                visit[cur.end] = true;

                for(Node node : map.get(cur.end)) {
                    if(!visit[node.end] && path[node.end] > path[cur.end] + node.weight) {
                        path[node.end] = path[cur.end] + node.weight;
                        pq.add(new Node(node.end, path[node.end]));
                    }
                }
            }
        }

        return path[N];
    }
}
