package CodeTest.프로그래머스;

import java.util.Arrays;
import java.util.Comparator;

public class 파일명정렬 {
    public static void main(String[] args) {
        파일명정렬Solution sol = new 파일명정렬Solution();

        System.out.println(Arrays.toString(
                sol.solution(new String[]{"img12.png", "img10.png", "img02.png", "img1.png", "IMG01.GIF", "img2.JPG"})
        ));
    }
}

class 파일명정렬Solution {
    public String[] solution(String[] files) {
        String[] answer = {};

        int numStart = 0;
        String[] split;

        Arrays.sort(files, new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                return 0;
            }
        });

        return answer;
    }
}