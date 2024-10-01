package CodeTest.카카오코테;

import java.util.Arrays;

public class 표현가능한이진트리 {

    public static void main(String[] args) {

        System.out.println(Arrays.toString(solution(new long[]{7, 42, 5})));
//        System.out.println(Arrays.toString(solution(new long[]{63, 111, 95})));

    }
    static boolean[] checkNode;
    static int totalNodes;
    static int result;

    public static int[] solution(long[] numbers) {
        int[] answer = new int[numbers.length];

        for(int i = 0; i < numbers.length; i++) {

            totalNodes = 0;
            String cur = Long.toBinaryString(numbers[i]);
            int binaryLength = cur.length();
            int depth = 1;
            while(totalNodes < binaryLength) {
                totalNodes = (int) Math.pow(2, depth++) - 1;
            }

            checkNode = new boolean[totalNodes];

            int idx = totalNodes - binaryLength;
            for(int j = 0; j < binaryLength; j++) {
                if(cur.charAt(j) == '1') {
                    checkNode[idx] = true;
                }
                idx++;
            }

            result = 1;
            checkBinary(0, totalNodes - 1, false);
            answer[i] = result;
        }


        return answer;
    }

    public static void checkBinary(int start, int end, boolean check) {
        int mid = (start + end) / 2;
        if(check && checkNode[mid]) {
            result = 0;
            return;
        }
        if(start != end) {
            checkBinary(start, mid - 1, !checkNode[mid]);
            checkBinary(mid+1, end, !checkNode[mid]);
        }
    }


}
