package CodeTest.프로그래머스;

import java.util.*;

public class 오픈채팅방 {
    public static void main(String[] args) {

        오픈채팅방Solution sol = new 오픈채팅방Solution();

        System.out.println(Arrays.toString(sol.solution(new String[]{
                "Enter uid1234 Muzi",
                "Enter uid4567 Prodo",
                "Leave uid1234",
                "Enter uid1234 Prodo",
                "Change uid4567 Ryan"})));

    }
}

class 오픈채팅방Solution {
    public String[] solution(String[] record) {
        String[] answer;

        String[] recordList;
        Map<String, String> nickName = new HashMap<>();
        Queue<String> queue = new LinkedList<>();

        for(String str : record) {
            recordList = str.split(" ");
            String order = recordList[0];

            if(order.equals("Enter")) {
                if(!nickName.containsKey(recordList[1])) {
                    nickName.put(recordList[1], recordList[2]);
                }
                queue.add(recordList[1] + " enter");
            }

            if(order.equals("Leave")) {
                queue.add(recordList[1] + " leave");
            }

            if(order.equals("Change")) {
                nickName.put(recordList[1], recordList[2]);
            }
        }

        String[] writeRecord;
        int idx = 0;
        answer = new String[queue.size()];

        while(!queue.isEmpty()) {
            writeRecord = queue.poll().split(" ");
            if(writeRecord[1].equals("enter")) {
                answer[idx] = "\"" + nickName.get(writeRecord[0]) + "님이 들어왔습니다." + "\"";
            }
            if(writeRecord[1].equals("leave")) {
                answer[idx] = "\"" + nickName.get(writeRecord[0]) + "님이 나갔습니다." + "\"";
            }
            idx++;
        }

        return answer;
    }
}