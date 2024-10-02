package CodeTest.카카오코테;

public class 파괴되지않은건물 {
    public static void main(String[] args) {

    }

    public int solution(int[][] board, int[][] skill) {

        int answer = 0;
        int mapX = board.length;
        int mapY = board[0].length;

        int[][] sum = new int[mapX + 1][mapY + 1];

        int r1, c1, r2, c2;
        int degree, action;

        for(int[] turn : skill) {
            r1 = turn[1]; c1 = turn[2];
            r2 = turn[3]; c2 = turn[4];
            action = turn[0] == 1 ? -1 : 1;
            degree = turn[5] * action;

            sum[r1][c1] += degree;
            sum[r1][c2 + 1] -= degree ;
            sum[r2 + 1][c1] -= degree;
            sum[r2 + 1][c2 + 1] += degree;
        }

        for(int i = 1; i <= mapX; i++) {
            for(int j = 0; j <= mapY; j++) {
                sum[i][j] += sum[i-1][j];
            }
        }

        for(int j = 1; j <= mapY; j++) {
            for(int i = 0; i <= mapX; i++) {
                sum[i][j] += sum[i][j - 1];
            }
        }

        for(int i = 0; i < mapX; i++) {
            for(int j = 0; j < mapY; j++) {
                if(board[i][j] + sum[i][j] > 0) {
                    answer++;
                }
            }
        }
        return answer;
    }
}
