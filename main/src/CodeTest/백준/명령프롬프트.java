package CodeTest.백준;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class 명령프롬프트 {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(bf.readLine());
        String[] str = new String[n];

        for(int i = 0; i < n; i++) {
            str[i] = bf.readLine();
        }

        System.out.println(solution(str));
    }

    public static String solution(String[] str) {
        StringBuilder answer = new StringBuilder();

        if(str.length == 1) return str[0];

        boolean[] bool = new boolean[str[0].length()];
        char[] temp = new char[str[0].length()];

        for(int i = 0; i < str[0].length(); i++) {
            temp[i] = str[0].charAt(i);
        }

        for(int i = 1; i < str.length; i++) {
            for(int j = 0; j < str[i].length(); j++) {
                if(bool[j]) continue;
                if(temp[j] != str[i].charAt(j)) {
                    bool[j] = true;
                }
            }
        }

        for(int i = 0; i < str[0].length(); i++) {
            if(bool[i]) {
                answer.append("?");
            } else {
                answer.append(str[0].charAt(i));
            }
        }

        return answer.toString();
    }
}
