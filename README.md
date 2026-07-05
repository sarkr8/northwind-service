# Northwind Microservice 

Este microservicio de alto rendimiento está diseñado para la gestión centralizada de clientes basados en el modelo de datos Northwind. Construido bajo una arquitectura empresarial en capas utilizando **Java 17** y **Spring Boot 3.5**, el sistema implementa principios de diseño RESTful, validación estricta de datos y persistencia optimizada para entornos portables.

## Requisitos de Instalación

Para compilar y ejecutar este proyecto es necesario contar con el siguiente software:

* **Java Development Kit (JDK) 17**: Entorno de ejecución y compilación.
* **Apache Maven 3.8+**: Gestión de dependencias y construcción del proyecto.
* **SQLite Browser o DBeaver**: Opcional, para la inspección manual de los datos.

## Configuración de la Base de Datos

El proyecto utiliza la base de datos Northwind en formato SQLite. Para facilitar la portabilidad y agilizar el entorno de desarrollo, el archivo de la base de datos se encuentra incluido dentro del repositorio.

* **Ruta del archivo:** `src/main/resources/db/sqlite_northwind.db`
* **Estrategia de Naming:** Se ha configurado explícitamente el uso de **snake_case** para los nombres de los campos y tablas. Esta decisión técnica se tomó para garantizar una compatibilidad directa y sin fricciones con la estructura original de la base de datos Northwind en SQLite, evitando así errores de mapeo o transformaciones innecesarias durante las consultas SQL.

## Seguridad y Control de Acceso

El acceso a la capa de servicios se encuentra restringido mediante **Spring Security**. El microservicio implementa un esquema de autenticación desacoplado para entornos de desarrollo y pruebas:

* **Mecanismo:** HTTP Basic Authentication
* **Usuario:** admin
* **Contraseña:** admin

## API Endpoints: Customers

La gestión de clientes se centraliza en el recurso `/api/customers`.

| Método | Endpoint | Acción | Código HTTP |
| :--- | :--- | :--- | :--- |
| GET | `/api/customers` | Obtener todos los clientes | 200 OK |
| GET | `/api/customers/{id}` | Obtener un cliente por su ID | 200 OK / 404 |
| POST | `/api/customers` | Crear un nuevo cliente | 201 Created |
| PUT | `/api/customers/{id}` | Actualizar un cliente existente | 200 OK |
| DELETE | `/api/customers/{id}` | Eliminar un cliente | 204 No Content |

## Estructura y Tecnologías

El desarrollo emplea una arquitectura por capas enfocada en la mantenibilidad y el aislamiento del dominio:

* **Controladores:** Gestión de peticiones HTTP, mapeo de rutas y exposición semántica de recursos REST.
* **Servicios:** Implementación desacoplada de la lógica de negocio central.
* **Validación:** Uso estricto de `jakarta.validation` en los Data Transfer Objects (DTOs) de entrada para asegurar la integridad de los datos.
* **Persistencia:** Spring Data JPA acoplado a un dialecto personalizado para un soporte y rendimiento óptimo sobre SQLite.

## Instrucciones de Ejecución

1.  **Construir el proyecto:**
    `mvn clean install`

2.  **Iniciar el servicio:**
    `mvn spring-boot:run`

La API estará disponible en `http://localhost:8080`.

---

**Autor:** Hiram Martínez
