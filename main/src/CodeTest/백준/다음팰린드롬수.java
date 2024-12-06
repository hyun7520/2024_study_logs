package CodeTest.백준;


import java.io.*;

public class 다음팰린드롬수 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String input = br.readLine();
        System.out.println(findNextPalindrome(input));
    }

    public static String findNextPalindrome(String input) {
        int length = input.length();
        boolean isOdd = (length % 2 == 1);

        String palindrome = "";

        if(isOdd) {

        }

    }
}
