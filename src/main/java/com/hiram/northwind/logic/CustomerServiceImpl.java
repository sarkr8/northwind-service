package com.hiram.northwind.logic;

import com.hiram.northwind.dto.CustomerRequest;
import com.hiram.northwind.entity.Customer;
import com.hiram.northwind.repository.CustomerRepository;
import com.hiram.northwind.service.CustomerService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CustomerServiceImpl implements CustomerService {

    private final CustomerRepository repository;

    public CustomerServiceImpl(CustomerRepository repository) {
        this.repository = repository;
    }

    @Override
    public List<Customer> getAll() {
        return repository.findAll();
    }

    @Override
    public Customer getById(String id) {
        return repository.findById(id).orElse(null);
    }

    @Override
    public Customer create(CustomerRequest request) {
        Customer c = new Customer();
        c.setId(request.getId());
        c.setCompany_name(request.getCompany_name());
        c.setContact_name(request.getContact_name());
        c.setContact_title(request.getContact_title());
        c.setAddress(request.getAddress());
        c.setCity(request.getCity());
        c.setRegion(request.getRegion());
        c.setPostal_code(request.getPostal_code());
        c.setCountry(request.getCountry());
        c.setPhone(request.getPhone());
        c.setFax(request.getFax());
        return repository.save(c);
    }

    @Override
    public void delete(String id) {
        repository.deleteById(id);
    }
}
