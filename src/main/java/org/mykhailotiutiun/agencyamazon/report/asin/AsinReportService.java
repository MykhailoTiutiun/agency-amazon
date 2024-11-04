package org.mykhailotiutiun.agencyamazon.report.asin;

import java.util.List;

public interface AsinReportService {

    AsinReport getByAsin(String asin);
    AsinSummaryReport getSummary();
    List<AsinReport> getAllByAsinIn(List<String> asins);

    void update(List<AsinReport> reports);
}
