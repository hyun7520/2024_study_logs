package CodeTest.백준;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class 전쟁전투 {

    static int N, M;
    static char[][] map;
    static boolean[][] visited;
    static int[] dx = {-1, 0, 1, 0};
    static int[] dy = {0, -1, 0, 1};
    static int w, b;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        map = new char[M][N];
        visited = new boolean[M][N];

        for(int i = 0; i < M; i++) {
            String line = br.readLine();
            for(int j = 0; j < N; j++) {
                map[i][j] = line.charAt(j);
            }
        }

        for(int i = 0; i < M; i++) {
            for(int j = 0; j < N; j++) {
                if(!visited[i][j]) {
                    visited[i][j] = true;
                    Node start = new Node(i, j);
                    bfs(start, map[i][j]);
                }
            }
        }

        System.out.println(w + " " + b);
    }

    static void bfs(Node node, char side) {

        Queue<Node> queue = new LinkedList<Node>();

        queue.offer(node);

        int cnt = 1;

        while(!queue.isEmpty()) {
            Node cur = queue.poll();
            for(int k = 0; k < 4; k++) {
                int nx = cur.x + dx[k];
                int ny = cur.y + dy[k];
                if(nx < 0 || ny < 0 || nx >= M || ny >= N) {
                    continue;
                }
                if(map[nx][ny] == side && !visited[nx][ny]) {
                    visited[nx][ny] = true;
                    queue.offer(new Node(nx, ny));
                    cnt++;
                }
            }
        }

        if(side == 'W') {
            w += (cnt * cnt);
        } else {
            b += (cnt * cnt);
        }
    }

    static class Node {

        private int x;
        private int y;

        public Node(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
}
