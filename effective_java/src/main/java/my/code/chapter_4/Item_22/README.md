## 📌 4.8: "Используйте интерфейсы только для определения типов"

### 📘 Про що цей пункт?
🔑 Головна думка:
>Інтерфейси потрібні тільки для опису типів поведінки, а не для зберігання констант або якихось даних.

### 🛠 Просте пояснення:
Раніше (до Java 5) люди часто використовували інтерфейси для констант:
```java
public interface Constants {
   int MAX_SIZE = 100;
   int MIN_SIZE = 1;
}
```
Потім класи імплементували ці інтерфейси просто для того, щоб отримати доступ до констант:
```java
public class Box implements Constants {
   // Тепер доступ до MAX_SIZE
}
```
❗️ Це погано, тому що:
- Клас Box стає частиною контракту Constants, хоча він взагалі нічого не обіцяє реалізовувати!
- Логічно Box не є "спеціальним типом" Constants.
- Це плутає код і порушує принцип чистого типу.

✅ Як правильно
- Якщо треба глобальні константи → використовуй final клас з public static final полями
```java
public final class Constants {
   private Constants() {} // Забороняємо створення об'єктів

   public static final int MAX_SIZE = 100;
   public static final int MIN_SIZE = 1;
}
```
Тепер просто звертаємося:
```java
int size = Constants.MAX_SIZE;
```

### 📋 Чому інтерфейси тільки для визначення типів?
Тому що:
- Інтерфейс — це договір про поведінку (наприклад, "це можна save", або "це можна play");
- Якщо змішувати інтерфейси і константи — виходить каша.

### 🧠 Висновок:
| *Якщо треба*                      | *Використовуй*                            |
|-----------------------------------|-------------------------------------------|
| Описати тип поведінки (контракт)  | Інтерфейс                                 |
| Зберігати константи               | final клас із public static final полями  |




## 4.8 Используйте интерфейсы только для определения типов (Item 22)

Интерфейс следует использовать в качестве определения типа, который может быть использован для ссылки на экземпляры
класса.

Не следует использовать интерфейс констант:

```java
// Constant interface antipattern. Don't do it !
public interface PhysicalConstants {
    static final double AVOGADROS_NUMBER = 6.022_140_857e23;
    static final double BOLTZMAN_CONSTANT = 1.380_648_52e-23;
}

```

Лучше использовать утильный класс констант:

```java
public class PhysicalConstants {
    private PhysicalConstants() {
    } // Prevents instantiation

    public static final double AVOGRADOS_NUMBER = 6.02214199e23;
    public static final double BOLTZAN_CONSTANT = 1.3806503e-23;
    public static final double ELECTRON_MASS = 9.10938188e-31;
}

```
