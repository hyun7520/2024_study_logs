package CodeTest.프로그래머스;

public class 타일링2xN {
    public int solution(int n) {
        int answer = 0;

        int[] dp = new int[n];
        dp[0] = 1;
        dp[1] = 2;

        for(int i = 2; i < n; i++) {
            dp[i] = (dp[i-1] + dp[i-2]) % 1000000007;
        }
        answer = dp[n-1];

        return answer;
    }
}
