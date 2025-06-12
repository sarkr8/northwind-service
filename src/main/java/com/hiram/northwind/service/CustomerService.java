package com.hiram.northwind.service;

import com.hiram.northwind.dto.CustomerRequest;
import com.hiram.northwind.entity.Customer;

import java.util.List;

public interface CustomerService {
    List<Customer> getAll();
    Customer getById(String id);
    Customer create(CustomerRequest request);
    void delete(String id);
}
