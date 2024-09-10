package CodeTest.프로그래머스;

public class 방문길이 {
    public static void main(String[] args) {

        방문길이Solution sol = new 방문길이Solution();

        System.out.print(sol.solution("LULLLLLLU"));

    }
}

class 방문길이Solution {

    static int[] dx = {0, -1, 0, 1};
    static int[] dy = {-1, 0, 1, 0};

    public int solution(String dirs) {
        int answer = 0;

        boolean[][][] visit = new boolean[11][11][4];

        int startX = 5;
        int startY = 5;
        int moveX, moveY;
        int direction = 0;

        for(int i = 0; i < dirs.length(); i++) {
            char moveTo = dirs.charAt(i);

            if(moveTo == 'U') {
                direction = 0;
            }
            if(moveTo == 'L') {
                direction = 1;
            }
            if(moveTo == 'D') {
                direction = 2;
            }
            if(moveTo == 'R') {
                direction = 3;
            }

            moveX = startX + dx[direction];
            moveY = startY + dy[direction];

            if(moveX > 10 || moveX < 0 || moveY > 10 || moveY < 0) {
                continue;
            }

            if(!visit[moveX][moveY][direction]) {

                visit[moveX][moveY][direction] = true;
                direction = (direction % 2 == 0) ? 2 - direction : 4 - direction;
                visit[startX][startY][direction] = true;
                answer++;
            }

            startX = moveX;
            startY = moveY;
        }

        return answer;
    }
}
