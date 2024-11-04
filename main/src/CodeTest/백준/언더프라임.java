package CodeTest.백준;

import java.util.Scanner;

public class 언더프라임 {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int a = sc.nextInt();
        int b = sc.nextInt();



        System.out.println(solution(a, b));

    }

    public static int solution(int a, int b) {
        int answer = 0;

        boolean[] isPrime = new boolean[b+1];
        isPrime[0] = isPrime[1] = true;

        for(int i = 2; i * i <= b; i++) {
            if(!isPrime[i]) {
                for(int j = i * i; j <= b; j += i) {
                    isPrime[j] = true;
                }
            }
        }

        for(int i = a; i <= b; i++) {
            int count = 0;
            int num = i;
            for(int j = 2; j * j <= i; j++) {
                if(!isPrime[j]) {
                    while(num % j == 0) {
                        count++;
                        num /= j;
                    }
                }
            }
            if(num > 1) {
                count++;
            }
            if(!isPrime[count]) {
                answer++;
            }
        }

        return answer;
    }
}
