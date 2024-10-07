package CodeTest.카카오코테;

import java.util.*;

public class 등산코스정하기 {
    List<List<Node>> graph;

    public class Node {
        int node;
        int distance;
        public Node(int node, int distance) {
            this.node = node;
            this.distance = distance;
        }
    }

    public int[] solution(int n, int[][] paths, int[] gates, int[] summits) {

        graph = new ArrayList<>();

        for(int i = 0; i < n + 1; i++) {
            graph.add(new ArrayList<>());
        }

        for(int[] path: paths) {
            int from = path[0];
            int to = path[1];
            int dist = path[2];

            if(isGate(from, gates) || isSummit(to, summits)) {
                graph.get(from).add(new Node(to, dist));
            } else if(isGate(to, gates) || isSummit(from, summits)) {
                graph.get(to).add(new Node(from, dist));
            } else {
                graph.get(from).add(new Node(to, dist));
                graph.get(to).add(new Node(from, dist));
            }
        }

        return dijkstra(n, gates, summits);
    }

    public int[] dijkstra(int n, int[] gates, int[] summits) {
        int[] intensity = new int[n+1];
        Queue<Node> queue = new LinkedList<>();

        Arrays.fill(intensity, Integer.MAX_VALUE);

        for(int gate : gates) {
            queue.add(new Node(gate, 0));
            intensity[gate] = 0;
        }

        while(!queue.isEmpty()) {

            Node curNode = queue.poll();

            if(intensity[curNode.node] < curNode.distance) continue;

            for(int i = 0; i < graph.get(curNode.node).size(); i++) {
                Node moveTo = graph.get(curNode.node).get(i);

                int moveToIntensity = Math.max(intensity[curNode.node], moveTo.distance);
                if(intensity[moveTo.node] > moveToIntensity) {
                    intensity[moveTo.node] = moveToIntensity;
                    queue.add(new Node(moveTo.node, moveToIntensity));
                }
            }
        }

        int ansSummit = 0;
        int ansMin = Integer.MAX_VALUE;

        Arrays.sort(summits);

        for(int summit : summits) {
            if(intensity[summit] < ansMin) {
                ansMin = intensity[summit];
                ansSummit = summit;
            }
        }
        return new int[] {ansSummit, ansMin};
    }

    public boolean isGate(int node, int[] gates){
        for (int gate : gates) {
            if (node == gate) return true;
        }
        return false;
    }

    public boolean isSummit(int node, int[] summits) {
        for(int summit : summits) {
            if(node == summit) return true;
        }
        return false;
    }
}
