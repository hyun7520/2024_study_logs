package CodeTest.백준;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 성지키기 {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int row = 0, col = 0;
        boolean flag;

        boolean[][] arr = new boolean[n][m];

        for(int i = 0; i < n; i++) {
            String[] temp = br.readLine().split("");
            for(int j = 0; j < m; j++) {
                if(temp[j].equals("X")) {
                    arr[i][j] = true;
                }
            }
        }

        for (int i = 0; i < n; i++) {
            flag = false;
            for (int j = 0; j < m; j++) {
                if (arr[i][j]) {
                    flag = true;
                    break;
                }
            }
            if (!flag) {
                row++;
            }
        }

        for (int i = 0; i < m; i++) {
            flag = false;
            for (int j = 0; j < row; j++) {
                if (arr[j][i]) {
                    flag = true;
                    break;
                }
            }
            if (!flag) col++;
        }

        System.out.println(Math.max(row, col));
    }
}
