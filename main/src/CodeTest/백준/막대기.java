package CodeTest.백준;

import java.util.Scanner;

public class 막대기 {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int num = sc.nextInt();
        int answer = 0;

        String temp = Integer.toString(num, 2);

        for(int i = 0; i < temp.length(); i++) {
            if(temp.charAt(i) == '1') answer++;
        }

        System.out.println(answer);

    }
}
