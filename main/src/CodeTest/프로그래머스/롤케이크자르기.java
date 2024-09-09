package CodeTest.프로그래머스;

import java.util.*;

public class 롤케이크자르기 {
    public static void main(String[] args) {

        롤케이크자르기Solution sol = new 롤케이크자르기Solution();

        System.out.println(sol.solution(new int[]{1, 2, 1, 3, 1, 4, 1, 2}));

    }
}

class 롤케이크자르기Solution {
    public int solution(int[] topping) {
        int answer = 0;

        Map<Integer, Integer> map = new HashMap<>();
        Set<Integer> set = new HashSet<>();

        for(int i : topping) {
            if(map.containsKey(i)) {
                map.put(i, map.get(i) + 1);
            } else {
                map.put(i, 1);
            }
        }

        for(int i : topping) {
            map.put(i, map.get(i) - 1);
            set.add(i);
            if(map.get(i) == 0) {
                map.remove(i);
            }
            if(map.size() == set.size()) {
                answer++;
            }
        }

        return answer;
    }
}

// 시간초과
class 롤케이크자르기SolutionTimeOut {

    List<Integer> head;
    List<Integer> tail;
    Set<Integer> set1;
    Set<Integer> set2;

    public int solution(int[] topping) {
        int answer = 0;

        List<Integer> toppings = new ArrayList<>();

        for(int top : topping) {
            toppings.add(top);
        }

        for(int i = 0; i < topping.length; i++) {
            head = toppings.subList(0, i);
            tail = toppings.subList(i, topping.length);

            set1 = new HashSet<>(head);
            set2 = new HashSet<>(tail);

            if(set1.size() == set2.size()) {
                answer++;
            }
        }

        return answer;
    }
}