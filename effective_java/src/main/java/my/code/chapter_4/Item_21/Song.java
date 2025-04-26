package my.code.chapter_4.Item_21;

/**
 * ✏️ Завдання
 * Створи інтерфейс Playable, який має метод play().
 * Створи клас Song, який реалізує Playable.
 * Перевір тестами, що пісня може "гратися".
 */

public class Song implements Playable {

    private final String title;

    public Song(String title) {
        this.title = title;
    }

    @Override
    public void play() {
        System.out.println("Playing: " + title);
    }

    public String getTitle() {
        return title;
    }
}
