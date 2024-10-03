package CodeTest.카카오코테;

import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;

public class 신고결과받기 {

    public static void main(String[] args) {
        System.out.println(Arrays.toString(
                solution(new String[] {"muzi", "frodo", "apeach", "neo"},
                        new String[]{"muzi frodo","apeach frodo","frodo neo","muzi neo","apeach muzi"}, 2))
        );
    }

    public static int[] solution(String[] id_list, String[] report, int k) {
        int[] answer = new int[id_list.length];

        Map<String, Integer> reportCount = new HashMap<>();
        Map<String, HashSet<String>> reporterRecord = new HashMap<>();

        // TODO: stream으로 중복을 한 번에 제거하는 방법이 있었다.
        // List<String> list = Arrays.stream(report).distinct().collect(Collectors.toList());

        for(String rep : report) {
            String[] split = rep.split(" ");
            String reporter = split[0];
            String reported = split[1];

            if(!reporterRecord.containsKey(reporter)) {
                reporterRecord.put(reporter, new HashSet<>() {{
                    add(reported);
                }});
            } else {
                if(reporterRecord.get(reporter).contains(reported)) {
                    continue;
                } else {
                    reporterRecord.get(reporter).add(reported);
                }
            }
            reportCount.put(reported, reportCount.getOrDefault(reported, 0) + 1);
        }

        for(int i = 0; i < id_list.length; i++) {
            int count = 0;
            if(reporterRecord.containsKey(id_list[i])) {
                for(String name: reporterRecord.get(id_list[i])) {
                    if(reportCount.get(name) >= k) {
                        count++;
                    }
                }
            }
            answer[i] = count;
        }

        return answer;
    }
}
