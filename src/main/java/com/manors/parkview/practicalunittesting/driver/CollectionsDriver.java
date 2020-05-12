package com.manors.parkview.practicalunittesting.driver;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

import com.manors.parkview.practicalunittesting.model.Address;
import com.manors.parkview.practicalunittesting.model.Customer;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class CollectionsDriver {
    private static final Logger log = LoggerFactory.getLogger(CollectionsDriver.class);

    public static final void main(String[] args) {
        List<Customer> customers = Arrays.asList(new Customer("Disney", new Address("500 International Drive"), 50000),
                new Customer("Apple", new Address("2 Boulevard Ln"), 100000),
                new Customer("Amazon", new Address("1000 Amazon Pkwy"), 500000),
                new Customer("Disney", new Address("1 Disney Park"), 600000)
        );

        // Groupby is always a map
        Map<String, List<Customer>> mapOfCustomerGrouped = customers
                .stream()
            .collect(Collectors.groupingBy(Customer::getName));
        
        log.info("Map of Grouped Customers: " + mapOfCustomerGrouped);


        List<String> customerNames = customers.stream()
            .map(Customer::getName)
            .collect(Collectors.toList());

        log.info("List of customer names: " + customerNames);

        Map<String, Customer> mapOfCustomers = customers.stream()
            .collect(Collectors.toMap(Customer::getName, Function.identity(), (oldValue, newValue) -> newValue));

        log.info("Map of customers: " + mapOfCustomers);

    }
    
}