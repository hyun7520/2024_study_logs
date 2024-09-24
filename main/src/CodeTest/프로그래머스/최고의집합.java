package CodeTest.프로그래머스;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class 최고의집합 {
    public static void main(String[] args) {
        최고의집합Solution sol = new 최고의집합Solution();

        System.out.println(Arrays.toString(sol.solution(2, 9)));

    }
}

class 최고의집합Solution {
    public int[] solution(int n, int s) {
        int[] answer = new int[n];

        if(n > s) return new int[]{-1};

        int first = s / n;
        int second = s % n;

        for(int i = 0; i < n; i++) {
            answer[i] = first;
        }

        for(int i = 1; i <= second; i++) {
            answer[n-i]++;
        }

        return answer;
    }
}

// 시간초과
class 최고의집합SolutionTime {
    public int[] solution(int n, int s) {
        int[] answer = new int[2];

        List<int[]> list = new ArrayList<>();
        int max = -1;

        for(int i = 1; i < s/2 + 1; i++) {
            int second = s - i;
            if(second < i) break;
            list.add(new int[]{i, second});
        }

        if(list.isEmpty()) {
            return new int[]{-1};
        }

        for(int i = 0; i < list.size(); i++) {
            int[] temp = list.get(i);
            int times = temp[0] * temp[1];
            if(i == list.size() - 1 && max == Math.max(max, times)) {
                return new int[]{-1};
            }
            max = Math.max(max, times);
            answer[0] = temp[0];
            answer[1] = temp[1];
        }


        return answer;
    }
}