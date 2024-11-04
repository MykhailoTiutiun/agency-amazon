package org.mykhailotiutiun.agencyamazon.report.date.cache;

import org.mykhailotiutiun.agencyamazon.report.date.DateReport;
import org.mykhailotiutiun.agencyamazon.report.date.DateReportService;
import org.mykhailotiutiun.agencyamazon.report.date.DateSummaryReport;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.cache.annotation.Caching;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Primary
@Service
public class DateReportServiceCache implements DateReportService {

    private final DateReportService dateReportService;

    public DateReportServiceCache(DateReportService dateReportService) {
        this.dateReportService = dateReportService;
    }

    @Override
    @Cacheable("date_report")
    public DateReport getByDate(LocalDate localDate) {
        return dateReportService.getByDate(localDate);
    }

    @Override
    @Cacheable("date_summary_report")
    public DateSummaryReport getSummary() {
        return dateReportService.getSummary();
    }

    @Override
    @Cacheable("date_report")
    public List<DateReport> getByDateBetween(LocalDate begin, LocalDate end) {
        return dateReportService.getByDateBetween(begin, end);
    }

    @Override
    @Caching(evict = {
            @CacheEvict(value = "date_report", allEntries = true),
            @CacheEvict(value = "date_report_summary", allEntries = true)
    })
    public void update(List<DateReport> reports) {
        dateReportService.update(reports);
    }
}
