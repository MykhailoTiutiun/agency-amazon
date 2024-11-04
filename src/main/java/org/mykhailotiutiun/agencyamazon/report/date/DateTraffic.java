package org.mykhailotiutiun.agencyamazon.report.date;

import java.io.Serializable;
import java.util.Objects;

public class DateTraffic implements Serializable {
    private Integer browserPageViews;

    private Integer browserPageViewsB2B;

    private Integer mobileAppPageViews;

    private Integer mobileAppPageViewsB2B;

    private Integer pageViews;

    private Integer pageViewsB2B;

    private Integer browserSessions;

    private Integer browserSessionsB2B;

    private Integer mobileAppSessions;

    private Integer mobileAppSessionsB2B;

    private Integer sessions;

    private Integer sessionsB2B;

    private Double buyBoxPercentage;

    private Double buyBoxPercentageB2B;

    private Double orderItemSessionPercentage;

    private Double orderItemSessionPercentageB2B;

    private Double unitSessionPercentage;

    private Double unitSessionPercentageB2B;

    private Integer averageOfferCount;

    private Integer averageParentItems;

    private Integer feedbackReceived;

    private Integer negativeFeedbackReceived;

    private Double receivedNegativeFeedbackRate;

    // Getters and Setters
    public Integer getBrowserPageViews() {
        return browserPageViews;
    }

    public void setBrowserPageViews(Integer browserPageViews) {
        this.browserPageViews = browserPageViews;
    }

    public Integer getBrowserPageViewsB2B() {
        return browserPageViewsB2B;
    }

    public void setBrowserPageViewsB2B(Integer browserPageViewsB2B) {
        this.browserPageViewsB2B = browserPageViewsB2B;
    }

    public Integer getMobileAppPageViews() {
        return mobileAppPageViews;
    }

    public void setMobileAppPageViews(Integer mobileAppPageViews) {
        this.mobileAppPageViews = mobileAppPageViews;
    }

    public Integer getMobileAppPageViewsB2B() {
        return mobileAppPageViewsB2B;
    }

    public void setMobileAppPageViewsB2B(Integer mobileAppPageViewsB2B) {
        this.mobileAppPageViewsB2B = mobileAppPageViewsB2B;
    }

    public Integer getPageViews() {
        return pageViews;
    }

    public void setPageViews(Integer pageViews) {
        this.pageViews = pageViews;
    }

    public Integer getPageViewsB2B() {
        return pageViewsB2B;
    }

    public void setPageViewsB2B(Integer pageViewsB2B) {
        this.pageViewsB2B = pageViewsB2B;
    }

    public Integer getBrowserSessions() {
        return browserSessions;
    }

    public void setBrowserSessions(Integer browserSessions) {
        this.browserSessions = browserSessions;
    }

    public Integer getBrowserSessionsB2B() {
        return browserSessionsB2B;
    }

    public void setBrowserSessionsB2B(Integer browserSessionsB2B) {
        this.browserSessionsB2B = browserSessionsB2B;
    }

    public Integer getMobileAppSessions() {
        return mobileAppSessions;
    }

    public void setMobileAppSessions(Integer mobileAppSessions) {
        this.mobileAppSessions = mobileAppSessions;
    }

    public Integer getMobileAppSessionsB2B() {
        return mobileAppSessionsB2B;
    }

    public void setMobileAppSessionsB2B(Integer mobileAppSessionsB2B) {
        this.mobileAppSessionsB2B = mobileAppSessionsB2B;
    }

    public Integer getSessions() {
        return sessions;
    }

    public void setSessions(Integer sessions) {
        this.sessions = sessions;
    }

    public Integer getSessionsB2B() {
        return sessionsB2B;
    }

    public void setSessionsB2B(Integer sessionsB2B) {
        this.sessionsB2B = sessionsB2B;
    }

    public Double getBuyBoxPercentage() {
        return buyBoxPercentage;
    }

    public void setBuyBoxPercentage(Double buyBoxPercentage) {
        this.buyBoxPercentage = buyBoxPercentage;
    }

    public Double getBuyBoxPercentageB2B() {
        return buyBoxPercentageB2B;
    }

    public void setBuyBoxPercentageB2B(Double buyBoxPercentageB2B) {
        this.buyBoxPercentageB2B = buyBoxPercentageB2B;
    }

    public Double getOrderItemSessionPercentage() {
        return orderItemSessionPercentage;
    }

    public void setOrderItemSessionPercentage(Double orderItemSessionPercentage) {
        this.orderItemSessionPercentage = orderItemSessionPercentage;
    }

