package org.mykhailotiutiun.agencyamazon.report.date;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

public interface DateReportRepository {

    Optional<DateReport> findByDate(LocalDate date);
    List<DateReport> findAll();
    List<DateReport> findAllByDateBetween(LocalDate begin, LocalDate end);

    void createAll(List<DateReport> dateReports);
    void deleteAllWhereDate(List<LocalDate> date);
}
