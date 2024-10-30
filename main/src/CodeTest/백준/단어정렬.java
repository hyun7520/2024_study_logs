package CodeTest.백준;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class 단어정렬 {

    static List<String> answer;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        answer = new ArrayList<>();

        for(int i = 0; i < n; i++) {
            String input = br.readLine();
            if(answer.contains(input)) {
                continue;
            }
            answer.add(input);
        }

        solution();

        for(String s : answer) {
            System.out.println(s);
        }
    }

    public static void solution() {

        answer.sort((o1, o2) -> {
            if (o1.length() == o2.length()) {
                return o1.compareTo(o2);
            }
            return o1.length() - o2.length();
        });
    }
}
