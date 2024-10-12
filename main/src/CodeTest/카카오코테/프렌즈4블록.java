package CodeTest.카카오코테;

public class 프렌즈4블록 {
    char[][] map;
    int col;
    int row;

    public int solution(int m, int n, String[] board) {
        int answer = 0;

        col = m;
        row = n;
        map = new char[m][n];
        boolean[][] isSame;

        for(int i = 0; i < m; i++) {
            for(int j = 0; j < n; j++) {
                map[i][j] = board[i].charAt(j);
            }
        }

        while(true) {
            isSame = new boolean[m][n];
            toDelete(isSame);
            int cnt = cntBlock(isSame);
            if(cnt == 0) break;
            answer += cnt;

            moveBlock();
        }


        return answer;
    }

    public void toDelete(boolean[][] isSame) {
        for(int i = 0; i < col - 1; i++) {
            for(int j = 0; j < row - 1; j++) {
                char point = map[i][j];
                if(point == map[i][j+1] && point == map[i+1][j] && point == map[i+1][j+1]) {
                    isSame[i][j] = true;
                    isSame[i][j+1] = true;
                    isSame[i+1][j] = true;
                    isSame[i+1][j+1] = true;
                }
            }
        }
    }

    public int cntBlock(boolean[][] isSame) {

        int cnt = 0;

        for(int i = 0; i < col; i++) {
            for(int j = 0; j < row; j++) {
                if(isSame[i][j] && map[i][j] != '-') {
                    cnt++;
                    map[i][j] = '-';
                }
            }
        }

        return cnt;
    }

    public void moveBlock() {
        for(int i = col - 1; i >= 0; i--) {
            for(int j = 0; j < row; j++) {
                if(map[i][j] == '-') {
                    for(int k = i - 1; k >= 0; k--) {
                        if(map[k][j] != '-') {
                            map[i][j] = map[k][j];
                            map[k][j] = '-';
                            break;
                        }
                    }
                }
            }
        }
    }
}
