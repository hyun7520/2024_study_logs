package CodeTest.백준;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.StringTokenizer;


public class 제곱수찾기 {

    static int[][] map;
    static int n, m;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        map = new int[n][m];

        for(int i = 0; i < n; i++) {
            String line = br.readLine();
            for(int j = 0; j < m; j++) {
                map[i][j] = Integer.parseInt(String.valueOf(line.charAt(j)));
            }
        }

        System.out.println(solution());
    }

    public static int solution() {
        int answer = -1;

        for(int i = 0; i < n; i++) {
            for(int j = 0; j < m; j++) {
                for(int di = -n; di < n; di ++) {
                    for(int dj = -m; dj < m; dj++) {
                        if(di == 0 && dj == 0) {
                            continue;
                        }

                        int sum = 0;
                        int nRow = i;
                        int nCol = j;
                        while(nRow >= 0 && nRow < n && nCol >= 0 && nCol < m) {
                            sum = sum * 10 + map[nRow][nCol];

                            int sqrt = (int) Math.sqrt(sum);
                            if(Math.pow(sqrt, 2) == sum) {
                                answer = Math.max(sum, answer);
                            }

                            nRow += di;
                            nCol += dj;
                        }
                    }
                }
            }
        }

        return answer;
    }
}
