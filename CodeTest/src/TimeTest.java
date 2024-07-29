import java.text.SimpleDateFormat;
import java.util.Date;

public class TimeTest {
    public static void main(String[] args) {
        Date now = new Date();

        SimpleDateFormat format = new SimpleDateFormat("yyyy년 MM월 dd일 HH시 mm분 ss초");
        String formatNow = format.format(now);
        String formatNowAdd = format.format(new Date(now.getTime() + 30 * 60 * 1000L));
        String formatNowSeven = format.format(now.getTime() + 7 * 24 * 60 * 60 * 1000L);
        System.out.println("현재: "+formatNow);
        System.out.println("30분: "+formatNowAdd);
        System.out.println("7일: "+formatNowSeven);
    }
}
