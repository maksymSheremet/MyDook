package my.code.chapter2.prefer_dependency_injection.report;

public class CloudStorage implements Storage {
    @Override
    public void save(String report) {
        System.out.println("☁️ Збережено у хмару: " + report);
    }
}
