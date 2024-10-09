package CodeTest.카카오코테;

import java.util.LinkedList;
import java.util.Queue;

public class 게임맵최단거리 {
    int[] dx = {0, 1, 0, -1};
    int[] dy = {1, 0, -1, 0};
    boolean[][] visited;
    int answer = -1;

    public int solution(int[][] maps) {

        visited = new boolean[maps.length][maps[0].length];

        bfs(maps);

        return answer;
    }

    public void bfs(int[][] maps) {

        Queue<Node> queue = new LinkedList<>();

        queue.add(new Node(0, 0, 1));
        visited[0][0] = true;

        while(!queue.isEmpty()) {

            Node now = queue.poll();
            if(now.row == maps.length - 1 && now.col == maps[0].length - 1) {
                answer = now.count;
                return;
            }

            for(int i = 0; i < 4; i++) {
                int moveX = now.row + dx[i];
                int moveY = now.col + dy[i];

                if(moveX >= 0 && moveX < maps.length && moveY >= 0 && moveY < maps[0].length && !visited[moveX][moveY] && maps[moveX][moveY] != 0) {
                    visited[moveX][moveY] = true;
                    queue.add(new Node(moveX, moveY, now.count+1));
                }
            }
        }

    }

    class Node {
        int row;
        int col;
        int count;

        public Node(int row, int col, int count) {
            this.row = row;
            this.col = col;
            this.count = count;
        }
    }
}
