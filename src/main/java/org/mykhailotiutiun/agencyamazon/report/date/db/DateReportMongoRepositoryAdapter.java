package org.mykhailotiutiun.agencyamazon.report.date.db;

import org.mykhailotiutiun.agencyamazon.report.date.DateReport;
import org.mykhailotiutiun.agencyamazon.report.date.DateReportRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Repository
public class DateReportMongoRepositoryAdapter implements DateReportRepository {

    private final DateReportMongoRepository dateReportMongoRepository;

    public DateReportMongoRepositoryAdapter(DateReportMongoRepository dateReportMongoRepository) {
        this.dateReportMongoRepository = dateReportMongoRepository;
    }

    @Override
    public Optional<DateReport> findByDate(LocalDate date) {
        Optional<DateReportJpa> reportJpa = dateReportMongoRepository.findByDate(date);
        if(reportJpa.isEmpty()){
            return Optional.empty();
        }
        return Optional.of(DateReportJpaMapper.dateReport(reportJpa.get()));
    }

    @Override
    public List<DateReport> findAll() {
        return dateReportMongoRepository.findAll().stream()
                .map(DateReportJpaMapper::dateReport)
                .collect(Collectors.toList());
    }

    @Override
    public List<DateReport> findAllByDateBetween(LocalDate begin, LocalDate end) {
        return dateReportMongoRepository.findAllByDateBetween(begin, end).stream()
                .map(DateReportJpaMapper::dateReport)
                .collect(Collectors.toList());
    }

    @Override
    public void createAll(List<DateReport> dateReports) {
        dateReportMongoRepository.saveAll(dateReports.stream()
                .map(DateReportJpaMapper::dateReportJpa)
                .toList());
    }

    @Override
    public void deleteAllWhereDate(List<LocalDate> date) {
        dateReportMongoRepository.deleteAllByDateIn(date);
    }
}
