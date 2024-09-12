package CodeTest.프로그래머스;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class 단어변환 {
    public static void main(String[] args) {

        단어변환Solution sol = new 단어변환Solution();

        System.out.println(sol.solution("hit", "cog",
                new String[]{"hot", "dot", "dog", "lot", "log", "cog"}));

    }
}

class 단어변환Solution {

    static boolean[] visited;
    static int answer = 0;

    public int solution(String begin, String target, String[] words) {

        visited = new boolean[words.length];

        dfs(begin, target, words, 0);

        return answer;
    }

    public static void dfs(String begin, String target, String[] words, int cnt) {
        if(begin.equals(target)) {
            answer = cnt;
            return;
        }

        for(int i = 0; i < words.length; i++) {
            if(visited[i]) {
                continue;
            }
            int count = 0;
            for(int j = 0; j < words[i].length(); j++) {
                if(begin.charAt(j) != words[i].charAt(j)) {
                    count++;
                }
                if(count >= 2) {
                    break;
                }
            }
            if(count == 1) {
                visited[i] = true;
                dfs(words[i], target, words, cnt + 1);
                visited[i] = false;
            }

        }
    }
}