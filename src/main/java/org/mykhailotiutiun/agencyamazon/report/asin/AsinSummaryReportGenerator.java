package org.mykhailotiutiun.agencyamazon.report.asin;

import java.util.List;

public interface AsinSummaryReportGenerator {
    AsinSummaryReport getSummary(List<AsinReport> asinReports);
}
