package CodeTest.프로그래머스;

public class 피로도 {
    public static void main(String[] args) {
        피로도Solution sol = new 피로도Solution();

        int[][] dungeons = {{80, 20}, {50, 40}, {30, 10}};

        System.out.println(sol.solution(80, dungeons));
    }
}

class 피로도Solution {

    static boolean[] visit;
    static int count = 0;

    public int solution(int k, int[][] dungeons) {

        visit = new boolean[dungeons.length];
        DFS(0, k, dungeons);
        return count;
    }

    public void DFS(int depth, int k, int[][] dungeons) {
        for (int i = 0; i < dungeons.length; i++) {
            if (visit[i] || dungeons[i][0] > k) {
                continue;
            }
            visit[i] = true;
            DFS(depth + 1, k - dungeons[i][1], dungeons);
            visit[i] = false;
        }

        count = Math.max(count, depth);
    }
}
