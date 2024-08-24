package AboutJAVA;

import AboutJAVA.Abstract.Player;
import AboutJAVA.OOP.Book;
import AboutJAVA.OOP.HistoryBook;
import AboutJAVA.Thread.Counter;

import java.time.LocalDateTime;
import java.util.Random;

public class Main{

    static int num;

    public static void main(String[] args) {

        Book book = new Book("노인과 바다", "헤밍웨이",
                "12301810", LocalDateTime.now());

        HistoryBook historyBook = new HistoryBook("역사책", "강감찬",
                "123411", LocalDateTime.now(), "미국");

        System.out.println(book.getTitle());
        System.out.println(historyBook.getCountry());

        // 동시성 테스트

        Counter counter = new Counter();

        Thread thread1 = new Thread(() -> {
            for(int i = 0; i < 10000; i++) {
                counter.increase();
            }
        });

        Thread thread2 = new Thread(() -> {
            for(int i = 0; i < 10000; i++) {
                counter.increase();
            }
        });

        thread1.start();
        thread2.start();

        try {
            thread1.join();
            thread2.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println(counter.show());

        Player[] players = new Player[4];

        players[0] = new Player("James", 10);

        Random random = new Random();

        for(int i = 0; i < 10; i++) {
            int rand = random.nextInt(10) + 1;
            if(rand >= 7) {
                System.out.println("success!");
            } else {
                System.out.println("Fail");
            }
        }
    }
}

