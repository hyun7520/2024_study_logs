package CodeTest;

import java.util.ArrayList;
import java.util.List;

public class n2_배열_자르기 {
    public List<Long> solution(int n, long left, long right) {
        List<Long> answer = new ArrayList<>();

        for(long i = left; i <= right; i++) {
            answer.add(Math.max((i/n), (i%n)) + 1);
        }

        return answer;
    }
}
