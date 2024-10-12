package CodeTest.프로그래머스;

public class 이하로다른비트2개 {
    public long[] solution(long[] numbers) {
        long[] answer = new long[numbers.length];

        for(int i = 0; i < numbers.length; i++) {
            answer[i] = numbers[i] + 1;
        }

        for(int i = 0; i < numbers.length; i++) {
            answer[i] += (answer[i] ^ numbers[i]) >> 2;
        }

        return answer;
    }
}
