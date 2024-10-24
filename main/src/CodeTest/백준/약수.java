package CodeTest.백준;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class 약수 {
    public static void main(String[] args) throws IOException {

        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(bf.readLine());
        String[] arr = bf.readLine().split(" ");

        System.out.println(solution(arr));
    }

    public static int solution(String[] arr) {

        int max = Integer.MIN_VALUE;
        int min = Integer.MAX_VALUE;

        for(String s: arr) {
            int temp = Integer.parseInt(s);
            if(temp > max) {
                max = temp;
            }
            if(temp < min) {
                min = temp;
            }
        }

        return max * min;
    }
}
