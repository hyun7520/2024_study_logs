package CodeTest.백준;

import java.io.*;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class 농장관리 {

    static int[][] map;
    static boolean[][] isPeak;
    static boolean[][] visit;
    static int n, m;
    static int answer = 0;
    // 상하좌우 + 대각선 방향도 확인
    static int[] dx = {-1, 0, 0, 1, -1, 1, -1, 1};
    static int[] dy = {0, -1, 1, 0, -1, -1, 1, 1};

    static class Node {
        int x, y;
        public Node(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        map = new int[n][m];
        isPeak = new boolean[n][m];

        for(int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for(int j = 0; j < m; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        for(int i = 0; i < n; i++) {
            for(int j = 0; j < m; j++) {
                if(!isPeak[i][j]) {
                    solution(i, j);
                }
            }
        }

        bw.write(String.valueOf(answer));
        bw.flush();
        bw.close();
    }

    public static void solution(int x, int y) {

        Queue<Node> queue = new LinkedList<>();
        visit = new boolean[n][m];
        visit[x][y] = true;
        HashSet<Node> peaks = new HashSet<>();
        queue.add(new Node(x, y));

        while(!queue.isEmpty()) {

            Node cur = queue.poll();

            for(int i = 0; i < 8; i++) {
                int nx = cur.x + dx[i];
                int ny = cur.y + dy[i];
                if(nx >= 0 && ny >= 0 && nx < n && ny < m && !visit[nx][ny]) {
                    if(map[cur.x][cur.y] < map[nx][ny]) {
                        return;
                    }
                    else if(map[cur.x][cur.y] == map[nx][ny]) {
                        queue.add(new Node(nx, ny));
                        peaks.add(new Node(nx, ny));
                    }
                    visit[nx][ny] = true;
                }
            }
        }

        for(Node peak : peaks) {
            isPeak[peak.x][peak.y] = true;
        }
        answer++;
    }
}
