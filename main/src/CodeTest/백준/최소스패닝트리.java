package CodeTest.백준;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;

// 1197
public class 최소스패닝트리 {

    static int V, E;
    static int[] parents;
    static List<Node> nodes;

    static class Node implements Comparable<Node> {
        private int from, to, weight;

        public Node(int from, int to, int weight) {
            this.from = from;
            this.to = to;
            this. weight = weight;
        }

        // Collections의 sort를 사용하기 위해 override
        @Override
        public int compareTo(Node n) {
            return this.weight - n.weight;
        }
    }

    // 크루스칼 알고리즘을 통해 풀이
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        V = Integer.parseInt(st.nextToken());
        E = Integer.parseInt(st.nextToken());
        parents = new int[V + 1];
        nodes = new ArrayList<>();

        for(int i = 0; i < V; i++) {
            st = new StringTokenizer(br.readLine());
            int from = Integer.parseInt(st.nextToken());
            int to = Integer.parseInt(st.nextToken());
            int weight = Integer.parseInt(st.nextToken());
            Node node = new Node(from, to, weight);
            nodes.add(node);
        }

        // 가중치를 기준으로 오름차순으로 정렬
        Collections.sort(nodes);
        // 오버라이드 없이 할려면 람다식을 사용해도 된다.
        // nodes.sort((o1, o2) -> o1.weight - o2.weight);

        // 부모 노드 초기화
        // 자기 자신이 부모 노드가 되도록
        for(int i = 1; i <= V; i++) {
            parents[i] = i;
        }

        int sum = 0;
        int cnt = 0;

        for(Node n: nodes) {
            // 사이클을 형성하지 않을 경우 간선의 가중치를 합에 더해준다.
            // 오름차순으로 정렬했기 때문에 자동으로 최솟값을 구할 수 있다.
            if(union(n.from, n.to)) {
                sum += n.weight;
                cnt++;

                if(cnt == E - 1) break;
            }
        }

        System.out.println(sum);
    }

    public static boolean union(int from, int to) {
        // 현재 간선의 시작노드와 도착노드의 부모를 확인한다.
        int fromCur = findParent(from);
        int toCur = findParent(to);

        // 부모 노드가 같게 되면 사이클이므로 false
        if(fromCur == toCur) return false;
        // 부모가 다를 경우 한 그룹으로 묶어준다.
        else parents[toCur] = fromCur;
        return true;
    }

    public static int findParent(int idx) {
        // 부모를 찾았다면 부모 노드를 return
        if(parents[idx] == idx) {
            return idx;
        }
        else {
            return parents[idx] = findParent(parents[idx]);
        }
    }
}
