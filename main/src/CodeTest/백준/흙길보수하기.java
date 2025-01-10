package CodeTest.백준;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.StringTokenizer;

// 1911
public class 흙길보수하기 {

    // N - 웅덩이 개수, L - 널빤지의 길이
    static int N, L;
    static int[][] puddles;
    static int answer;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        L = Integer.parseInt(st.nextToken());
        puddles = new int[N][2];

        for(int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            puddles[i][0] = Integer.parseInt(st.nextToken());
            puddles[i][1] = Integer.parseInt(st.nextToken());;
        }

        Arrays.sort(puddles, Comparator.comparingInt((int[] a) -> a[0]));

        int covered = 0;
        int remain;

        for(int i = 0; i < puddles.length; i++) {

            if(puddles[i][1] < covered) {
                continue;
            }

            if(covered < puddles[i][0]) {
                covered = puddles[i][0];
            }

            remain = (puddles[i][1] - covered) % L;
            answer += (puddles[i][1] - covered) / L;
            covered = puddles[i][1];

            if(remain > 0) {
                answer++;
                covered += L - remain;
            }

        }

        System.out.println(answer);
    }
}
