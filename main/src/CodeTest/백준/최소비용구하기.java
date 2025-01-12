package CodeTest.백준;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class 최소비용구하기 {

    static int N, M, A, B;
    static int[] dist;
    static ArrayList<ArrayList<Node>> graph;

    // 노드 클래스를 생성하고 우선순위 큐를 사용할 경우 compareTo를 오버라이드 해줘야 한다.
    static class Node implements Comparable<Node> {
        private int end;
        private int fee;

        public Node(int end, int fee) {
            this.end = end;
            this.fee = fee;
        }

        @Override
        public int compareTo(Node o) {
            return fee - o.fee;
        }
    }

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        M = Integer.parseInt(br.readLine());

        dist = new int[N + 1];
        graph = new ArrayList<>();

        // 다익스트라 알고리즘 풀이를 위해 거리 배열을 모두 최대값으로 초기화
        Arrays.fill(dist, Integer.MAX_VALUE);
        // 연결된 노드를 저장하기 위한 리스트
        for(int i = 0; i < N + 1; i++) {
            graph.add(new ArrayList<>());
        }

        StringTokenizer st;
        // 리스트에 연결된 노드를 저장한다.
        for(int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int from = Integer.parseInt(st.nextToken());
            int to = Integer.parseInt(st.nextToken());
            int fee = Integer.parseInt(st.nextToken());
            Node node = new Node(to, fee);

            graph.get(from).add(node);
        }

        st = new StringTokenizer(br.readLine());
        A = Integer.parseInt(st.nextToken());
        B = Integer.parseInt(st.nextToken());

        System.out.println(solution());
    }

    // 다익스트라
    public static int solution() {

        PriorityQueue<Node> pq = new PriorityQueue<>();
        boolean[] visit = new boolean[N + 1];
        // 우선순위 큐에 시작점과 초기 거리 0을 넣어준다.
        pq.add(new Node(A, 0));
        // 거리 배열에서 시작점은 0으로 초기화
        dist[A] = 0;

        while(!pq.isEmpty()) {
            Node cur = pq.poll();
            int curEnd = cur.end;

            if(!visit[curEnd]) {
                visit[curEnd] = true;

                // 첫번째 시작점은 위에서 넣은 A 지점이다.
                // 현재 지점에서 연결된 지점을 모두 꺼내서 확인
                for(Node node : graph.get(curEnd)) {
                    // 아직 방문하지 않음 &&
                    // 출발 지점에서 다음 지점까지 가는 거리 > 출발 지점부터 현재 위치까지 온 최단 거리 + 현재 위치에서 해당 위치까지 가는 거리
                    if(!visit[node.end] && dist[node.end] > dist[curEnd] + node.fee) {
                        dist[node.end] = dist[curEnd] + node.fee;
                        pq.add(new Node(node.end, dist[node.end]));
                    }
                }
            }
        }
        return dist[B];
    }
}
