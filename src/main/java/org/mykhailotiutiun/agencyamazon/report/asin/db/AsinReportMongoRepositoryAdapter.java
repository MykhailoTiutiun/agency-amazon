package org.mykhailotiutiun.agencyamazon.report.asin.db;

import org.mykhailotiutiun.agencyamazon.report.asin.AsinReport;
import org.mykhailotiutiun.agencyamazon.report.asin.AsinReportRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Repository
public class AsinReportMongoRepositoryAdapter implements AsinReportRepository {

    private final AsinReportMongoRepository asinReportMongoRepository;

    public AsinReportMongoRepositoryAdapter(AsinReportMongoRepository asinReportMongoRepository) {
        this.asinReportMongoRepository = asinReportMongoRepository;
    }

    @Override
    public Optional<AsinReport> findByAsin(String asin) {
        Optional<AsinReportJpa> reportJpa = asinReportMongoRepository.findByAsin(asin);
        if(reportJpa.isEmpty()){
            return Optional.empty();
        }
        return Optional.of(AsinReportJpaMapper.dateReport(reportJpa.get()));
    }

    @Override
    public List<AsinReport> findAll() {
        return asinReportMongoRepository.findAll().stream()
                .map(AsinReportJpaMapper::dateReport)
                .collect(Collectors.toList());
    }

    @Override
    public List<AsinReport> findAllByAsinIn(List<String> asins) {
        return asinReportMongoRepository.findAllByAsinIn(asins).stream()
                .map(AsinReportJpaMapper::dateReport)
                .collect(Collectors.toList());
    }

    @Override
    public void createAll(List<AsinReport> dateReports) {
        asinReportMongoRepository.saveAll(dateReports.stream()
                .map(AsinReportJpaMapper::dateReportJpa)
                .toList());
    }

    @Override
    public void deleteAllWhereAsinIn(List<String> asins) {
        asinReportMongoRepository.deleteAllByAsinIn(asins);
    }
}
