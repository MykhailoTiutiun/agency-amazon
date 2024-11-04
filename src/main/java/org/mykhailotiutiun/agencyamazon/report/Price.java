package org.mykhailotiutiun.agencyamazon.report;

import java.io.Serializable;

public class Price implements Serializable {

    private Double amount;

    private String currencyCode;

    public Double getAmount() {
        return amount;
    }

    public void setAmount(Double amount) {
        this.amount = amount;
    }

    public String getCurrencyCode() {
        return currencyCode;
    }

    public void setCurrencyCode(String currencyCode) {
        this.currencyCode = currencyCode;
    }
}
