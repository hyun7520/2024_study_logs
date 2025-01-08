package CodeTest.백준;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

// 1660
public class 캡틴이다솜 {

    static int n;
    static int[] dp;
    static int[] cnt;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());

        dp = new int[300000];
        cnt = new int[n + 1];
        int idx = 2;
        int endIdx;
        dp[1] = 1;

        while(true) {
            dp[idx] = dp[idx - 1] + idx;
            if(dp[idx] >= 300000) {
                endIdx = idx;
                break;
            }
            idx++;
        }

        for(int i = 1; i < endIdx; i++) {
            dp[i] = dp[i-1] + dp[i];
        }

        Arrays.fill(cnt, Integer.MAX_VALUE);
        cnt[0] = 0;
        cnt[1] = 1;
        // cnt 배열의 i는 대포의 개수를 의미
        for(int i = 2; i <= n; i++) {
            for(int j = 1; j < endIdx; j++) {
                if(dp[j] > i) break; // 현재 층의 사면체 개수가 입력된 대포아르이 개수보다 크면 break
                // 2개일 경우 부터 구한다.
                cnt[i] = Math.min(cnt[i], cnt[i - dp[j]] + 1);
            }
        }

        System.out.println(cnt[n]);
    }
}
