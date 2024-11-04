package org.mykhailotiutiun.agencyamazon.report.config;

import org.mykhailotiutiun.agencyamazon.report.asin.AsinReportRepository;
import org.mykhailotiutiun.agencyamazon.report.asin.AsinReportServiceImpl;
import org.mykhailotiutiun.agencyamazon.report.asin.AsinSummaryReportGenerator;
import org.mykhailotiutiun.agencyamazon.report.asin.AsinSummaryReportGeneratorImpl;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AsinReportConfig {

    @Bean
    public AsinReportServiceImpl asinReportService(AsinReportRepository asinReportRepository, AsinSummaryReportGenerator asinSummaryReportGenerator){
        return new AsinReportServiceImpl(asinReportRepository, asinSummaryReportGenerator);
    }

    @Bean
    public AsinSummaryReportGeneratorImpl asinSummaryReportGenerator(){
        return new AsinSummaryReportGeneratorImpl();
    }

}
