package CodeTest.카카오코테;

import java.util.List;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class 개인정보수집유효기간 {
    public int[] solution(String today, String[] terms, String[] privacies) {

        List<Integer> tempAns = new ArrayList<>();
        Map<String, Integer> until = new HashMap<>();

        int now = toDate(today);
        String[] temp;

        for(String term: terms) {
            temp = term.split(" ");
            until.put(temp[0], Integer.parseInt(temp[1]) * 28);
        }

        for(int i = 0; i < privacies.length; i++) {
            temp = privacies[i].split(" ");
            if(toDate(temp[0])+ until.get(temp[1]) <= now) {
                tempAns.add(i+1);
            }
        }

        int[] answer = new int[tempAns.size()];
        for(int i = 0; i < answer.length; i++) {
            answer[i] = tempAns.get(i);
        }

        return answer;
    }

    public int toDate(String date) {
        int days = 0;

        String[] split = date.split("\\.");
        days += Integer.parseInt(split[0])*12*28;
        days += Integer.parseInt(split[1])*28;
        days += Integer.parseInt(split[2]);

        return days;
    }

}
