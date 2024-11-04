package org.mykhailotiutiun.agencyamazon.report.asin;

import org.mykhailotiutiun.agencyamazon.report.Price;

import java.io.Serializable;

public class AsinSales implements Serializable {

    private Price orderedProductSales;

    private Price orderedProductSalesB2B;

    private Integer unitsOrdered;

    private Integer unitsOrderedB2B;

    private Integer totalOrderItems;

    private Integer totalOrderItemsB2B;


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

}
