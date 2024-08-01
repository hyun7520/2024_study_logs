package CodeTest;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

public class 설탕배달 {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());

        int answer = 0;

        while(n > 0){
            if(n % 5 == 0){
                answer += n/5;
                break;
            }
            else {
                n -= 3;
                answer += 1;
            } if (n < 0) {
                answer = -1;
                break;
            }
        }
        System.out.println(answer);
    }
}
