## 📌 2.9 "Предпочитайте try-with-resources вместо try-finally"

### 🧠 Що це значить?
Коли ми працюємо з ресурсами — наприклад, файлами, потоками (InputStream, OutputStream, BufferedReader тощо) — ми завжди повинні їх закривати після використання. Бо інакше буде витік ресурсів (наприклад, файл залишиться відкритим і заблокує диск).


### 📚 У старих версіях Java ми писали ось так:
```java
BufferedReader reader = null;
try {
    reader = new BufferedReader(new FileReader("data.txt"));
    String line = reader.readLine();
    System.out.println(line);
} catch (IOException e) {
    e.printStackTrace();
} finally {
    if (reader != null) {
        try {
            reader.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
```
👆 Це довго, грубо і легко забути щось.


### ✅ Як краще?
З Java 7 з'явився try-with-resources — якщо ресурс імплементує AutoCloseable, то його буде автоматично закрито, навіть якщо станеться виняток:
```java
try (BufferedReader reader = new BufferedReader(new FileReader("data.txt"))) {
    String line = reader.readLine();
    System.out.println(line);
} catch (IOException e) {
    e.printStackTrace();
}
```
☕ Менше коду + автоматичне закриття!

### ✅ Основна ідея:
- Автоматичне закриття ресурсів.
- Менше коду, менше помилок.
- Немає потреби писати finally вручну.


## 2.9 Предпочитайте try-with-recurse использованию try-finally (Item 9)

Предпочитайте `try-with-recurse` применению `try-finally` при работе с ресурсами, которые должны быть закрыты.
Результирующий код получается короче и понятнее, а исключения, которые он генерирует, — более полезными.

```java
class Item9 {
    static void copy(String src, String dst) throws IOException {
        try (InputStream in = new InputStream(src);
             OutputStream out = new FileOutputStream(dst)) {
            byte[] buf = new byte[BUFFER_SIZE];
            int n;
            while ((n = in.read(buf)) >= 0) {
                out.write(buf, 0, n);
            }
        }
    }
}

```

Оператор `try-with-recurse` облегчает написание корректного кода с использованием ресурсов, которые должны быть закрыты,
что практически невозможно с помощью `try-finally`.