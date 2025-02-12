package CodeTest.백준;

import java.io.*;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

// 3107
public class IPv6 {

    static String[] ip;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String input = br.readLine();
        if(input.contains("::")) {
            // 규칙이 나타나는 부분은 zero로 표시
            input = input.replace("::", ":zero:");
        }
        ip = input.split(":");

        String[] answer = solution(ip);

        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        for(int i = 0; i < answer.length; i++) {
            if(i == answer.length - 1) {
                bw.write(answer[i]);
                break;
            }
            bw.write(answer[i] + ":");
        }

        bw.flush();
        bw.close();
    }

    public static String[] solution(String[] input) {

        LinkedList<String> groups = new LinkedList<>();
        List<String> recovered = new ArrayList<>();

        for(int i = 0; i < input.length; i++) {
            groups.add(input[i]);
        }

        // 4자리 형식이 아닌 숫자들을 복원하는 로직
        for (String s : groups) {
            StringBuilder sb = new StringBuilder(s);
            // 0000인 경우 continue
            if (sb.isEmpty()) continue;

            while (sb.length() < 4) {
                sb.insert(0, "0");
            }
            recovered.add(sb.toString());
        }

        String[] answer = new String[8];
        // 복원된 숫자들을 제외한 그룹에는 모두 0000이 들어간다.
        // 이때 그룹의 개수를 구하고 zeros에 저장해둔다.
        int zeros = 8 - recovered.size() + 1;
        int idx = 0;
        // answer 배열에 순서대로 문자를 담는다.
        // 이때 zero가 나타나는 곳부터 zeros만큼 0000인 반복되는 것을 유의하고 구현하다.
        for (String s : recovered) {
            if (s.equals("zero")) {
                while (zeros-- > 0) {
                    answer[idx] = "0000";
                    idx++;
                }
            } else {
                answer[idx] = s;
                idx++;
            }
        }

        return answer;
    }
}
