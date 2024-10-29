package CodeTest.백준;

import java.util.Scanner;

public class 단어공부 {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        String str = sc.next();

        char ans = solution(str);

        System.out.println(String.valueOf(ans).toUpperCase());
    }

    public static char solution(String str) {

        String temp = str.toLowerCase();
        int[] cnt = new int[26];
        int max = Integer.MIN_VALUE;
        int ans = 0;

        for(int i = 0; i < temp.length(); i++) {
            cnt[temp.charAt(i) - 'a']++;
        }

        for(int i = 0; i < cnt.length; i++) {
            if(cnt[i] > max) {
                ans = i;
                max = cnt[i];
            }
        }

        for(int i = ans + 1; i < cnt.length; i++) {
            if(cnt[i] == max) {
                return '?';
            }
        }

        return (char)('a' + ans);
    }
}
