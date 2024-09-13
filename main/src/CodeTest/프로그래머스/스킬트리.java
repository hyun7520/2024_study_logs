package CodeTest.프로그래머스;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

public class 스킬트리 {
    public static void main(String[] args) {

        스킬트리Solution sol = new 스킬트리Solution();

        System.out.println(sol.solution("CBD", new String[]{"BACDE", "CBADF", "AECB", "BDA"}));

    }
}

class 스킬트리Solution {
    public int solution(String skill, String[] skill_trees) {
        int answer = 0;

        Map<Character, Integer> map = new HashMap<>();

        for(int i = 0; i < skill.length(); i++) {
            map.put(skill.charAt(i), i);
        }


        for(String s: skill_trees) {
            int idx = 0;
            for(int i = 0; i < s.length(); i++) {
                char temp = s.charAt(i);
                if(map.containsKey(temp) && map.get(temp) == idx) {
                    idx++;
                } else if(map.containsKey(temp) && map.get(temp) != idx) {
                    answer--;
                    break;
                }
            }
            answer++;
        }

        return answer;
    }
}