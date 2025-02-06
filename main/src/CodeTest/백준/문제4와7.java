package CodeTest.백준;

import java.io.*;

// 2877
public class 문제4와7 {

    static int K;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        K = Integer.parseInt(br.readLine()) + 1;
        String temp = Integer.toBinaryString(K);

        StringBuilder sb = new StringBuilder();
        for(int i = 1; i < temp.length(); i++) {
            if(temp.charAt(i) == '0') {
                sb.append(4);
            }
            else sb.append(7);
        }

        System.out.println(sb.toString());
    }
}