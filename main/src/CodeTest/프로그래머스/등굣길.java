package CodeTest.프로그래머스;

public class 등굣길 {
    public static void main(String[] args) {

        등굣길Solution sol = new 등굣길Solution();

        System.out.println(sol.solution(4, 3, new int[][]{{2, 2}}));
    }
}

class 등굣길Solution {

    int[][] map;

    public int solution(int m, int n, int[][] puddles) {

        map = new int[n + 1][m + 1];

        for(int[] puddle: puddles) {
            map[puddle[1]][puddle[0]] = -1;
        }

        map[1][1] = 1;
        for(int i = 1; i <= n; i++) {
            for(int j = 1; j <= m; j++) {
                if(map[i][j] == -1) {
                    continue;
                }
                if(map[i - 1][j] > 0) {
                    map[i][j] += map[i - 1][j] % 1000000007;
                }
                if(map[i][j - 1] > 0) {
                    map[i][j] += map[i][j - 1] % 1000000007;
                }
            }
        }

        return map[n][m] % 1000000007;
    }
}
