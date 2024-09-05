package CodeTest.프로그래머스;

import java.util.*;

public class 압축3차 {
    public static void main(String[] args) {


        압축3차Solution sol = new 압축3차Solution();

        System.out.println(Arrays.toString(sol.solution("KAKAO")));
    }
}

class 압축3차Solution {
    public int[] solution(String msg) {

        List<Integer> tempAnswer = new ArrayList<>();
        String[] newMsg = msg.split("");
        Map<String, Integer> map = new HashMap<>();

        for(char c = 'A'; c <= 'Z'; c++) {
            map.put(Character.toString(c), c - 64);
        }

        int idx = 0;
        while(idx < msg.length()) {
            StringBuilder str = new StringBuilder();
            while(idx < msg.length()) {
                if(!map.containsKey(str + newMsg[idx])) {
                    break;
                } else {
                    str.append(newMsg[idx]);
                }
                idx++;
            }
            tempAnswer.add(map.get(str.toString()));

            if(idx < msg.length()) {
                str.append(newMsg[idx]);
                map.put(str.toString(), map.size() + 1);
            }
        }

        int[] answer = new int[tempAnswer.size()];

        for(int i = 0; i < tempAnswer.size(); i++) {
            answer[i] = tempAnswer.get(i);
        }

        return answer;
    }
}
