## 📌 4.4: "Предпочитайте композицию наследованию"

### 📘 Про що цей пункт?
🔑 Головна думка:
> Краще використовувати композицію, ніж спадкування, бо це:
- гнучкіше;
- безпечніше;
- дозволяє уникнути багатьох підводних каменів.

### 🛠 Просте пояснення
📎 Спадкування (наслідування) — це коли клас A "є" класом B:
```java
class Dog extends Animal { ... }
```
Тобто Dog є Animal.

👎 Але з цим часто бувають проблеми:
- ти отримуєш весь API батьківського класу (навіть непотрібний);
- ти залежиш від його поведінки — вона може змінитись, і все зламається;
- ти не можеш успадкувати кілька класів;
- виникають баги через "неправильне використання" методів батька.

🔧 Композиція — це коли клас A "має" об'єкт B:
```java
class Car {
    private Engine engine;
}
```
Тобто Car має Engine.

Це гнучкіше:
- ти сам вирішуєш, які методи показувати назовні;
- можеш міняти реалізацію в будь-який момент;
- можеш легко делегувати виклики, не наслідуючи зайвого.

### 🧠 Висновок:
| **Наслідування**                     | *Композиція*            |
|--------------------------------------|-------------------------|
| Жорстка залежність                   | Гнучка структура        |
| Успадковуєш весь API (навіть зайвий) | Сам керуєш доступом     |
| Підходить тільки якщо "is-a"	        | Підходить коли "has-a"  |
| Може ламатись при зміні батька       | Більш стабільна до змін |



## 4.4 Предпочитайте композицию наследованию (Item 18)

Речь идет только о наследовании от другого класса, а не о реализации интерфейса.

Наследование нарушает инкапсуляцию:

- Реализация суперкласса может меняться от версии к версии, и, если это происходит,
  подкласс может перестать корректно работать, даже если его код останется нетронутым.
- В новых версиях суперкласса может появиться новый метод, который не будет учитываться в подклассах и может привести
  проблемы с безопасностью.

Композиция как альтернатива наследованию. В классе создать закрытое поле, которое будет содержать ссылку на экземпляр
существующего класса. Каждый метод экземпляра в новом классе вызывает соответсвующий метод содержащего в классе
экземпляра существующего класса, а затем возвращает полученный результат. Эта технология передачи (forwarding), а
методы - методы передачи (forwarding methods).

```java
// Wrapper class - uses composition in place of inheritance
public class InstrumentedSet<E> extends ForwardingSet<E> {
    private int addCount = 0;

    public InstrumentedSet(Set<E> s) {
        super(s);
    }

    @Override
    public boolean add(E e) {
        addCount++;
        return super.add(e);
    }

    @Override
    public boolean addAll(Collection<? extends E> c) {
        addCount += c.size();
        return super.addAll(c);
    }

    public int getAddCount() {
        return addCount;
    }
}

// Reusable forwarding class
public class ForwardingSet<E> implements Set<E> {
    private final Set<E> s;

    public ForwardingSet(Set<E> s) {
        this.s = s;
    }

    public void clear() {
        s.clear();
    }

    public boolean contains(Object o) {
        return s.contains(o);
    }

    public boolean isEmpty() {
        return s.isEmpty();
    }

    public int size() {
        return s.size();
    }

    public Iterator<E> iterator() {
        return s.iterator();
    }

    public boolean add(E e) {
        return s.add(e);
    }

    public boolean remove(Object o) {
        return s.remove(o);
    }

    public boolean containsAll(Collection<?> c) {
        return s.containsAll(c);
    }

    public boolean addAll(Collection<? extends E> c) {
        return s.addAll(c);
    }

    public boolean removeAll(Collection<?> c) {
        return s.removeAll(c);
    }

    public boolean retainAll(Collection<?> c) {
        return s.retainAll(c);
    }

    public Object[] toArray() {
        return s.toArray();
    }

    public <T> T[] toArray(T[] a) {
        return s.toArray(a);
    }

    @Override
    public boolean equals(Object o) {
        return s.equals(o);
    }

    @Override
    public int hashCode() {
        return s.hashCode();
    }

    @Override
    public String toString() {
        return s.toString();
    }
}

```

У данного подхода мало недостатков, один из них `SELF problem`, остальные менее существенные.

Пользоваться наследованием можно, если между классом и суперклассом есть реальная связь типа и подтипа. Но даже в этом
случае применение наследование может сделать программу ненадежной, особенно если подкласс и суперкласс принадлежат к
разным пакетам, а сам суперкласс не был изначально предназначен для расширения.
