package CodeTest.프로그래머스;


import java.util.Arrays;
import java.util.Comparator;

public class 가장큰수 {
    public String solution(int[] numbers) {
        StringBuilder sb = new StringBuilder();

        String[] str = new String[numbers.length];

        for(int i = 0; i < numbers.length; i++) {
            str[i] = String.valueOf(numbers[i]);
        }

        Arrays.sort(str, new Comparator<String>() {
            @Override
            public int compare(String a, String b) {
                return (b+a).compareTo(a+b);
            }
        });

        if(str[0].equals("0")) return "0";

        for(String s : str) {
            sb.append(s);
        }

        return sb.toString();
    }
}
