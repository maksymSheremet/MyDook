
## 📌 5.6: "Используйте ограниченные символы подстановки для повышения гибкости API"

### 🧠 Просте пояснення
🔑 Що таке "ограниченные символы подстановки"?

Це коли ти не вказуєш точний тип у дженеріках, а кажеш:
>"Тут якийсь тип, але обов’язково нащадок або предок певного класу."

Це записується через ? extends T або ? super T.

### 📌 Головне: extends vs super
| Запис         | Читається як            | Приклад використання       |
| ------------- | ----------------------- | -------------------------- |
| `? extends T` | **будь-який нащадок** T | **для читання** з колекції |
| `? super T`   | **будь-який предок** T  | **для запису** в колекцію  |


### 📷 Аналогія з ковшом:
- ? extends Fruit — ти можеш дістати фрукт з кошика, але не знаєш точно який.
- ? super Apple — ти можеш класти яблука в кошик, але не знаєш, що вже в ньому є.

### 🤓 Приклад з книги
❌ Без wildcards — жорстке API:
```java
public static void printList(List<Object> list) {
  for (Object o : list)
    System.out.println(o);
}
```
Це не працює з List<String>, бо List<String> ≠ List<Object> ❌

✅ З wildcards — гнучке API:
```java
public static void printList(List<?> list) {
  for (Object o : list)
    System.out.println(o);
}
```
Тепер метод приймає будь-який тип списку: List<String>, List<Integer>, тощо ✅

### 🔁 Пам’ятка:
"PECS" — Producer Extends, Consumer Super

| Якщо метод...            | Використовуй... |
| ------------------------ | --------------- |
| **зчитує** дані          | `? extends T`   |
| **приймає/записує** дані | `? super T`     |


### 🧾 Висновок
| Без wildcards          | З wildcards                       |
| ---------------------- | --------------------------------- |
| Жорстке API            | Гнучке, універсальне API          |
| Неможна змішувати типи | Можна працювати з ієрархією типів |
| Важко підтримувати     | Легко розширювати                 |

### 🔁 Запам’ятай:
 - ? extends T → коли читаєш з колекції
 - ? super T → коли записуєш в колекцію



## 5.6 Используйте ограниченные символы подстановки для повышения гибкости API (Item 31)

Поскольку параметризованные типы являются инвариантными, то невозможно в коллекцию `List<Nubmer>` вставить
объект `Integer` используя только формальный параметр типа `E`.

```java
class Item31 {
    public void pushAll(Iterable<E> src) {
        for (E e : src)
            puhs(e);
    }

    public static void main(String[] args) {
        // Integer is a subtype of Number
        Stack<Number> numberStack = new Stack<Number>();
        Iterable<Integer> integers =...;
        numberStack.pushAll(integers); //Error message here: List<Integer> is not a subtype of List<Number>
    }
}
```

Что бы это было возможно, можно использовать ограниченный символ подстановки

Producer:

```java
class Item31 {
    // We want to push in everything that is E or inherits E
    public void pushAll(Iterable<? extends E> src) {
        for (E e : src) {
            push(e);
        }
    }
}

```

В данном случае параметризованный тип является производителем(producer). Также параметризованный тип может быть
потребителем(consumer), например получить объекты.

Consumer:

```java
class Item31 {
    public void popAll(Collection<? super E> dst) {
        while (!isEmpty()) dst.add(pop());
    }
}

```

Правило **PECS** - producer-extends, consumer-super

Не используйте ограниченные типы с символами подстановки в качестве возвращаемых типов. Пользователь данного элемента не
должен думать о типах символов подстановки.

`Comparable` и `Comparators` всегда потребители. Используйте `Comparable<? super T>` и `Comparator<? super T>`.

Если параметр типа появляется в объявлении метода только один раз, его следует заменить символом подстановки:

```java
public static <E> void swap(List<E> list, int i, int j)

public static void swap(List<?> list, int i, int j) //Более предпочтительный способ
```
