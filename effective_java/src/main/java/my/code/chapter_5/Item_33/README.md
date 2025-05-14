
## 📌 5.8: "Применяйте безопасные с точки зрения типов гетерогенные контейнеры"

### 🤔 Що це означає?
📦 Гетерогенний контейнер = контейнер, що зберігає об'єкти різних типів

Типовий приклад — Map<String, Object>:
```java
Map<String, Object> settings = new HashMap<>();
settings.put("timeout", 5000);
settings.put("name", "Server1");
settings.put("debug", true);
```
❗ Але це НЕ типобезпечно — при читанні ти не знаєш точний тип, і треба кастити вручну:
```java
int timeout = (Integer) settings.get("timeout"); // може впасти
```

### ✅ Що пропонує Блох (автор)?
- Використовувати типобезпечний гетерогенний контейнер через:
  - дженерики
  - спеціальний підхід із ключами, що включають тип

### 🧠 Просте пояснення:
Ключем у контейнері має бути тип, і тоді ти гарантовано отримаєш саме цей тип.

📌 Ідея: використовуй Class<T> як ключ:
```java
Map<Class<?>, Object> favorites = new HashMap<>();
```
І додай методи:
```java
<T> void putFavorite(Class<T> type, T instance)
<T> T getFavorite(Class<T> type)
```
📦 Це дозволяє зберігати об'єкти різних типів — але типобезпечно!

### 🧾 Висновок:
| ❌ Звичайна Map        | ✅ Гетерогенна типобезпечна Map                 |
| --------------------- | ---------------------------------------------- |
| `Map<String, Object>` | `Map<Class<?>, Object>` + методи з дженеріками |
| Потрібно кастити      | Кастинг безпечний через `Class.cast()`         |
| Runtime помилки       | Компілятор гарантує правильний тип             |

### 🔐 Типобезпечний контейнер =
Можливість зберігати різні типи в одному місці без ризику помилок типу.

Це дуже корисно для побудови:
- налаштувань
- реєстрів залежностей (DI)
- сервіс-локаторів
- контекстів (як ServletContext)




## 5.8 Применяйте безопасные с точки зрения типов гетерогенные контейнеры (Item 33)

Использование обобщенных типов ограничивает фиксированным количествам параметров типа в контейнере. Например,
коллекции `Set<E>` нельзя сделать произвольное количество параметров типа `Set<E...>`.

Можно это обойти, помещая параметр типа в ключ, а не в контейнер.

```java

public class Favorites {
    private Map<Class<?>, Object> favorites = new HashMap<Class<?>, Object>();

    public <T> void putFavorites(Class<T> type, T instance) {
        if (type == null)
            throw new NullPointerException("Type is null");
        favorites.put(type, type.cast(instance));//runtime safety with a dynamic cast
    }

    public <T> getFavorite(Class<T> type) {
        return type.cast(favorites.get(type));
    }
}

```