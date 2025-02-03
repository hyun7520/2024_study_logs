package CodeTest.백준;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

// 2671
public class 잠수함식별 {

    static String str;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        str = br.readLine();

        // + : 앞의 문자열이 1개 이상
        // (x/y) : x나 y의 문자열 중 하나라도 만족할 것
        String regex = "(100+1+|01)+";
        String answer = "";

        answer = str.matches(regex) ? "SUBMARINE" : "NOISE";

        System.out.println(answer);
    }
}
