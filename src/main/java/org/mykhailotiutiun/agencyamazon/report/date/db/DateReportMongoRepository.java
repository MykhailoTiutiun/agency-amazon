package org.mykhailotiutiun.agencyamazon.report.date.db;

import org.springframework.data.mongodb.repository.MongoRepository;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

public interface DateReportMongoRepository extends MongoRepository<DateReportJpa, LocalDate> {

    Optional<DateReportJpa> findByDate(LocalDate date);
    List<DateReportJpa> findAll();
    List<DateReportJpa> findAllByDateBetween(LocalDate begin, LocalDate end);

    void deleteAllByDateIn(List<LocalDate> dates);
}
