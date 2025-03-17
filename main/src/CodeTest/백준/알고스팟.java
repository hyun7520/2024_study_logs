package CodeTest.백준;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

// 1261
public class 알고스팟 {

    static int M, N, min;
    static int[][] map;
    static int[] dx = {1, 0, 0, -1};
    static int[] dy = {0, 1, -1, 0};

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        M = Integer.parseInt(st.nextToken());
        N = Integer.parseInt(st.nextToken());
        map = new int[N][M];
        min = Integer.MAX_VALUE;

        for(int i = 0; i < N; i++) {
            String line = br.readLine();
            for(int j = 0; j < M; j++) {
                map[i][j] = line.charAt(j) - '0';
            }
        }
        System.out.println(bfs(0, 0));
    }

    public static int bfs(int x, int y) {

        PriorityQueue<Node> pq = new PriorityQueue<>();
        pq.offer(new Node(x, y, 0));
        boolean[][] visit = new boolean[N][M];
        visit[x][y] = true;

        while(!pq.isEmpty()) {
            Node node = pq.poll();

            if(node.x == N - 1 && node.y == M - 1) {
                return node.cnt;
            }

            for(int i = 0; i < 4; i++) {
                int nx = node.x + dx[i];
                int ny = node.y + dy[i];

                if(nx < 0 || ny < 0 || nx > N - 1 || ny > M - 1) {
                    continue;
                }

                if(!visit[nx][ny]) {
                    if(map[nx][ny] == 0) {
                        visit[nx][ny] = true;
                        pq.offer(new Node(nx, ny, node.cnt));
                    }
                    if(map[nx][ny] == 1) {
                        visit[nx][ny] = true;
                        pq.offer(new Node(nx, ny, node.cnt + 1));
                    }
                }
            }
        }
        return -1;
    }

    static class Node implements Comparable<Node> {
        int x, y, cnt;

        Node(int x, int y, int cnt) {
            this.x = x;
            this.y = y;
            this.cnt = cnt;
        }

        @Override
        public int compareTo(Node o) {
            return cnt - o.cnt;
        }

    }
}
