package com.hiram.northwind.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CustomerRequest {

    @NotBlank(message = "El ID no puede estar vacío")
    @Size(max = 5, message = "El ID debe tener máximo 5 caracteres")
    private String id;
    @NotBlank(message = "El nombre de la empresa no puede estar vacío")
    private String company_name;
    @Size(max = 30, message = "El nombre del contacto no debe exceder 30 caracteres")
    private String contact_name;
    @Size(max = 30)
    private String contact_title;
    @Size(max = 60)
    private String address;
    @Size(max = 15)
    private String city;
    @Size(max = 15)
    private String region;
    @Size(max = 10)
    private String postal_code;
    @Size(max = 15)
    private String country;
    @Size(max = 24)
    private String phone;
    @Size(max = 24)
    private String fax;
}
