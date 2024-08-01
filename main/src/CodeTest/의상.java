package CodeTest;

import java.lang.reflect.Array;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class 의상 {
    public int solution(String[][] clothes) {

        int answer = 1;

        Map<String, Integer> cloth = new HashMap<>();

        for(String[] str: clothes) {
            if(cloth.containsKey(str[1])) {
                cloth.put(str[1], cloth.get(str[1]) + 1);
            } else {
                cloth.put(str[1], 1);
            }
        }

        for(String key : cloth.keySet()) {
           answer *= cloth.get(key) + 1;
        }

        return answer - 1;
    }
}
