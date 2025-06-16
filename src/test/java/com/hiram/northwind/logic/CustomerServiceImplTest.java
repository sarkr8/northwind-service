package com.hiram.northwind.logic;

import com.hiram.northwind.dto.CustomerRequest;
import com.hiram.northwind.entity.Customer;
import com.hiram.northwind.repository.CustomerRepository;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.Arrays;
import java.util.List;

import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;

public class CustomerServiceImplTest {

    @Mock
    private CustomerRepository repository;

    @InjectMocks
    private CustomerServiceImpl service;

    public CustomerServiceImplTest() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    public void testGetAll() {
        Customer c1 = new Customer();
        c1.setId("ALFKI");
        c1.setCompany_name("Alfreds");

        when(repository.findAll()).thenReturn(Arrays.asList(c1));

        List<Customer> result = service.getAll();

        assertEquals(1, result.size());
        assertEquals("ALFKI", result.get(0).getId());
    }

    @Test
    public void testCreateCustomer() {
        CustomerRequest request = new CustomerRequest();
        request.setId("BLAUS");
        request.setCompany_name("Blauer See");

        Customer saved = new Customer();
        saved.setId("BLAUS");
        saved.setCompany_name("Blauer See");

        when(repository.save(any())).thenReturn(saved);

        Customer result = service.createCustomer(request);

        assertNotNull(result);
        assertEquals("BLAUS", result.getId());
        verify(repository).save(any());
    }

    @Test
    public void testGetById() {
        Customer c1 = new Customer();
        c1.setId("ALFKI");
        c1.setCompany_name("Alfreds");

        when(repository.findById("ALFKI")).thenReturn(java.util.Optional.of(c1));

        Customer result = service.getById("ALFKI");

        assertNotNull(result);
        assertEquals("ALFKI", result.getId());
    }

    @Test
    public void testDelete() {
        doNothing().when(repository).deleteById("ALFKI");

        service.delete("ALFKI");

        verify(repository, times(1)).deleteById("ALFKI");
    }
}
