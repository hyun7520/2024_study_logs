package CodeTest.프로그래머스;

import java.util.Arrays;
import java.util.Comparator;

public class 단속카메라 {

    public int solution(int[][] routes) {
        int answer = 1;

        Arrays.sort(routes, new Comparator<int[]>() {
            @Override
            public int compare(int[] route1, int[] route2) {
                return route1[1] - route2[1];
            }
        });

        int now = routes[0][1];

        for(int[] route: routes) {
            if(route[0] > now) {
                now = route[1];
                answer++;
            }
        }

        return answer;
    }
}
