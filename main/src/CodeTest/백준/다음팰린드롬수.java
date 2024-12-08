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

        String left = input.substring(0, (length + 1) / 2);

        String palindrome = checkPalindrome(left, isOdd);
        if(palindrome.compareTo(input) > 0) {
            return palindrome;
        }

        left = incrementNum(left);
        if (left.length() > (length + 1) / 2) {
            return "1" + "0".repeat(length - 1) + "1";
        }
        return checkPalindrome(left, isOdd);
    }

    public static String checkPalindrome(String input, boolean isOdd) {

        StringBuilder right = new StringBuilder(input);

        if(isOdd) {
            right.deleteCharAt(right.length() - 1);
        }

        return input + right.reverse();
    }

    public static String incrementNum(String input) {

        StringBuilder sb = new StringBuilder(input);
        int carry = 1;

        for(int i = sb.length() - 1; i >= 0; i--) {
            int curDigit = sb.charAt(i) - '0' + carry;
            if(curDigit == 10) {
                sb.setCharAt(i, '0');
            } else {
                sb.setCharAt(i, (char)(curDigit + '0'));
                carry = 0;
                break;
            }
        }

        if(carry == 1) {
            sb.insert(0, '1');
        }
        return sb.toString();
    }
}
