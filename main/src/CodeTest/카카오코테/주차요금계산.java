package CodeTest.카카오코테;

import java.util.*;

public class 주차요금계산 {

    public static void main(String[] args) {
        System.out.println(Arrays.toString(solution(new int[]{180, 5000, 10, 600},
                new String[]{"05:34 5961 IN", "06:00 0000 IN", "06:34 0000 OUT", "07:59 5961 OUT", "07:59 0148 IN",
                        "18:59 0000 IN", "19:09 0148 OUT", "22:59 5961 IN", "23:00 5961 OUT"})));
    }

    static int defaultTime;
    static int defaultFee;
    static int overTime;
    static int overTimeFee;
    static int maxTime;

    public static int[] solution(int[] fees, String[] records) {

        defaultTime = fees[0]; defaultFee = fees[1];
        overTime = fees[2]; overTimeFee = fees[3];
        maxTime = 23 * 60 + 59;
        int totalTime;
        int curTime;
        int inTime;

        Map<String, Integer> inOut = new HashMap<>();
        Map<String, Integer> payment = new HashMap<>();

        for(String record : records) {
            String[] split = record.split(" ");
            curTime = toMinute(split[0]);

            if(split[2].equals("IN")) {
                inOut.put(split[1], curTime);
                continue;
            }
            if(split[2].equals("OUT")) {
                inTime = inOut.get(split[1]);
                totalTime = curTime - inTime;
                payment.put(split[1], payment.getOrDefault(split[1], 0) + totalTime);
                inOut.remove(split[1]);
            }
        }

        if(!inOut.isEmpty()) {
            for(String key : inOut.keySet()) {
                totalTime = maxTime - inOut.get(key);
                payment.put(key, payment.getOrDefault(key, 0) + totalTime);
            }
        }

        int[] answer = new int[payment.size()];
        List<String> carNum = new ArrayList<>(payment.keySet());
        Collections.sort(carNum);

        for(int i = 0; i < answer.length; i++) {
            answer[i] = calPayment(payment.get(carNum.get(i)));
        }

        return answer;
    }

    public static int toMinute(String timeStamp) {
        String[] temp = timeStamp.split(":");
        return Integer.parseInt(temp[0]) * 60 + Integer.parseInt(temp[1]);
    }

    public static int calPayment(int time) {
        if(time <= defaultTime) {
            return defaultFee;
        } else {
            int extraFee = (int) ( Math.ceil((double) (time - defaultTime) / overTime )) * overTimeFee;
            return defaultFee + extraFee;
        }
    }
}
