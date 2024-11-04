package org.mykhailotiutiun.agencyamazon.report.config;

import org.mykhailotiutiun.agencyamazon.report.date.*;
import org.mykhailotiutiun.agencyamazon.report.date.cache.DateReportServiceCache;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;

@Configuration
public class DateReportConfig {

    @Bean
    @Primary
    public DateReportServiceCache dateReportServiceCache(DateReportService dateReportService){
        return new DateReportServiceCache(dateReportService);
    }
    @Bean
    public DateReportServiceImpl dateReportService(DateReportRepository dateReportRepository, DateSummaryReportGenerator dateSummaryReportGenerator){
        return new DateReportServiceImpl(dateReportRepository, dateSummaryReportGenerator);
    }

    @Bean
    public DateSummaryReportGeneratorImpl dateSummaryReportGenerator(){
        return new DateSummaryReportGeneratorImpl();
    }
}
