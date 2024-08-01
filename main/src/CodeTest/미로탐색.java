package CodeTest;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class 미로탐색 {

    static Queue<int[]> queue;
    static int[][] arr;
    static boolean[][] visit;
    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};
    static int N, M;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        arr = new int[N][M];
        visit = new boolean[N][M];

        for(int i = 0; i < N; i++) {
            String line = br.readLine();
            for(int j = 0; j < M; j++) {
                arr[i][j] = line.charAt(j) - '0';
            }
        }

        visit[0][0] = true;
        bfs(0, 0);
        System.out.println(arr[N-1][M-1]);
    }

    public static void bfs(int startX, int startY) {
        queue = new LinkedList<>();
        queue.add(new int[] {startX, startY});

        while(!queue.isEmpty()) {
            int[] now = queue.poll();
            int x = now[0];
            int y = now[1];

            for(int i = 0; i < 4; i++) {
                int moveX = x + dx[i];
                int moveY = y + dy[i];

                if(moveX < 0 || moveY < 0 || moveX >= N || moveY >= M) {
                    continue;
                }
                if(visit[moveX][moveY] || arr[moveX][moveY] == 0) {
                    continue;
                }
                queue.add(new int[] {moveX, moveY});
                arr[moveX][moveY] = arr[x][y] + 1;
                visit[moveX][moveY] = true;
            }
        }

    }
}
