package CodeTest.백준;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

// 2589
public class 보물섬 {

    static int N, M;
    static char[][] map;
    static int[][] cnt;
    static int answer;
    static final int[] dx = {0, 0, 1, -1};
    static final int[] dy = {1, -1, 0, 0};

    static class Node {
        int x;
        int y;

        public Node(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        map = new char[N][M];

        for(int i = 0; i < N; i++) {
            String temp = br.readLine();
            for(int j = 0; j < M; j++) {
                map[i][j] = temp.charAt(j);
            }
        }

        answer = Integer.MIN_VALUE;
        for(int i = 0; i < N; i++) {
            for(int j = 0; j < M; j++) {
                if(map[i][j] == 'L') {
                    bfs(i, j);
                }
            }
        }

        System.out.println(answer);
    }

    public static void bfs(int x, int y) {

        boolean[][] visit = new boolean[N][M];
        cnt = new int[N][M];
        Queue<Node> queue = new LinkedList<>();
        queue.add(new Node(x, y));
        visit[x][y] = true;

        while(!queue.isEmpty()) {

            Node cur = queue.poll();

            for(int i = 0; i < 4; i++) {
                int nx = cur.x + dx[i];
                int ny = cur.y + dy[i];
                if(nx >= 0 && nx < N && ny >= 0 && ny < M) {
                    if(map[nx][ny] == 'L' && !visit[nx][ny]) {
                        queue.add(new Node(nx, ny));
                        cnt[nx][ny] = cnt[cur.x][cur.y] + 1;
                        visit[nx][ny] = true;
                        answer = Math.max(answer, cnt[nx][ny]);
                    }
                }
            }
        }
    }
}
