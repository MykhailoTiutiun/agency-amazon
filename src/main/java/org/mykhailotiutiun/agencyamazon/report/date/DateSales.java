package org.mykhailotiutiun.agencyamazon.report.date;

import org.mykhailotiutiun.agencyamazon.report.Price;

import java.io.Serializable;

public class DateSales implements Serializable {

    private Price orderedProductSales;

    private Price orderedProductSalesB2B;

    private Integer unitsOrdered;

    private Integer unitsOrderedB2B;

    private Integer totalOrderItems;

    private Integer totalOrderItemsB2B;

    private Price averageSalesPerOrderItem;

    private Price averageSalesPerOrderItemB2B;

    private Double averageUnitsPerOrderItem;

    private Double averageUnitsPerOrderItemB2B;

    private Price averageSellingPrice;

    private Price averageSellingPriceB2B;

    private Integer unitsRefunded;

    private Double refundRate;

    private Integer claimsGranted;

    private Price claimsAmount;

    private Price shippedProductSales;

    private Integer unitsShipped;

    private Integer ordersShipped;

    public Price getOrderedProductSales() {
        return orderedProductSales;
    }

    public void setOrderedProductSales(Price orderedProductSales) {
        this.orderedProductSales = orderedProductSales;
    }

    public Price getOrderedProductSalesB2B() {
        return orderedProductSalesB2B;
    }

    public void setOrderedProductSalesB2B(Price orderedProductSalesB2B) {
        this.orderedProductSalesB2B = orderedProductSalesB2B;
    }

    public Integer getUnitsOrdered() {
        return unitsOrdered;
    }

    public void setUnitsOrdered(Integer unitsOrdered) {
        this.unitsOrdered = unitsOrdered;
    }

    public Integer getUnitsOrderedB2B() {
        return unitsOrderedB2B;
    }

    public void setUnitsOrderedB2B(Integer unitsOrderedB2B) {
        this.unitsOrderedB2B = unitsOrderedB2B;
    }

    public Integer getTotalOrderItems() {
        return totalOrderItems;
    }

    public void setTotalOrderItems(Integer totalOrderItems) {
        this.totalOrderItems = totalOrderItems;
    }

    public Integer getTotalOrderItemsB2B() {
        return totalOrderItemsB2B;
    }

    public void setTotalOrderItemsB2B(Integer totalOrderItemsB2B) {
        this.totalOrderItemsB2B = totalOrderItemsB2B;
    }

    public Price getAverageSalesPerOrderItem() {
        return averageSalesPerOrderItem;
    }

    public void setAverageSalesPerOrderItem(Price averageSalesPerOrderItem) {
        this.averageSalesPerOrderItem = averageSalesPerOrderItem;
    }

    public Price getAverageSalesPerOrderItemB2B() {
        return averageSalesPerOrderItemB2B;
    }

    public void setAverageSalesPerOrderItemB2B(Price averageSalesPerOrderItemB2B) {
        this.averageSalesPerOrderItemB2B = averageSalesPerOrderItemB2B;
    }

    public Double getAverageUnitsPerOrderItem() {
        return averageUnitsPerOrderItem;
    }

    public void setAverageUnitsPerOrderItem(Double averageUnitsPerOrderItem) {
        this.averageUnitsPerOrderItem = averageUnitsPerOrderItem;
    }

    public Double getAverageUnitsPerOrderItemB2B() {
        return averageUnitsPerOrderItemB2B;
    }

    public void setAverageUnitsPerOrderItemB2B(Double averageUnitsPerOrderItemB2B) {
        this.averageUnitsPerOrderItemB2B = averageUnitsPerOrderItemB2B;
    }

    public Price getAverageSellingPrice() {
        return averageSellingPrice;
    }

    public void setAverageSellingPrice(Price averageSellingPrice) {
        this.averageSellingPrice = averageSellingPrice;
    }

    public Price getAverageSellingPriceB2B() {
        return averageSellingPriceB2B;
    }

    public void setAverageSellingPriceB2B(Price averageSellingPriceB2B) {
        this.averageSellingPriceB2B = averageSellingPriceB2B;
    }

    public Integer getUnitsRefunded() {
        return unitsRefunded;
    }

    public void setUnitsRefunded(Integer unitsRefunded) {
        this.unitsRefunded = unitsRefunded;
    }

    public Double getRefundRate() {
        return refundRate;
    }

    public void setRefundRate(Double refundRate) {
        this.refundRate = refundRate;
    }

    public Integer getClaimsGranted() {
        return claimsGranted;
    }

    public void setClaimsGranted(Integer claimsGranted) {
        this.claimsGranted = claimsGranted;
    }

    public Price getClaimsAmount() {
        return claimsAmount;
    }

    public void setClaimsAmount(Price claimsAmount) {
        this.claimsAmount = claimsAmount;
    }

    public Price getShippedProductSales() {
        return shippedProductSales;
    }

    public void setShippedProductSales(Price shippedProductSales) {
        this.shippedProductSales = shippedProductSales;
    }

    public Integer getUnitsShipped() {
        return unitsShipped;
    }

    public void setUnitsShipped(Integer unitsShipped) {
        this.unitsShipped = unitsShipped;
    }

    public Integer getOrdersShipped() {
        return ordersShipped;
    }

    public void setOrdersShipped(Integer ordersShipped) {
        this.ordersShipped = ordersShipped;
    }
}
