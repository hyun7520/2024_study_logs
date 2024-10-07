package CodeTest.카카오코테;

import java.util.Set;
import java.util.HashSet;

public class 로또의최고순위와최저순위 {
    public int[] solution(int[] lottos, int[] win_nums) {
        int[] answer = new int[2];

        int[] rank = {6, 6, 5, 4, 3, 2, 1};

        Set<Integer> set = new HashSet<>();

        for(int win_num: win_nums) {
            set.add(win_num);
        }

        for(int lotto: lottos) {
            if(lotto == 0) {
                answer[0]++;
                continue;
            }
            if(set.contains(lotto)) {
                answer[0]++;
                answer[1]++;
            }
            // for (int j = 0; j < win_nums.length; j++) {
            //     if (lotto == win_nums[j]) {
            //         answer[0]++;
            //         answer[1]++;
            //     }
            // }
        }

        answer[0] = rank[answer[0]];
        answer[1] = rank[answer[1]];

        return answer;
    }
}
