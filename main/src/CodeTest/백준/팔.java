package CodeTest.백준;

import java.util.Scanner;

public class 팔 {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        int r = sc.nextInt();
        int l = sc.nextInt();

        System.out.println(solution(r, l));

    }

    public static int solution(int r, int l) {
        int answer = 0;

        String from = String.valueOf(r);
        String to = String.valueOf(l);

        if(from.length() != to.length()) {
            return 0;
        }

        for(int i = 0; i < to.length(); i++) {
            if(from.charAt(i) == '8' && to.charAt(i) == '8') {
                answer++;
            }
            if(from.charAt(i) != to.charAt(i)) {
                break;
            }
        }

        return answer;
    }
}
