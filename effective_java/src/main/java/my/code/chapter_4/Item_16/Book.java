package my.code.chapter_4.Item_16;

/**
 * ✏️ Завдання:
 * Створи клас Book, який містить:
 * назву (title);
 * автора (author);
 * ціну (price).
 * Зроби так, щоб ці поля були приватні, з геттерами і сеттерами.
 * У сеттері ціни додай перевірку: ціна не може бути від’ємною.
 */

public class Book {
    private String title;
    private String author;
    private double price;

    public Book(String title, String author, double price) {
        this.title = title;
        this.author = author;
        setPrice(price);
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        if (price < 0) {
            throw new IllegalArgumentException("Price cannot be negative");
        }
        this.price = price;
    }
}
