package CodeTest.백준;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.StringTokenizer;

// 2170
public class 선긋기 {

    static int N;
    static int[][] points;
    static int start, end;
    static int answer;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());

        points = new int[N][2];

        for(int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            points[i][0] = Integer.parseInt(st.nextToken());
            points[i][1] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(points, Comparator.comparingInt((int[] o) -> o[0]));

        start = points[0][0];
        end = points[0][1];
        answer = 0;

        for(int i = 1; i < N; i++) {
            if(points[i][0] > end) {
                answer += end - start;
                start = points[i][0];
                end = points[i][1];
            }
            if(points[i][0] <= end && points[i][1] > end) {
                end = points[i][1];
            }
        }

        answer += end - start;

        System.out.println(answer);
    }
}
