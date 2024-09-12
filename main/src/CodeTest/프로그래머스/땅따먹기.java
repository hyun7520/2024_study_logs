package CodeTest.프로그래머스;

import java.util.Collections;
import java.util.PriorityQueue;

public class 땅따먹기 {

    public static void main(String[] args) {

        땅따먹기Solution sol = new 땅따먹기Solution();

        System.out.println( sol.solution(new int[][] {{1,2,3,5}, {5,6,7,8}, {4,3,2,1}}) );

    }
}

class 땅따먹기Solution {

    public int solution(int[][] land) {
        int answer = 0;

        for(int i = 1; i < land.length; i++) {
            land[i][0] += Math.max(land[i-1][1], Math.max(land[i-1][2], land[i-1][3]));
            land[i][1] += Math.max(land[i-1][0], Math.max(land[i-1][2], land[i-1][3]));
            land[i][2] += Math.max(land[i-1][0], Math.max(land[i-1][1], land[i-1][3]));
            land[i][3] += Math.max(land[i-1][0], Math.max(land[i-1][1], land[i-1][2]));
        }

        for(int i = 0; i < 4; i++) {
            answer = Math.max(answer, land[land.length - 1][i]);
        }

        return answer;
    }

}

class 땅따먹기DfsSolution {

    static boolean[][] visit;
    static int tempAns;

    public int solution(int[][] land) {

        visit = new boolean[land.length][4];

        dfs(0, 0, land);

        return tempAns;
    }
    public void dfs(int depth, int sum, int[][] land) {
        if(depth == land.length) {
            tempAns = Math.max(sum, tempAns);
            return;
        }

        for(int i = 0; i < 4; i++) {
            if(!visit[depth][i]) {
                sum += land[depth][i];
                if(depth < land.length - 1) {
                    visit[depth + 1][i] = true;
                }
                dfs(depth + 1, sum, land);
                if(depth < land.length - 1) {
                    visit[depth + 1][i] = false;
                }
                sum -= land[depth][i];
            }
        }
    }
}
