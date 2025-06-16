package com.hiram.northwind.logic;

import com.hiram.northwind.dto.CustomerRequest;
import com.hiram.northwind.entity.Customer;
import com.hiram.northwind.exception.CustomerNotFoundException;
import com.hiram.northwind.repository.CustomerRepository;
import com.hiram.northwind.service.CustomerService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CustomerServiceImpl implements CustomerService {

    private static final Logger log = LoggerFactory.getLogger(CustomerServiceImpl.class);

    private final CustomerRepository repository;

    public CustomerServiceImpl(CustomerRepository repository) {
        this.repository = repository;
    }

    @Override
    public List<Customer> getAll() {
        log.info("Obteniendo todos los clientes");
        return repository.findAll();
    }

    @Override
    public Customer getById(String id) {
        log.info("Buscando cliente con ID: {}", id);
        return repository.findById(id)
                .orElseThrow(() -> new CustomerNotFoundException(id));
    }

    @Override
    public Customer createCustomer(CustomerRequest request) {
        log.info("Creando cliente con ID: {}", request.getId());
        return repository.save(mapRequestToCustomer(request));
    }

    @Override
    public Customer updateCustomer(String id, CustomerRequest request) {
        log.info("Actualizando cliente con ID: {}", id);
        Customer existing = repository.findById(id)
                .orElseThrow(() -> new CustomerNotFoundException(id));

        existing.setCompany_name(request.getCompany_name());
        existing.setContact_name(request.getContact_name());
        existing.setContact_title(request.getContact_title());
        existing.setAddress(request.getAddress());
        existing.setCity(request.getCity());
        existing.setRegion(request.getRegion());
        existing.setPostal_code(request.getPostal_code());
        existing.setCountry(request.getCountry());
        existing.setPhone(request.getPhone());
        existing.setFax(request.getFax());

        return repository.save(existing);
    }

    @Override
    public void delete(String id) {
        log.info("Eliminando cliente con ID: {}", id);
        repository.deleteById(id);
    }

    private Customer mapRequestToCustomer(CustomerRequest request) {
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
        return c;
    }
}
