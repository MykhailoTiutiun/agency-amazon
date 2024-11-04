package org.mykhailotiutiun.agencyamazon.report.date;

import java.util.List;

public interface DateSummaryReportGenerator {
    DateSummaryReport getSummary(List<DateReport> dateReports);
}
