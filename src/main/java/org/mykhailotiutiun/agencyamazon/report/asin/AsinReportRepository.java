package org.mykhailotiutiun.agencyamazon.report.asin;

import java.util.List;
import java.util.Optional;

public interface AsinReportRepository {

    Optional<AsinReport> findByAsin(String asin);
    List<AsinReport> findAll();
    List<AsinReport> findAllByAsinIn(List<String> asins);

    void createAll(List<AsinReport> dateReports);
    void deleteAllWhereAsinIn(List<String> asins);
}
