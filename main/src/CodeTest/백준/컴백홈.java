package CodeTest.백준;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 컴백홈 {

    static int R, C, K;
    static int answer;
    static char[][] map;
    static boolean[][] visit;
    static int[] dx = {-1, 0, 0, 1};
    static int[] dy = {0, -1, 1, 0};

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        R = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        map = new char[R][C];
        visit = new boolean[R][C];
        answer = 0;

        for(int i = 0; i < R; i++) {
            String temp = br.readLine();
            for(int j = 0; j < C; j++) {
                map[i][j] = temp.charAt(j);
            }
        }

        visit[R-1][0] = true;
        dfs(R-1, 0, 0);

        System.out.println(answer);
    }

    public static void dfs(int x, int y, int depth) {

        if(x == 0 && y == C - 1 && depth == K) {
            answer++;
            return;
        }

        for(int i = 0; i < 4; i++) {
            int nx = x + dx[i];
            int ny = y + dy[i];
            if(nx >= 0 && nx < R && ny >= 0 && ny < C) {
                if(!visit[nx][ny] && map[nx][ny] == '.') {
                    visit[nx][ny] = true;
                    dfs(nx, ny, depth + 1);
                    visit[nx][ny] = false;
                }
            }
        }

    }
}
