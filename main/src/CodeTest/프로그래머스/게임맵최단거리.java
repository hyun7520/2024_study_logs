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
        int[][] visit = new int[maps.length][maps[0].length];

        BFS(maps, visit);
        int answer = visit[maps.length - 1][maps[0].length - 1];

        if(answer == 0) {
            answer = -1;
        }

        return answer;
    }

    public void BFS(int[][] maps, int[][] visit) {
        int x = 0;
        int y = 0;
        visit[x][y] = 1;
        Queue<int[]> now = new LinkedList<>();
        now.add(new int[]{x, y});

        while(!now.isEmpty()) {
            int[] curXY = now.poll();

            for(int i = 0; i < 4; i++) {
                int moveX = curXY[0] + dx[i];
                int moveY = curXY[1] + dy[i];

                if(moveX < 0 || moveX > maps.length - 1 || moveY < 0 || moveY > maps[0].length - 1) {
                    continue;
                }

                if(visit[moveX][moveY] == 0 && maps[moveX][moveY] == 1) {
                    visit[moveX][moveY] = visit[curXY[0]][curXY[1]] + 1;
                    now.add(new int[]{moveX, moveY});
                }
            }
        }
    }
}
