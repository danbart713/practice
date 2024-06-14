package com.dvb.practice.sortingcomparator;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Comparator;
import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Order implements Comparator<Order> {

    private String orderNumber;
    private double orderValue;
    private Date orderCreatedDate;

    @Override
    public int compare(Order order, Order t1) {
        if (order.getOrderValue() < t1.getOrderValue()) {
            return 1;
        } else if (order.getOrderValue() > t1.getOrderValue()) {
            return -1;
        } else {
            if (order.getOrderCreatedDate().before(t1.getOrderCreatedDate())) {
                return 1;
            } else if (order.getOrderCreatedDate().after(t1.getOrderCreatedDate())) {
                return -1;
            } else {
                return 0;
            }
        }
    }
}
