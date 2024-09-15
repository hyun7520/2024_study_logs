package CodeTest.프로그래머스;

import java.util.*;

public class 주차요금계산 {
    public static void main(String[] args) {

        주차요금계산Solution sol = new 주차요금계산Solution();

        System.out.println(Arrays.toString(
                sol.solution(new int[]{180, 5000, 10, 600},
                new String[]{"05:34 5961 IN", "06:00 0000 IN", "06:34 0000 OUT", "07:59 5961 OUT",
                        "07:59 0148 IN", "18:59 0000 IN", "19:09 0148 OUT", "22:59 5961 IN", "23:00 5961 OUT"})
        ));

    }
}

class 주차요금계산Solution {
    public int[] solution(int[] fees, String[] records) {
        int[] answer= {};

        Map<String, Integer> map = new HashMap<>();
        Map<String, Integer> car = new HashMap<>();
        int maxTime = 23 * 60 + 59;

        String[] time;

        for(String s : records) {
            String[] temp = s.split(" ");
            if(temp[2].equals("IN")) {
                time = temp[0].split(":");
                int hour = Integer.parseInt(time[0]);
                int minute = Integer.parseInt(time[1]);
                map.put(temp[1], hour*60 + minute);

            }
            if(temp[2].equals("OUT")) {
                time = temp[0].split(":");
                int hour = Integer.parseInt(time[0]);
                int minute = Integer.parseInt(time[1]);
                if(!car.containsKey(temp[1])) {
                    car.put(temp[1], hour*60 + minute - map.get(temp[1]));
                } else {
                    car.put( temp[1], car.get(temp[1]) +
                            (hour*60 + minute - map.get(temp[1])) );
                }
                map.remove(temp[1]);
            }
        }

        if(!map.isEmpty()) {
            for(Map.Entry<String, Integer> entry : map.entrySet()) {
                String key = entry.getKey();

                if(!car.containsKey(key)) {
                    car.put(key, maxTime - map.get(key));
                } else {
                    car.put(key, car.get(key) +
                            (maxTime - map.get(key)));
                }
            }
        }

        List<Integer> list = new ArrayList<>();


        return answer;
    }
}