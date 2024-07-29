import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class 대표값2_2578 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int sum = 0;
        List<Integer> arr = new ArrayList<>();

        for(int i = 0; i < 5; i++) {
            int num = Integer.parseInt(br.readLine());
            arr.add(num);
            sum += num;
        }

        Collections.sort(arr);

        System.out.println(sum / 5);
        System.out.println(arr.get(2));
    }
}
