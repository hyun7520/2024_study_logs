package CodeTest.카카오코테;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.PriorityQueue;
public class 행렬테두리회전하기 {

    public static void main(String[] args) {
        System.out.println(Arrays.toString(solution(6, 6,
                new int[][] {{2,2,5,4}, {3,3,6,6}, {5,1,6,3}})));
        System.out.println(Arrays.toString(solution(100, 97,
                new int[][] {{1,1,100,97}})));
    }
    static int[][] board;

    public static int[] solution(int rows, int columns, int[][] queries) {
        int[] answer = new int[queries.length];

        board = new int[rows + 1][columns + 1];

        for(int i = 1; i <= rows; i++) {
            for(int j = 1; j <= columns; j++) {
                board[i][j] = (i-1) * columns + j;
            }
        }

        for(int i = 0; i < queries.length; i++) {
            answer[i] = doTurn(queries[i]);
        }

        return answer;
    }

    public static int doTurn(int[] cood) {

        PriorityQueue<Integer> pq = new PriorityQueue<>();

        int x1 = cood[0]; int y1 = cood[1];
        int x2 = cood[2]; int y2 = cood[3];
        int lastNum = board[x1][y2];
        pq.add(lastNum);

        // 사각형 윗면 이동
        for(int i = y2; i > y1; i--) {
            board[x1][i] = board[x1][i-1];
            pq.add(board[x1][i]);
        }

        // 사각형 좌측면 이동
        for(int i = x1; i < x2; i++) {
            board[i][y1] = board[i+1][y1];
            pq.add(board[i][y1]);
        }

        // 사각형 하단면 이동
        for(int i = y1; i < y2; i++) {
            board[x2][i] = board[x2][i+1];
            pq.add(board[x2][i]);
        }

        // 사각형 우측면 이동
        for(int i = x2; i > x1; i--) {
            board[i][y2] = board[i-1][y2];
            pq.add(board[i][y2]);
        }

        board[x1+1][y2] = lastNum;

        return pq.poll();
    }
}
