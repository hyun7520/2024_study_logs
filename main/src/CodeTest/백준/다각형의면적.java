package CodeTest.백준;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// 2166
public class 다각형의면적 {

    static double[][] xy;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        xy = new double[N + 1][2];

        for(int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            xy[i][0] = Double.parseDouble(st.nextToken());
            xy[i][1] = Double.parseDouble(st.nextToken());
        }

        xy[N][0] = xy[0][0];
        xy[N][1] = xy[0][1];

        double sum = 0;
        
        // https://ko.wikihow.com/%EB%8B%A4%EA%B0%81%ED%98%95-%EB%84%93%EC%9D%B4-%EA%B5%AC%ED%95%98%EA%B8%B0
        // 다각형의 넓이 구하기 공식 참고 사이트
        for(int i = 1; i < N + 1; i++) {
            sum += xy[i-1][0] * xy[i][1];
            sum -= xy[i-1][1] * xy[i][0];
        }

        System.out.printf("%.1f", Math.abs(sum / 2));
    }
}
