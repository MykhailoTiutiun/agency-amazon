package org.mykhailotiutiun.agencyamazon.report.asin.cache;

import org.mykhailotiutiun.agencyamazon.report.asin.AsinReport;
import org.mykhailotiutiun.agencyamazon.report.asin.AsinReportService;
import org.mykhailotiutiun.agencyamazon.report.asin.AsinSummaryReport;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.cache.annotation.Caching;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;

import java.util.List;

@Primary
@Service
public class AsinReportServiceCache implements AsinReportService {

    private final AsinReportService asinReportService;

    public AsinReportServiceCache(AsinReportService asinReportService) {
        this.asinReportService = asinReportService;
    }

    @Override
    @Cacheable("date_report")
    public AsinReport getByAsin(String asin) {
        return asinReportService.getByAsin(asin);
    }

    @Override
    @Cacheable("date_report")
    public List<AsinReport> getAllByAsinIn(List<String> asins) {
        return asinReportService.getAllByAsinIn(asins);
    }

    @Override
    @Cacheable("asin_summary_report")
    public AsinSummaryReport getSummary() {
        return asinReportService.getSummary();
    }

    @Override
    @Caching(evict = {
            @CacheEvict(value = "date_report", allEntries = true),
            @CacheEvict(value = "asin_summary_report", allEntries = true)
    })
    public void update(List<AsinReport> reports) {
        asinReportService.update(reports);
    }
}
