package com.hiram.northwind.repository;

import com.hiram.northwind.entity.Customer;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CustomerRepository extends JpaRepository<Customer, String> {
    // Puedes agregar métodos personalizados si quieres buscar por ciudad o país
}
