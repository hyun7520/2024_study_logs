package CodeTest.백준;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// 1405
public class 미친로봇 {

    static int N;
    static int[] dx = {0, 0, 1, -1};
    static int[] dy = {1, -1, 0, 0};
    static boolean[][] visited;
    static double[] move;
    static double answer;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        visited = new boolean[30][30];
        move = new double[4];

        for(int i = 0; i < 4; i++) {
            move[i] = Double.parseDouble(st.nextToken()) * 0.01;
        }

        answer = 0;
        visited[15][15] = true;
        dfs(15, 15, 0, 1);

        System.out.println(answer);
    }

    public static void dfs(int x, int y, int moved, double total) {

        if(moved == N) {
            answer += total;
            return;
        }

        for(int i = 0; i < 4; i++) {
            int nx = x + dx[i];
            int ny = y + dy[i];

            if(nx > 0 && ny > 0 && nx < 30 && ny < 30) {
                if(!visited[nx][ny]) {
                    visited[nx][ny] = true;
                    dfs(nx, ny, moved + 1, total * move[i]);
                    visited[nx][ny] = false;
                }
            }
        }

    }
}
