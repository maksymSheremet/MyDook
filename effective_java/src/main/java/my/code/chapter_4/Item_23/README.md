## 📌 4.9: "Предпочитайте иерархии классов дескрипторам классов"

### 📘 Про що це?
🔑 Головна ідея:
>Замість того, щоб створювати один клас з "типовим полем" (дескриптором), краще будувати ієрархію класів.

### 🛠 Просте пояснення:
Погана практика:
- Створювати один клас з полем типу int, String або enum, що описує поведінку.
- Потім писати купу if-else або switch, щоб міняти поведінку залежно від цього "дескриптора".

Це ускладнює код і порушує принцип відкритості/закритості (OCP):
>"Код має бути відкритим для розширення, але закритим для модифікації".

❌ Поганий приклад (з дескриптором):
```java
public class Shape {
    public enum ShapeType { CIRCLE, RECTANGLE }

    private final ShapeType type;

    public Shape(ShapeType type) {
        this.type = type;
    }

    public double area() {
        switch (type) {
            case CIRCLE:
                // обчислення для кола
                return Math.PI * 1 * 1;
            case RECTANGLE:
                // обчислення для прямокутника
                return 2 * 3;
            default:
                throw new AssertionError("Unknown shape: " + type);
        }
    }
}
```
- Якщо хочеш додати нову форму → треба лізти в Shape і міняти switch-case.
- Це погано!

✅ Кращий варіант (ієрархія класів):
```java
public abstract class Shape {
    public abstract double area();
}

public class Circle extends Shape {
    private final double radius;

    public Circle(double radius) {
        this.radius = radius;
    }

    @Override
    public double area() {
        return Math.PI * radius * radius;
    }
}

public class Rectangle extends Shape {
    private final double width;
    private final double height;

    public Rectangle(double width, double height) {
        this.width = width;
        this.height = height;
    }

    @Override
    public double area() {
        return width * height;
    }
}
```
- Тепер, щоб додати нову форму, просто створюєш новий клас, а існуючий код не чіпаєш.
- Чисто і зрозуміло! 😎

### 📋 Чому ієрархії краще:
- Поліморфізм — кожен клас сам знає, що робити.
- Розширюваність — додаємо нові класи без змін старого коду.
- Читабельність — кожна форма реалізує свою поведінку окремо.

### 🧠 Висновок:
| *Якщо хочеш*         | *Використовуй*                      |
|----------------------|-------------------------------------|
| Різні типи поведінки | Ієрархії класів                     |
| Описувати лише дані  | Інші підходи (наприклад, константи) |




## 4.9 Предпочитайте иерархии классов дескрипторам классов (Item 23)

Поле класса _дескриптор_ - указывает разновидность класса, который может находиться в разных состояниях.

Классы с дескрипторами многословны, склонны к ошибкам и неэффективны.

Применение дескрипторов является лишь бледным подобием иерархии классов. И лучше задуматься над рефакторингом.