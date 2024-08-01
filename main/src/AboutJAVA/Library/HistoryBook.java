package AboutJAVA.Library;

import java.time.LocalDateTime;

public class HistoryBook extends Book {

    private String country;

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public HistoryBook(String title, String author, String isbn, LocalDateTime published, String country) {
        super(title, author, isbn, published);
        this.country = country;

    }
}
