package CodeTest.백준;

import java.util.Scanner;

public class Z1074 {

    static int answer = 0;

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int r = sc.nextInt();
        int c = sc.nextInt();
        int side = (int) Math.pow(2, n);

        solution(side, r, c);
        System.out.println(answer);
    }

    public static void solution(int side, int r, int c) {
        if(side == 1) return;

        if(r < side/2 && c < side/2) {
            solution(side/2, r, c);
        } else if(r < side/2 && c >= side/2) {
            answer += side*side/4;
            solution(side/2, r, c - side/2);
        } else if(r >= side/2 && c < side/2) {
            answer += (side*side/4)*2;
            solution(side/2, r - side/2, c);
        } else {
            answer += (side*side/4)*3;
            solution(side/2, r - side/2, c - side/2);
        }
    }
}
