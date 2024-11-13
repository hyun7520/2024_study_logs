package CodeTest.백준;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 색칠1 {

    static int[][] paper;
    static int fold, divide;
    static int x1, x2, y1, y2;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int[] input = new int[8];

        for(int i = 0; i < 8; i++) {
            input[i] = Integer.parseInt(st.nextToken());
        }

        paper = new int[input[0]][input[1]];
        fold = input[2];
        divide = input[3] + 1;
        x1 = input[4];
        y1 = input[5];
        x2 = input[6];
        y2 = input[7];

        System.out.println(solution());
    }

    public static int solution() {
        int answer = 0;

        int left = paper.length -

        return answer;
    }
}
