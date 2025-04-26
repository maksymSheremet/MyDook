package my.code.chapter_4.Item_24;

/**
 * ✏️ Завдання
 * Створи клас Book і всередині нього статичний клас Chapter.
 * Chapter має зберігати заголовок і номер розділу.
 * Перевір тестами створення глави
 */

public class Book {
    private final String title;

    public Book(String title) {
        this.title = title;
    }

    public static class Chapter {
        private final String name;
        private final int number;

        public Chapter(String name, int number) {
            this.name = name;
            this.number = number;
        }

        public String getName() {
            return name;
        }

        public int getNumber() {
            return number;
        }
    }

    public String getTitle() {
        return title;
    }
}
