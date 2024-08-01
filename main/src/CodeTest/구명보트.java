package CodeTest;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class 구명보트 {
    public int solution(int[] people, int limit) {
        int answer = 0;

        Arrays.sort(people);

        int start = 0;
        int end = people.length - 1;

        while(start < end) {
            if(people[start] + people[end] <= limit) {
                answer++;
                start++;
            }
            end--;
        }

        return people.length - answer;
    }
}
