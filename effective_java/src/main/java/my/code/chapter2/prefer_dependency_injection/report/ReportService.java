package my.code.chapter2.prefer_dependency_injection.report;

public class ReportService {
    private final Storage storage;

    public ReportService(Storage storage) {
        this.storage = storage;
    }

    public void createReport(String data) {
        String report = "📄 Report: " + data;
        storage.save(report);
    }
}
