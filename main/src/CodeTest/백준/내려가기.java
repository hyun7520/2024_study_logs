package CodeTest.백준;

import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

// 2096
public class 내려가기 {

    static int N;
    static int[][] map;
    static int[][][] dp;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        map = new int[N][N];
        dp = new int[N][N][2];

        for(int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for(int j = 0; j < N; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        for(int i = 0; i < N; i++) {
            dp[0][i][0] = map[0][i];
            dp[0][i][1] = map[0][i];
        }

        for(int i = 1; i < N; i++) {
            for(int j = 0; j < N; j++) {
                int max;
                int min;
                if(j == 0) {
                    max = Math.max(dp[i - 1][j][0], dp[i - 1][j + 1][0]);
                    min = Math.min(dp[i - 1][j][1], dp[i - 1][j + 1][1]);
                    dp[i][j][0] = max + map[i][j];
                    dp[i][j][1] = min + map[i][j];
                }
                if(j == 1) {
                    max = Math.max(dp[i - 1][j][0], Math.max(dp[i - 1][j - 1][0], dp[i - 1][j+1][0]));
                    min = Math.min(dp[i - 1][j][1], Math.min(dp[i - 1][j - 1][1], dp[i - 1][j+1][1]));
                    dp[i][j][0] = max + map[i][j];
                    dp[i][j][1] = min + map[i][j];
                }
                if(j == 2) {
                    max = Math.max(dp[i - 1][j][0], dp[i - 1][j - 1][0]);
                    min = Math.min(dp[i - 1][j][1], dp[i - 1][j - 1][1]);
                    dp[i][j][0] = max + map[i][j];
                    dp[i][j][1] = min + map[i][j];
                }
            }
        }

        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        bw.write(Math.max(dp[N - 1][0][0], Math.max(dp[N - 1][1][0], dp[N - 1][2][0])) + " ");
        bw.write(String.valueOf(Math.min(dp[N - 1][0][1], Math.min(dp[N - 1][1][1], dp[N - 1][2][1]))));
        bw.flush();
        bw.close();
    }
}
