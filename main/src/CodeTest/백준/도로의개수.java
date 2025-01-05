package CodeTest.백준;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// 1577
public class 도로의개수 {

    static int N, M, K;
    static boolean[][][] isBlocked;
    static long[][] dp;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(br.readLine());

        // N, M을 바꿔 생각하기 편하게
        // 지도의 시작은 좌측상단끝 도착지점은 우측하단끝으로 변경
        isBlocked = new boolean[M + 1][N + 1][2];
        dp = new long[M + 1][N + 1];

        for (int i = 0; i < K; i++) {
            st = new StringTokenizer(br.readLine());
            // N과 M을 바꿨기 때문에 막힌 길에 대한 좌표의 입력 순서도 반대로
            int y1 = Integer.parseInt(st.nextToken());
            int x1 = Integer.parseInt(st.nextToken());
            int y2 = Integer.parseInt(st.nextToken());
            int x2 = Integer.parseInt(st.nextToken());

            // 항상 최단 거리로만 다니기때문에 현재 좌표에서 하 또는 우로만 이동이 가능하다.
            // isBlocked에 이동 가능 여부를 저장해주는 과정 -> 0은 하단 이동 가능 여부, 1은 우측 이동 가능 여부
            if(x1 < x2 || y1 < y2) { // 좌표간의 연결이 작은 쪽에서 큰 쪽으로 되도록
                // 하단으로 이동이 불가능
                if(x1 < x2) {
                    isBlocked[x1][y1][1] = true;
                }
                // 우측으로 이동이 불가능
                else {
                    isBlocked[x1][y1][0] = true;
                }
            }
            else {
                if(x2 < x1) {
                    isBlocked[x2][y2][1] = true;
                }
                else {
                    isBlocked[x2][y2][0] = true;
                }
            }
        }

        // dp 계산 시작의 위해 첫 경로를 1로 초기화
        // (0,0) 부터 (0,N) -> 첫 가로줄을 1로 초기화, 막힐 시 종료
        for (int i = 1; i < N + 1; i++) {
            if (isBlocked[0][i - 1][0]) {
                break;
            }
            dp[0][i] = 1;
        }
        // (0,0) 부터 (M,0) -> 첫 세로줄 계산 위와 같은 과정
        for (int i = 1; i < M + 1; i++) {
            if (isBlocked[i - 1][0][1]) {
                break;
            }
            dp[i][0] = 1;
        }

        // dp 계산 시작
        for (int i = 1; i < M + 1; i++) {
            for (int j = 1; j < N + 1; j++) {
                if (!isBlocked[i][j - 1][0]) {
                    dp[i][j] += dp[i][j - 1];
                }
                if (!isBlocked[i - 1][j][1]) {
                    dp[i][j] += dp[i - 1][j];
                }
            }
        }

        System.out.println(dp[M][N]);
    }
}
