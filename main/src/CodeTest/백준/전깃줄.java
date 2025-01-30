package CodeTest.백준;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.StringTokenizer;

// 2565
public class 전깃줄 {

    static int N;
    static int[][] arr;
    static int[] dp;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());
        arr = new int[N][2];
        dp = new int[N];

        for(int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            arr[i][0] = Integer.parseInt(st.nextToken());
            arr[i][1] = Integer.parseInt(st.nextToken());
        }

        // 전봇대 순서대로 정렬한다.
        Arrays.sort(arr, Comparator.comparingInt((int[] a) -> a[0]));

        // 설치할 수 있는 최대 전깃줄의 개수를 세는 과정
        for(int i = 0; i < N; i++) {

            // 현재 위치 (A) 에는 1개를 설치할 수 있다.
            dp[i] = 1;

            // A와 B의 전깃줄 연결을 살핀다.
            for(int j = 0; j < i; j++) {
                // 현재 A 위치의 전봇대와 연결된 B 전봇대가
                // 이전 A 위치의 전봇대들괴 연결된 B 전봇대보다 작다면
                // -> 전깃줄이 겹치므로 넘김
                // 겹치지 않을 경우 설치가 가능하기 때문에 이전 dp[j]에 저장된 전깃줄의 최댓값에 +1
                // 현재 dp[i]와 비교하여 최대값을 저장한다.
                if(arr[i][1] > arr[j][1]) {
                    dp[i] = Math.max(dp[i], dp[j] + 1);
                }
            }
        }

        // 설치 가능한 최대 전깃줄의 개수를 구한다.
        // 마지막에 N에서 이 값을 빼주면 삭제해야하는 최소 전깃줄을 갯수를 구할 수 있다.
        int answer = 0;
        for(int i = 0; i < N; i++) {
            answer = Math.max(answer, dp[i]);
        }

        System.out.println(N - answer);
    }
}
