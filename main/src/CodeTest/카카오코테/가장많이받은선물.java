package CodeTest.카카오코테;

import java.util.Map;
import java.util.HashMap;

public class 가장많이받은선물 {
    public static void main(String[] args) {

        System.out.println(solution(new String[] {"muzi", "ryan", "frodo", "neo"},
                new String[] {"muzi frodo", "muzi frodo", "ryan muzi", "ryan muzi", "ryan muzi", "frodo muzi", "frodo ryan", "neo muzi"}));

    }

    public static int solution(String[] friends, String[] gifts) {
        int answer = 0;

        Map<String, Integer> name = new HashMap<>();
        Map<String, Integer> pRate = new HashMap<>();
        int group = friends.length;

        int[][] fromTo = new int[group][group];
        int[] getPresent = new int[group];

        for(int i = 0; i < group; i++) {
            name.put(friends[i], i);
            pRate.put(friends[i], 0);
        }

        for(String gift: gifts) {
            String[] temp = gift.split(" ");
            fromTo[name.get(temp[0])][name.get(temp[1])] += 1;
            pRate.put(temp[0], pRate.get(temp[0]) + 1);
            pRate.put(temp[1], pRate.get(temp[1]) - 1);
        }

        for(int i = 0; i < group - 1; i++) {
            for(int j = i+1; j < group; j++) {
                if(fromTo[i][j] > fromTo[j][i]) {
                    getPresent[i]++;
                }
                if(fromTo[i][j] < fromTo[j][i]) {
                    getPresent[j]++;
                }
                if(fromTo[i][j] == fromTo[j][i]) {
                    if(pRate.get(friends[i]) > pRate.get(friends[j])) {
                        getPresent[i]++;
                    }
                    if(pRate.get(friends[i]) < pRate.get(friends[j])) {
                        getPresent[j]++;
                    }
                }
            }
        }

        for(int num : getPresent) {
            answer = Math.max(num, answer);
        }

        return answer;
    }
}
