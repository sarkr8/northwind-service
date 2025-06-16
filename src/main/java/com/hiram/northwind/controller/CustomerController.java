package com.hiram.northwind.controller;

import com.hiram.northwind.dto.CustomerRequest;
import com.hiram.northwind.entity.Customer;
import com.hiram.northwind.service.CustomerService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController  // Indica que esta clase expone una API REST
@RequestMapping("/api/customers")  // Ruta base para todos los endpoints de esta clase
public class CustomerController {

    private final CustomerService service;

    // Constructor que inyecta el servicio de Customer
    public CustomerController(CustomerService service) {
        this.service = service;
    }

    // GET /api/customers
    @GetMapping
    public ResponseEntity<List<Customer>> getAll() {
        List<Customer> customers = service.getAll();
        return ResponseEntity.ok(customers);  // Devuelve 200 OK con la lista
    }

    // GET /api/customers/{id}
    @GetMapping("/{id}")
    public ResponseEntity<Customer> getById(@PathVariable String id) {
        Customer customer = service.getById(id);
        if (customer != null) {
            return ResponseEntity.ok(customer);  // 200 OK con el customer
        } else {
            return ResponseEntity.notFound().build();  // 404 si no existe
        }
    }

    // POST /api/customers
    @PostMapping
    public ResponseEntity<Customer> create(@RequestBody @Valid CustomerRequest request) {
        Customer created = service.createCustomer(request);
        return new ResponseEntity<>(created, HttpStatus.CREATED);  // 201 Created con el nuevo customer
    }

    // DELETE /api/customers/{id}
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable String id) {
        service.delete(id);
        return ResponseEntity.noContent().build();  // 204 No Content al eliminar exitosamente
    }

    @PutMapping("/{id}")
    public ResponseEntity<Customer> updateCustomer(
            @PathVariable String id,
            @Valid @RequestBody CustomerRequest request) {

        Customer updated = service.updateCustomer(id, request);
        return ResponseEntity.ok(updated);
    }
}
