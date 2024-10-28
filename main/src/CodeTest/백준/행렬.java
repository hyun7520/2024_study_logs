package CodeTest.백준;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 행렬 {

    public static int x, y;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        x = Integer.parseInt(st.nextToken());
        y = Integer.parseInt(st.nextToken());

        int[][] A = new int[x][y];
        int[][] B = new int[x][y];

        for(int i = 0; i < x; i++) {
            String line = br.readLine();
            for(int j = 0; j < y; j++) {
                A[i][j] = line.charAt(j) - '0';
            }
        }
        for(int i = 0; i < x; i++) {
            String line = br.readLine();
            for(int j = 0; j < y; j++) {
                B[i][j] = line.charAt(j) - '0';
            }
        }

        System.out.println(solution(A, B));

    }

    public static int solution(int[][] A, int[][] B) {
        int answer = 0;

        for(int i = 0; i < x; i++) {
            for(int j = 0; j < y; j++) {
                if(A[i][j] != B[i][j] && i + 2 < x && j + 2 < y) {
                    for(int x = i; x < i + 3; x++) {
                        for(int y = j; y < j + 3; y++) {
                            A[x][y] = A[x][y] == 1 ? 0 : 1;
                        }
                    }
                    answer++;
                }
            }
        }

        for(int i = 0; i < x; i++) {
            for(int j = 0; j < y; j++) {
                if(A[i][j] != B[i][j]) return -1;
            }
        }

        return answer;
    }
}
