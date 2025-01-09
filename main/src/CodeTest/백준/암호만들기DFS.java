package CodeTest.백준;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.StringTokenizer;

// 1759
public class 암호만들기DFS {

    static int L, C;
    static String[] letter;
    static List<String> answer;
    static List<String> vowels;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        L = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());
        answer = new ArrayList<String>();

        String words = br.readLine();
        letter = words.split(" ");
        vowels = new ArrayList<>();

        vowels.add("a");
        vowels.add("e");
        vowels.add("i");
        vowels.add("o");
        vowels.add("u");

        Arrays.sort(letter);

        for(int i = 0; i < C; i++) {
            StringBuilder sb = new StringBuilder(letter[i]);
            if(vowels.contains(letter[i])) {
                solution(sb, i, 1, 0);
            }
            else {
                solution(sb, i, 0, 1);
            }
        }

        for(String s : answer) {
            System.out.println(s);
        }
    }

    public static void solution(StringBuilder password, int idx, int vowel, int consonant) {

        if(password.length() == L && vowel >= 1 && consonant >= 2) {
            answer.add(password.toString());
            return;
        }

        if(idx + 1 >= C) return;

        if(letter[idx + 1].compareTo(String.valueOf(password.charAt(password.length() - 1))) > 0) {
            if(vowels.contains(letter[idx + 1])) {
                solution(password.append(letter[idx + 1]), idx + 1, vowel + 1, consonant);
            } else {
                solution(password.append(letter[idx + 1]), idx + 1, vowel, consonant + 1);
            }
            solution(password.deleteCharAt(password.length() - 1), idx + 1, vowel, consonant);
        }
    }
}
