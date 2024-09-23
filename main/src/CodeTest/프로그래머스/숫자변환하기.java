package CodeTest.프로그래머스;

public class 숫자변환하기 {
    public static void main(String[] args) {
        숫자변환하기Solution sol = new 숫자변환하기Solution();

        System.out.println(sol.solution(10, 40, 30));
    }
}

class 숫자변환하기Solution {

    public int solution(int x, int y, int n ) {

        int[] dp = new int[y+1];
        dp[x] = 0;

        for(int i = x; i <= y; i++) {
            if(i != x && dp[i] == 0) {
                dp[i] = -1;
                continue;
            }
            if(i * 2 <= y) {
                dp[i * 2] = dp[i * 2] == 0 ? dp[i] + 1 : Math.min(dp[i] + 1, dp[i * 2]);
            }
            if(i * 3 <= y) {
                dp[i * 3] = dp[i * 3] == 0 ? dp[i] + 1 : Math.min(dp[i] + 1, dp[i * 3]);
            }
            if(i + n <= y) {
                dp[i + n] = dp[i + n] == 0 ? dp[i] + 1 : Math.min(dp[i] + 1, dp[i + n]);
            }
        }

        return dp[y];
    }
}