    public Double getOrderItemSessionPercentageB2B() {
        return orderItemSessionPercentageB2B;
    }

    public void setOrderItemSessionPercentageB2B(Double orderItemSessionPercentageB2B) {
        this.orderItemSessionPercentageB2B = orderItemSessionPercentageB2B;
    }

    public Double getUnitSessionPercentage() {
        return unitSessionPercentage;
    }

    public void setUnitSessionPercentage(Double unitSessionPercentage) {
        this.unitSessionPercentage = unitSessionPercentage;
    }

    public Double getUnitSessionPercentageB2B() {
        return unitSessionPercentageB2B;
    }

    public void setUnitSessionPercentageB2B(Double unitSessionPercentageB2B) {
        this.unitSessionPercentageB2B = unitSessionPercentageB2B;
    }

    public Integer getAverageOfferCount() {
        return averageOfferCount;
    }

    public void setAverageOfferCount(Integer averageOfferCount) {
        this.averageOfferCount = averageOfferCount;
    }

    public Integer getAverageParentItems() {
        return averageParentItems;
    }

    public void setAverageParentItems(Integer averageParentItems) {
        this.averageParentItems = averageParentItems;
    }

    public Integer getFeedbackReceived() {
        return feedbackReceived;
    }

    public void setFeedbackReceived(Integer feedbackReceived) {
        this.feedbackReceived = feedbackReceived;
    }

    public Integer getNegativeFeedbackReceived() {
        return negativeFeedbackReceived;
    }

    public void setNegativeFeedbackReceived(Integer negativeFeedbackReceived) {
        this.negativeFeedbackReceived = negativeFeedbackReceived;
    }

    public Double getReceivedNegativeFeedbackRate() {
        return receivedNegativeFeedbackRate;
    }

    public void setReceivedNegativeFeedbackRate(Double receivedNegativeFeedbackRate) {
        this.receivedNegativeFeedbackRate = receivedNegativeFeedbackRate;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        DateTraffic traffic = (DateTraffic) o;
        return Objects.equals(browserPageViews, traffic.browserPageViews) && Objects.equals(browserPageViewsB2B, traffic.browserPageViewsB2B) && Objects.equals(mobileAppPageViews, traffic.mobileAppPageViews) && Objects.equals(mobileAppPageViewsB2B, traffic.mobileAppPageViewsB2B) && Objects.equals(pageViews, traffic.pageViews) && Objects.equals(pageViewsB2B, traffic.pageViewsB2B) && Objects.equals(browserSessions, traffic.browserSessions) && Objects.equals(browserSessionsB2B, traffic.browserSessionsB2B) && Objects.equals(mobileAppSessions, traffic.mobileAppSessions) && Objects.equals(mobileAppSessionsB2B, traffic.mobileAppSessionsB2B) && Objects.equals(sessions, traffic.sessions) && Objects.equals(sessionsB2B, traffic.sessionsB2B) && Objects.equals(buyBoxPercentage, traffic.buyBoxPercentage) && Objects.equals(buyBoxPercentageB2B, traffic.buyBoxPercentageB2B) && Objects.equals(orderItemSessionPercentage, traffic.orderItemSessionPercentage) && Objects.equals(orderItemSessionPercentageB2B, traffic.orderItemSessionPercentageB2B) && Objects.equals(unitSessionPercentage, traffic.unitSessionPercentage) && Objects.equals(unitSessionPercentageB2B, traffic.unitSessionPercentageB2B) && Objects.equals(averageOfferCount, traffic.averageOfferCount) && Objects.equals(averageParentItems, traffic.averageParentItems) && Objects.equals(feedbackReceived, traffic.feedbackReceived) && Objects.equals(negativeFeedbackReceived, traffic.negativeFeedbackReceived) && Objects.equals(receivedNegativeFeedbackRate, traffic.receivedNegativeFeedbackRate);
    }

    @Override
    public int hashCode() {
        return Objects.hash(browserPageViews, browserPageViewsB2B, mobileAppPageViews, mobileAppPageViewsB2B, pageViews, pageViewsB2B, browserSessions, browserSessionsB2B, mobileAppSessions, mobileAppSessionsB2B, sessions, sessionsB2B, buyBoxPercentage, buyBoxPercentageB2B, orderItemSessionPercentage, orderItemSessionPercentageB2B, unitSessionPercentage, unitSessionPercentageB2B, averageOfferCount, averageParentItems, feedbackReceived, negativeFeedbackReceived, receivedNegativeFeedbackRate);
    }
}