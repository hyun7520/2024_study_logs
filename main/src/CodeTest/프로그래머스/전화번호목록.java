package CodeTest.프로그래머스;

import java.util.HashMap;
import java.util.Map;

public class 전화번호목록 {

    public static void main(String[] args) {

        String[] phone_book = {"119", "97674223", "1195524421"};

        전화번호목록Solution sol = new 전화번호목록Solution();

        System.out.println(sol.solution(phone_book));
    }
}

class 전화번호목록Solution {
    public boolean solution(String[] phone_book) {
        boolean answer = true;

        Map<String, Integer> map = new HashMap<>();

        for(int i = 0; i < phone_book.length; i++) {
            map.put(phone_book[i], i);
        }

        for(String phone: phone_book) {
            for(int j = 0; j < phone.length(); j++) {
                if(map.containsKey(phone.substring(0, j))) {
                    return false;
                }
            }
        }

        return answer;
    }
}
