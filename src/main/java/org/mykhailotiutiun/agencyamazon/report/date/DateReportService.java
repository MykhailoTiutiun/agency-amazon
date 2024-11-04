package org.mykhailotiutiun.agencyamazon.report.date;

import java.time.LocalDate;
import java.util.List;

public interface DateReportService {

    DateReport getByDate(LocalDate localDate);
    DateSummaryReport getSummary();
    List<DateReport> getByDateBetween(LocalDate begin, LocalDate end);

    void update(List<DateReport> reports);
}
