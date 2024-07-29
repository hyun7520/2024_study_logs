import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class 잃어버린괄호 {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String str = br.readLine();
        String[] operator = str.split("-");

        int answer = Integer.MAX_VALUE;

        for(String parts : operator) {
            int temp = 0;

            String[] add = parts.split("\\+");

            for(String s : add) {
                temp += Integer.parseInt(s);
            }

            if(answer == Integer.MAX_VALUE) {
                answer = temp;
            } else {
                answer -= temp;
            }
        }

        System.out.println(answer);
    }
}
