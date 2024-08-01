package AboutJAVA;

import AboutJAVA.Library.Book;
import AboutJAVA.Library.HistoryBook;

import java.time.LocalDateTime;

public class Main {
    public static void main(String[] args) {

        Book book = new Book("노인과 바다", "헤밍웨이",
                "12301810", LocalDateTime.now());

        HistoryBook historyBook = new HistoryBook("역사책", "강감찬",
                "123411", LocalDateTime.now(), "미국");

        System.out.println(book.getTitle());
        System.out.println(historyBook.getCountry());
    }
}
