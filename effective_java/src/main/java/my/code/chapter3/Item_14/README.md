## 📌 3.5 "Подумайте про реалізацію Comparable"

### 🧠 Головна ідея:
> Якщо твої об'єкти мають "природний порядок" (natural ordering), реалізуй інтерфейс ```Comparable<T>```.

Це дає змогу:
- використовувати їх у сортованих колекціях (TreeSet, TreeMap)
- сортувати списки через Collections.sort(...) або List.sort(...)
- писати менше коду для типових порівнянь

### 📘 Як виглядає Comparable<T>?
```java
public interface Comparable<T> {
   int compareTo(T other);
}
```
Метод compareTo() має повертати:
- -1, якщо this < other
- 0, якщо this == other
- 1, якщо this > other

(А точніше: будь-яке від'ємне / нуль / додатне число)

### ⚠️ Поради з Effective Java
1. Контракт compareTo() має бути узгодженим з equals()
   - Якщо x.compareTo(y) == 0, то бажано, щоб x.equals(y) було true
   - Але це не обов'язково, лише бажано для уникнення багів у TreeMap/TreeSet
2. Не забувай про NullPointerException
   - compareTo(null) зазвичай кидає NullPointerException, і це ок.
3. Використовуй Comparator для складних варіантів
   - Якщо потрібно сортувати по кількох полях — спочатку по одному, потім по іншому.
```java
@Override
public int compareTo(Person other) {
   int cmp = this.name.compareTo(other.name);
   if (cmp != 0) return cmp;
   return Integer.compare(this.age, other.age);
}
```



## 3.5 Подумайте о реализации Comparable (Item 14)

Реализуя класс значения(value class), которое имеет упорядочение, обеспечивайте реализацию `Comparable`, чтобы его
экземпляры можно было легко сортировать, искать и использовать в коллекциях, основных на сравнениях.

Контракт метода `compareTo`:

- `x.compareTo(y) == - (y.compareTo(x))`
- если `x.compareTo(y) > 0 && y.compareTo(z) > 0`, тогда и `x.compareTo(z) > 0`
- если `x.compareTo(y) == 0`, тогда и `x.compareTo(z) == y.compareTo(z)`
- Рекомендуется, но не обязательно: `(x.compareTo(y)==0) == (x.equals(y))`

Если метод `compareTo` сталкивается с объектами разных типов, генерируйте исключение `ClassCastException`.

При сравнении значимых полей в `compareTo` следует избегать операторы `<` и `>`. Вместо этого использовать
статистические методы `compare` классов оберток примитивных типов(`Integer.compare` и др.) или методы конструирования
компаратора в интерфейсе`Comparator`(`Comparator.comparingInt` и др.).
