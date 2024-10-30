package CodeTest.백준;

import java.util.Scanner;

public class 분수찾기 {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        System.out.println(solution(n));

    }

    public static String solution(int num) {
        String answer = "";

        int diagonal = 1;
        int squareCnt = 0;

        while(true) {
            if(num > squareCnt + diagonal) {
                squareCnt += diagonal;
                diagonal += 1;
            }
            else {
                if(diagonal % 2 == 0) {
                   System.out.println((num - squareCnt) + "/" + (diagonal - (num - squareCnt - 1)));
                   break;
                }
                if(diagonal % 2 == 1) {
                    System.out.println((diagonal - (num - squareCnt - 1)) + "/" + (num - squareCnt));
                    break;
                }
            }
        }

        return answer;
    }
}