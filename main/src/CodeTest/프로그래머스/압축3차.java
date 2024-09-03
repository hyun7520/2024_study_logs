package CodeTest.프로그래머스;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class 압축3차 {
    public static void main(String[] args) {


        압축3차Solution sol = new 압축3차Solution();

        System.out.println(sol.solution("KAKAO"));
    }
}

class 압축3차Solution {
    public int[] solution(String msg) {
        int[] answer;

        String cur;

        List<Integer> tempAnswer = new ArrayList<>();
        String[] newMsg = msg.split("");

        Map<String, Integer> map = new HashMap<>();
        StringBuilder sb;

        for(char c = 'a'; c < 'z'; c++) {
            map.put(String.valueOf(c), c - 96);
        }

        for(int i = 0; i < newMsg.length; i++) {

            sb = new StringBuilder();
            cur = String.valueOf(newMsg[i]);

            if(!map.containsKey(cur)) {
                map.put(cur, map.size() + 1);
                tempAnswer.add(map.get(cur));
                continue;
            }

            sb.append(cur);

            for(int j = i + 1; j < msg.length(); j++) {
                sb.append(map.get(newMsg[j]));

                if(!map.containsKey(sb.toString())) {

                    map.put(sb.toString(), map.size() + 1);
                    tempAnswer.add(map.get())

                }
            }
        }


        return answer;
    }
}
