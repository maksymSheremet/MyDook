package my.code.chapter2.prefer_dependency_injection.report;

public class FileStorage implements Storage {
    @Override
    public void save(String report) {
        System.out.println("💾 Збережено у файл: " + report);
    }
}
