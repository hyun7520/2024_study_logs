package CodeTest.프로그래머스;

import java.util.LinkedList;
import java.util.Queue;

public class 게임맵최단거리 {
    public static void main(String[] args) {

        게임맵최단거리Solution sol = new 게임맵최단거리Solution();

        int[][] maps = {{1,0,1,1,1}, {1,0,1,0,1}, {1,0,1,1,1}, {1,1,1,0,1}, {0,0,0,0,1}};

        System.out.println(sol.solution(maps));

    }
}

class 게임맵최단거리Solution {

    static int[] dx = {1, -1, 0, 0};
    static int[] dy = {0, 0, 1, -1};

    public int solution(int[][] maps) {
        int answer = -1;

        boolean[][] visit = new boolean[maps.length][maps[0].length];

        BFS(maps, visit);

        return answer;
    }

    public void BFS(int[][] maps, boolean[][] visit) {
        int x = 0;
        int y = 0;
        visit[x][y] = true;
        Queue<int[]> now = new LinkedList<>();
        now.add(new int[]{x, y});

        while(!now.isEmpty()) {
            int[] curXY = now.poll();
            int moveX = curXY[0] +
        }
    }
}
