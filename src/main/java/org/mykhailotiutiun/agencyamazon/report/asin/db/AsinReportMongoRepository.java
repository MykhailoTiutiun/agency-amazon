package org.mykhailotiutiun.agencyamazon.report.asin.db;

import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;
import java.util.Optional;

public interface AsinReportMongoRepository extends MongoRepository<AsinReportJpa, String> {

    Optional<AsinReportJpa> findByAsin(String asin);
    List<AsinReportJpa> findAll();
    List<AsinReportJpa> findAllByAsinIn(List<String> asins);

    void deleteAllByAsinIn(List<String> asins);
}
