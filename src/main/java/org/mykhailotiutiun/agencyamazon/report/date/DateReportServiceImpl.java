package org.mykhailotiutiun.agencyamazon.report.date;

import org.mykhailotiutiun.agencyamazon.exception.NotFoundException;

import java.time.LocalDate;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class DateReportServiceImpl implements DateReportService {

    private final DateReportRepository dateReportRepository;
    private final DateSummaryReportGenerator summaryGenerator;

    public DateReportServiceImpl(DateReportRepository dateReportRepository, DateSummaryReportGenerator summaryGenerator) {
        this.dateReportRepository = dateReportRepository;
        this.summaryGenerator = summaryGenerator;
    }

    @Override
    public DateReport getByDate(LocalDate localDate) {
        return dateReportRepository.findByDate(localDate).orElseThrow(() -> new NotFoundException("Report not found"));
    }

    @Override
    public DateSummaryReport getSummary() {
        return summaryGenerator.getSummary(dateReportRepository.findAll());
    }

    @Override
    public List<DateReport> getByDateBetween(LocalDate begin, LocalDate end) {
        return dateReportRepository.findAllByDateBetween(begin, end);
    }

    @Override
    public void update(List<DateReport> reports) {
        Set<DateReport> newReports = new HashSet<>(reports);
        Set<DateReport> currentReports = new HashSet<>(dateReportRepository.findAll());
        dateReportRepository.deleteAllWhereDate(currentReports.stream()
                .filter(dateReport ->  !newReports.contains(dateReport))
                .map(DateReport::getDate)
                .toList());
        dateReportRepository.createAll(newReports.stream()
                .filter(dateReport -> !currentReports.contains(dateReport))
                .toList());
    }
}
