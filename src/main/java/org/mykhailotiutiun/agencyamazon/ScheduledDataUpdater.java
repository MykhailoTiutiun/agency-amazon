package org.mykhailotiutiun.agencyamazon;

import org.mykhailotiutiun.agencyamazon.report.updater.ReportsUpdater;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@Component
public class ScheduledDataUpdater {

    private final ReportsUpdater reportsUpdater;

    public ScheduledDataUpdater(ReportsUpdater reportsUpdater) {
        this.reportsUpdater = reportsUpdater;
    }

    @Scheduled(cron = "${report.update.cron}")
    public void update(){
        reportsUpdater.update();
    }
}
