package CodeTest.백준;

import java.io.*;

// 2447
public class 별찍기10 {

    static char[][] map;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        map = new char[N][N];

        solution(0, 0, N, false);

        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        for(int i = 0; i < N; i++) {
            for(int j = 0; j < N; j++) {
                bw.write(map[i][j]);
            }
            bw.newLine();
        }

        bw.flush();
        bw.close();
    }

    private static void solution(int x, int y, int N, boolean bool) {

        if(bool) {
            for(int i = x; i < x + N; i++) {
                for(int j = y; j < y + N; j++) {
                    map[i][j] = ' ';
                }
            }
            return;
        }

        if(N == 1) {
            map[x][y] = '*';
            return;
        }

        int size = N / 3;
        int count = 0;
        for(int i = x; i < x + N; i += size) {
            for(int j = y; j  < y + N; j += size) {
                count++;
                if(count == 5) {
                    solution(i, j, size, true);
                }
                else {
                    solution(i, j, size, false);
                }
            }
        }
    }
}
