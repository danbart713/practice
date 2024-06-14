package com.dvb.practice.sortingcomparator;

import java.util.*;

public class Coding {

    public static void main(String[] args) {
        Map<String, List<Order>> orderMap = new HashMap<>();

        List<Order> orderList = new ArrayList<>();

        Order order = new Order("67894", 100D, new Date(2024, 2, 28));
        orderList.add(order);
        order = new Order("26481", 90D, new Date(2024, 1, 28));
        orderList.add(order);
        order = new Order("12345", 100D, new Date(2024, 3, 28));
        orderList.add(order);
        order = new Order("75846", 80D, new Date(2024, 1, 20));
        orderList.add(order);

        orderMap.put("12345", orderList);

        orderMap.entrySet()
                .stream()
                .forEach(entry -> {
                    Collections.sort(entry.getValue(), new Order());
                    Order order1 = entry.getValue().stream()
                            .findFirst().get();
                    entry.setValue(Collections.singletonList(order1));
                });

        System.out.println(orderMap);

    }

}

