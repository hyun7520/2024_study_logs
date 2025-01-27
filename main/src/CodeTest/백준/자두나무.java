package CodeTest.백준;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// 2240
public class 자두나무 {

    // T - 열매가 떨어지는 시간
    // W - 움직이는 횟수
    static int T, W;
    static int[] arr;
    static int[][][] dp;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        T = Integer.parseInt(st.nextToken());
        W = Integer.parseInt(st.nextToken());
        arr = new int[T];
        dp = new int[T][W][2];

        for(int i = 0; i < T; i++) {
            arr[i] = Integer.parseInt(br.readLine());
        }

        solution();

        System.out.println(Math.max(dp[T - 1][W - 1][0], dp[T - 1][W - 1][1]));
    }

    public static void solution() {


    }
}
