package CodeTest.프로그래머스;

import java.util.HashMap;
import java.util.Map;

public class 모음사전 {
    public static void main(String[] args) {

        모음사전Solution sol = new 모음사전Solution();

        System.out.println(sol.solution("AAAE"));

    }
}

class 모음사전Solution {

    StringBuilder sb = new StringBuilder();
    String[] words = new String[] {"A", "E", "I", "O", "U"};
    Map<String, Integer> map = new HashMap<>();

    public int solution(String word) {
        int answer = 0;

        DFS("", 0);

        answer = map.get(word);

        return answer;
    }

    public void DFS(String str, int size) {
        int order = map.size();
        map.put(str, order);

        if(size == 5) return;

        for(int i = 0; i < 5; i++) {
            DFS(str + words[i], size + 1);
        }
    }
}