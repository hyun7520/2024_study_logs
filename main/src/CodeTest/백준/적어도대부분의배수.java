package CodeTest.백준;

import java.util.Scanner;

public class 적어도대부분의배수 {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        int[] arr = new int[5];
        int min = Integer.MAX_VALUE;

        for(int i = 0; i < 5; i++) {
            arr[i] = sc.nextInt();
            min = Math.min(arr[i], min);
        }

        System.out.println(solution(arr, min));
    }

    public static int solution(int[] arr, int min) {

        int current = min;
        int cnt = 0;

        while(true) {
            for(int i : arr) {
                if(current % i == 0) {
                    cnt++;
                }
            }
            if(cnt >= 3) {
                break;
            }
            current++;
            cnt = 0;
        }

        return current;
    }
}
