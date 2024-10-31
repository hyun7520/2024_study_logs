package CodeTest.백준;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Contact {

    static Pattern pattern = Pattern.compile("(100+1+|01)+");

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());

        for(int i = 0; i < n ; i++) {
            solution(br.readLine());
        }
    }

    public static void solution(String str) {
        String answer = "NO";

        Matcher matcher = pattern.matcher(str);
        if(matcher.matches()) {
            answer = "YES";
        }

        System.out.println(answer);
    }
}
