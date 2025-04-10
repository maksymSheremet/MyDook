## 📌 "2.6 Уникайте створення зайвих об'єктів"

### 🔍 Що це означає?
Ця порада з книги Effective Java говорить, що не варто без потреби створювати нові об'єкти, якщо можна використовувати вже існуючі. Це допомагає:
- ✅ Економити пам’ять 🧠
- ✅ Покращувати продуктивність ⚡
- ✅ Зменшувати навантаження на збирач сміття ♻️

### 🚨 Поганий приклад (зайві об'єкти)
```java
public class BadExample {
    public String getHello() {
        return new String("Hello!"); // ❌ ПОГАНО! Не потрібно створювати новий об'єкт рядка
    }
}
```
🔴 new String("Hello!") кожного разу створює новий об'єкт у пам’яті, хоча "Hello!" і так є константою.

### ✔ Правильний варіант:
```java
public class GoodExample {
    public String getHello() {
        return "Hello!"; // ✅ Хороше рішення – використовуємо пул рядків
    }
}
```

## 🏗 Як уникати зайвих об'єктів?
### 1️⃣ Використовуйте статичні фабричні методи
```java
public class BooleanFactory {
    public static Boolean valueOf(boolean value) {
        return value ? Boolean.TRUE : Boolean.FALSE; // ✅ Використання готових об'єктів
    }
}
```
Чому це добре?
- 🔵 Boolean.TRUE і Boolean.FALSE вже є готовими об'єктами. Ми не створюємо новий, а використовуємо один і той самий.

### 2️⃣ Кешуйте часто використовувані об'єкти
```java
public class RomanNumber {
    private static final Map<Integer, String> CACHE = Map.of(
            1, "I", 2, "II", 3, "III", 4, "IV", 5, "V"
    );

    public static String getRoman(int num) {
        return CACHE.getOrDefault(num, "❌");
    }
}
```
Чому це добре?
- 🔵 Замість того, щоб створювати нові рядки щоразу, ми беремо готові значення з кешу.

### 3️⃣ Не створюйте нові об'єкти там, де вони не потрібні
```java
public class BadMath {
    public boolean isEven(int num) {
        return new Integer(num) % 2 == 0; // ❌ ПОГАНО – new Integer створює зайвий об'єкт!
    }
}
```
- ✔ Кращий варіант:
```java
public class GoodMath {
    public boolean isEven(int num) {
        return num % 2 == 0; // ✅ Просто використовуємо int
    }
}
```


## 2.6 Избегайте создание излишних объектов (Item 6)

1. Повторное использование неизменяемых объектов(пулл)

```java
class StringPool {
    void pool() {
        String n = new String("bikini"); // Плохо
        String p = "bikini"; // Хорошо
    }
}
```

При повторном использовании, в первом случае будет создаваться новый объект, во втором использоваться старый из пула.

Использование статических фабричных методов для неизменяемого
объекта ([Item 3](#23-получайте-синглтон-с-помощью-закрытого-конструктора-или-типа-перечисления-item-3)):

`Boolean.valueOf(String)`

2. Кэширование тяжеловесных объектов

```java
class RomanNumerals {
    // Можно повысить производительность
    static boolean isRomanNumeralSlow(String s) {
        return s.matches("^(?=.)M*(C[MD]|D?C{0,3})" + "(X[CL]|L?X{0,3})(I[XV]|V?I{0,3})$");
    }
}

```

```java
// Оптимально
class Item6 {
    private static final Pattern ROMAN =
            Pattern.compile("^(?=.)M*(C[MD]|D?C{0,3})" + "(X[CL]|L?X{0,3})(I[XV]|V?I{0,3})$");

    static boolean isRomanNumeralFast(String s) {
        return ROMAN.matcher(s).matches();
    }
}

```

3. Предпочитайте примитивы классам оберткам и следите за непреднамеренной автоматической упаковкой

Но учтите:

- Не следует кэшировать легковесные объекты
- Избегайте создания собственного пула объектов. За исключением для тяжеловесных объектов, например подключение к базе
  данных