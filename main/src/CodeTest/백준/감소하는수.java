package CodeTest.백준;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class 감소하는수 {

    static List<Long> digits = new ArrayList<>();

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int num = sc.nextInt();
        if(num < 10) System.out.print(num);
        else if(num > 1022) System.out.println(-1);
        else {
            for(long i = 0; i < 10; i++) {
                solution(i, 1);
            }

            Collections.sort(digits);
            System.out.println(digits.get(num));
        }
    }

    public static void solution(Long num, int idx) {

        if(idx > 10) return;
        digits.add(num);
        for(int i = 0; i < num % 10; i++) {
            solution(num * 10 + i, idx+1);
        }
    }
}
