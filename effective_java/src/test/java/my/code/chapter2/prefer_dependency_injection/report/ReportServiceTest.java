package my.code.chapter2.prefer_dependency_injection.report;

import org.junit.jupiter.api.Test;
import static org.mockito.Mockito.*;


class ReportServiceTest {

    @Test
    void testReportSaveStorage() {
        Storage mockStorage = mock(Storage.class);
        ReportService service = new ReportService(mockStorage);

        service.createReport("Hello");
        verify(mockStorage).save("📄 Report: Hello");
    }

}