package CodeTest.카카오코테;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class 도넛과막대그래프 {
    public static void main(String[] args) {

        System.out.println(Arrays.toString(solution( new int[][] {{2,3}, {4, 3}, {1, 1},{2, 1}} )));
    }

    public static int[] solution(int[][] edges) {
        int[] answer = new int[4];
        Map<Integer, Integer> in = new HashMap<>();
        Map<Integer, Integer> out = new HashMap<>();

        answer[0] = edges[0][0];

        for(int[] edge: edges){
            in.put(edge[1], in.getOrDefault(edge[1], 0) + 1);
            out.put(edge[0], out.getOrDefault(edge[0], 0) + 1);
        }

        for(int node : out.keySet()) {
            if(out.get(node) > 1) {
                if(!in.containsKey(node)) {
                    answer[0] = node;
                } else {
                    answer[3]++;
                }
            }
        }

        for(int node: in.keySet()) {
            if(!out.containsKey(node)) {
                answer[2]++;
            }
        }

        answer[1] = out.get(answer[0]) - answer[2] - answer[3];

        return answer;
    }
}
