package CodeTest.카카오코테;

public class 미로탈출명령어 {

    public static void main(String[] args) {
        System.out.println(solution(3, 4, 2, 3, 3, 1, 5));
    }

    static int[] dx = {1, 0, 0, -1};
    static int[] dy = {0, -1, 1, 0};
    static String[] dir = {"d", "l", "r", "u"};
    static String answer = null;
    static StringBuilder route;
    static int limit;
    static int endX, endY;
    static int row, col;

    public static String solution(int n, int m, int x, int y, int r, int c, int k) {

        route = new StringBuilder();
        endX = r;
        endY = c;
        row = n;
        col = m;
        limit = k;

        int length = dist(x, y, r, c);
        if((k - length) % 2 == 1 || k < length) return "impossible";

        dfs(x, y, 0);

        if(answer == null) {
            return "impossible";
        }

        return answer;
    }

    public static int dist(int x, int y, int r, int c) {
        return (int)Math.abs(x - r) + (int)Math.abs(y - c);
    }

    public static void dfs(int x, int y, int moves) {

        if(answer != null) return;
        if(moves + dist(x, y, endX, endY) > limit) {
            return;
        }
        if(moves == limit) {
            answer = route.toString();
            return;
        }
        for(int i = 0; i < 4; i++) {
            int moveX = x + dx[i];
            int moveY = y + dy[i];
            if(moveX <= row && moveX > 0 && moveY <= col && moveY > 0) {
                route.append(dir[i]);
                dfs(moveX, moveY, moves + 1);
                route.delete(moves, moves + 1);
            }
        }
    }
}
