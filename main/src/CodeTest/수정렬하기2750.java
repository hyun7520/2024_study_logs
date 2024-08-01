package CodeTest;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class 수정렬하기2750 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());

        boolean[] bool = new boolean[2001];

        for(int i = 0; i < n; i++) {
            bool[Integer.parseInt(br.readLine()) + 1000] = true;
        }

        for(int i = 0; i <= 2000; i++) {
            if(bool[i]) {
                System.out.println(i - 1000);
            }
        }
    }
}
