package org.mykhailotiutiun.agencyamazon.report.asin;

import org.mykhailotiutiun.agencyamazon.exception.NotFoundException;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class AsinReportServiceImpl implements AsinReportService {

    private final AsinReportRepository asinReportRepository;
    private final AsinSummaryReportGenerator summaryGenerator;

    public AsinReportServiceImpl(AsinReportRepository asinReportRepository, AsinSummaryReportGenerator summaryGenerator) {
        this.asinReportRepository = asinReportRepository;
        this.summaryGenerator = summaryGenerator;
    }

    @Override
    public AsinReport getByAsin(String asin) {
        return asinReportRepository.findByAsin(asin).orElseThrow(() -> new NotFoundException("Report not found"));
    }

    @Override
    public AsinSummaryReport getSummary() {
        return summaryGenerator.getSummary(asinReportRepository.findAll());
    }

    @Override
    public List<AsinReport> getAllByAsinIn(List<String> asins) {
        return asinReportRepository.findAllByAsinIn(asins);
    }

    @Override
    public void update(List<AsinReport> reports) {
        Set<AsinReport> newReports = new HashSet<>(reports);
        Set<AsinReport> currentReports = new HashSet<>(asinReportRepository.findAll());
        asinReportRepository.deleteAllWhereAsinIn(currentReports.stream()
                .filter(asinReport ->  !newReports.contains(asinReport))
                .map(AsinReport::getAsin)
                .toList());
        asinReportRepository.createAll(newReports.stream()
                .filter(asinReport -> !currentReports.contains(asinReport))
                .toList());
    }
}
