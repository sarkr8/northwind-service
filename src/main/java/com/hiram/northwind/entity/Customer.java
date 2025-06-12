package com.hiram.northwind.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "Customers")
@Getter
@Setter
public class Customer {

    @Id
    @Column(name = "CustomerID")
    private String id;
    @Column(name = "CompanyName")
    private String company_name;
    @Column(name = "ContactName")
    private String contact_name;
    @Column(name = "ContactTitle")
    private String contact_title;
    @Column(name = "Address")
    private String address;
    @Column(name = "City")
    private String city;
    @Column(name = "Region")
    private String region;
    @Column(name = "PostalCode")
    private String postal_code;
    @Column(name = "Country")
    private String country;
    @Column(name = "Phone")
    private String phone;
    @Column(name = "Fax")
    private String fax;
}
