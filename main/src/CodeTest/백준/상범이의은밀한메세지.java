package CodeTest.백준;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class 상범이의은밀한메세지 {

    static String message, peek;
    static List<Integer> candidate;
    static int[] key;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        message = br.readLine();
        peek = br.readLine();

        for(int i = 0; i <= message.length() - peek.length(); i++) {
            String part = message.substring(i, i + peek.length());
            candidate = new ArrayList<>();
            for(int j = 0; j < peek.length(); j++) {
                int cur = (part.charAt(j) - 'a') - (peek.charAt(j) - 'a');
                if(cur < 0) {
                    cur += 26;
                }
                System.out.println(part.charAt(j) + " -> " + (part.charAt(j) - 'a') + " and "
                        + (peek.charAt(j) + " -> " + (peek.charAt(j) - 'a') + " = " + cur));
                candidate.add(cur);
            }
            System.out.println("new");
        }

    }

    public static void checkRepeat() {

        // key 글자수 => 1부터 peek 길이의 절반 이하
        for(int i = 1; i <= peek.length() / 2; i++) {

            // 주어진 후보 candidate 안에서 현재 글자수로 반복되는 구간이 있는지 확인
            // 0 1 2 => 1 2 3
            for(int j = 0; j < peek.length(); j++) {

            }


        }

    }
}
