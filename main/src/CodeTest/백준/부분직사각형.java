package CodeTest.백준;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 부분직사각형 {

    static char[][] map;
    static long[][] squareMap;
    static long[] answer;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        map = new char[n * 2][m * 2];
        squareMap = new long[n * 2][m * 2];
        answer = new long[26];

        for(int i = 0; i < n; i++) {
            String temp = br.readLine();
            for(int j = 0; j < m; j++) {
                map[i][j] = temp.charAt(j);
                map[i][j+m] = temp.charAt(j);
                map[i+n][j] = temp.charAt(j);
                map[i+n][j+m] = temp.charAt(j);
            }
        }

        for(int i = 0; i < n * 2 ; i++) {
            for(int j = 0; j < m * 2; j++) {
                squareMap[i][j] = (i + 1) * (j + 1) * (n * 2L - i) * (m * 2L - j);
            }
        }

        for(int i = 1; i < n * 2; i++) {
            for(int j = 1; j < m * 2; j++) {
                answer[map[i][j] - 'A'] += squareMap[i][j];
            }
        }

        for(long ans : answer) {
            System.out.println(ans);
        }

    }
}
