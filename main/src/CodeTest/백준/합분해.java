package CodeTest.백준;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

// 2225
public class 합분해 {

    static int N, K;
    static int[][] dp;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
        dp = new int[K][N + 1];

        Arrays.fill(dp[0], 1);

        for(int i = 1; i < K; i++) {
            dp[i][0] = 1;
        }

        for(int i = 1; i < K; i++) {
            for(int j = 1; j < N + 1; j++) {
                dp[i][j] = (dp[i - 1][j] + dp[i][j-1]) % 1000000000;
            }
        }

        System.out.println(dp[K - 1][N]);
    }
}
