package CodeTest.백준;

import java.io.*;
import java.util.StringTokenizer;

// 9084
public class coins {

    static int T;
    static int[] coins;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        T = Integer.parseInt(br.readLine());

        for(int i = 0; i < T; i++) {
            int N = Integer.parseInt(br.readLine());
            StringTokenizer st = new StringTokenizer(br.readLine());
            int target = Integer.parseInt(br.readLine());
            coins = new int[N];

            for(int j = 0; j < N; j++) {
                coins[j] = Integer.parseInt(st.nextToken());
            }

            bw.write(solution(target) + "\n");
        }

        bw.flush();
        bw.close();
    }

    public static int solution(int target) {

        int[] dp = new int[target + 1];
        dp[0] = 1;

        for(int coin : coins) {
            for(int i = 0; i < target + 1; i++) {
                if(i - coin >= 0) {
                    dp[i] = dp[i] + dp[i - coin];
                }
            }
        }

        return dp[target];
    }
}
