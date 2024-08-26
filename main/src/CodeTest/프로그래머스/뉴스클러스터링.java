package CodeTest.프로그래머스;

import java.util.*;

public class 뉴스클러스터링 {

    public static void main(String[] args) {

        뉴스클러스터링Solution sol = new 뉴스클러스터링Solution();

        System.out.println(sol.solution("E=M*C^2", "e=m*c^2"));
    }
}

class 뉴스클러스터링Solution {

    static List<String> list1, list2;

    public int solution(String str1, String str2) {

        int dupCount = 0;

        list1 = new ArrayList<>();
        list2 = new ArrayList<>();

        list1 = parts(list1, str1.toLowerCase());
        list2 = parts(list2, str2.toLowerCase());

        int total = list1.size() + list2.size();

        for(String str: list1) {
            if(list2.contains(str)) {
                dupCount ++;
                list2.remove(str);
            }
        }

        total = total - dupCount;

        if(total == 0) {
            return 65536;
        }

        return (int)((double) dupCount/(double) total * 65536);
    }

    List<String> parts(List<String> list, String word) {

        StringBuilder sb = new StringBuilder();

        for(int i = 0; i < word.length() - 1; i++) {
            char first = word.charAt(i);
            char second = word.charAt(i+1);
            if(first >= 'a' && second >= 'a' && first <= 'z' && second <= 'z') {
                sb.append(word.charAt(i)).append(word.charAt(i+1));
                list.add(sb.toString());
                sb.setLength(0);
            }
        }

        return list;
    }
}
