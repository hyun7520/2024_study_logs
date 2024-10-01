package CodeTest.카카오코테;

import java.util.HashMap;
import java.util.Map;

public class 성격유형검사 {

    public static void main(String[] args) {
        System.out.println(solution(new String[]{"AN", "CF", "MJ", "RT", "NA"}, new int[]{5, 3, 2, 7, 5}));
        System.out.println(solution(new String[]{"TR", "RT", "TR"}, new int[]{7, 1, 3}));

    }

    public static String solution(String[] survey, int[] choices) {
        StringBuilder answer = new StringBuilder();

        char[] types = new char[] {'R', 'T', 'C', 'F', 'J', 'M', 'A', 'N'};
        Map<Character, Integer> map = new HashMap<>();

        for(int i = 0; i < survey.length; i++) {

            char first = survey[i].charAt(0);
            char second = survey[i].charAt(1);

            if(choices[i] > 4) {
                map.put(second, map.getOrDefault(second, 0) + choices[i] - 4);
            }
            if(choices[i] < 4 && choices[i] > 0) {
                map.put(first, map.getOrDefault(first, 0) + 4 - choices[i]);
            }
        }

        for(int i = 0; i < types.length; i += 2) {
            int next = i + 1;

            answer.append(
                    map.getOrDefault(types[i], 0) >= map.getOrDefault(types[next], 0)
                            ? types[i] : types[next]);
        }

        return answer.toString();
    }
}
