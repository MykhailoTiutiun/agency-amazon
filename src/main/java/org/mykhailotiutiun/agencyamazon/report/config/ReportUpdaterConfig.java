package org.mykhailotiutiun.agencyamazon.report.config;

import org.mykhailotiutiun.agencyamazon.report.asin.AsinReportService;
import org.mykhailotiutiun.agencyamazon.report.date.DateReportService;
import org.mykhailotiutiun.agencyamazon.report.updater.ReportFileReader;
import org.mykhailotiutiun.agencyamazon.report.updater.ReportReader;
import org.mykhailotiutiun.agencyamazon.report.updater.ReportsUpdaterImpl;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ReportUpdaterConfig {

    @Bean
    public ReportsUpdaterImpl reportsUpdater(ReportReader reportReader, DateReportService dateReportService, AsinReportService asinReportService){
        return new ReportsUpdaterImpl(reportReader, dateReportService, asinReportService);
    }

    @Bean
    public ReportFileReader reportFileReader(@Value("${report.update.file.location}") String filePath){
        return new ReportFileReader(filePath);
    }
}
