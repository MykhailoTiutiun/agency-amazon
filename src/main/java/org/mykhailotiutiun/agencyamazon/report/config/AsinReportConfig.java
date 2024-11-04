package org.mykhailotiutiun.agencyamazon.report.config;

import org.mykhailotiutiun.agencyamazon.report.asin.*;
import org.mykhailotiutiun.agencyamazon.report.asin.cache.AsinReportServiceCache;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;

@Configuration
public class AsinReportConfig {

    @Bean
    @Primary
    public AsinReportServiceCache asinReportServiceCache(AsinReportService asinReportService){
        return new AsinReportServiceCache(asinReportService);
    }
    @Bean
    public AsinReportServiceImpl asinReportService(AsinReportRepository asinReportRepository, AsinSummaryReportGenerator asinSummaryReportGenerator){
        return new AsinReportServiceImpl(asinReportRepository, asinSummaryReportGenerator);
    }

    @Bean
    public AsinSummaryReportGeneratorImpl asinSummaryReportGenerator(){
        return new AsinSummaryReportGeneratorImpl();
    }

}
