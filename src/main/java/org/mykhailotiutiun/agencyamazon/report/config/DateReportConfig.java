package org.mykhailotiutiun.agencyamazon.report.config;

import org.mykhailotiutiun.agencyamazon.report.date.DateReportRepository;
import org.mykhailotiutiun.agencyamazon.report.date.DateReportServiceImpl;
import org.mykhailotiutiun.agencyamazon.report.date.DateSummaryReportGenerator;
import org.mykhailotiutiun.agencyamazon.report.date.DateSummaryReportGeneratorImpl;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class DateReportConfig {

    @Bean
    public DateReportServiceImpl dateReportService(DateReportRepository dateReportRepository, DateSummaryReportGenerator dateSummaryReportGenerator){
        return new DateReportServiceImpl(dateReportRepository, dateSummaryReportGenerator);
    }

    @Bean
    public DateSummaryReportGeneratorImpl dateSummaryReportGenerator(){
        return new DateSummaryReportGeneratorImpl();
    }
}
