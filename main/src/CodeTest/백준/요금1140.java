package CodeTest.백준;


import java.util.*;

public class 요금1140 {
    public static void main(String[] args) {

//        System.out.println(solution(92, 10, 90, 20, 170));
//        System.out.println(solution(90, 10, 90, 20, 170));
//        System.out.println(solution(99, 10, 90, 20, 170));
//        System.out.println(solution(10, 1, 11, 20, 300));
//        System.out.println(solution(0, 10, 80, 50, 400));
//        System.out.println(solution(28, 1, 10, 1, 8));
        System.out.println(solution(450702146848L, 63791, 80, 50, 400));



    }

    public static long solution(long t, int k1, int p1, int k2, int p2) {

        // k - 문자개수, p - 문자팩 가격
        long answer = 0;

        if(t == 0) {
            return answer;
        }

        HashMap<Integer, int[]> map = new HashMap<>();

        map.put(k1*10 - p1, new int[]{k1, p1});
        map.put(k2*10 - p2, new int[]{k2, p2});

        List<Integer> keySet = new ArrayList<>(map.keySet());
        Collections.sort(keySet, (a1, a2) -> a2 - a1);

        for(int key : keySet) {
            if(key < 0) continue;

        }

        if(t > 0) {
            answer += t * 10;
        }

        return answer;
    }
}
