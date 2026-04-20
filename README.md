Aquí tienes una versión del README con un tono técnico, directo y profesional, adaptada a tus requerimientos específicos y sin elementos decorativos.

---

# Northwind Microservice - Proyecto de Aprendizaje

Este microservicio ha sido desarrollado utilizando Java 17 y Spring Boot 3.5 con el objetivo de profundizar en el desarrollo de APIs REST, la gestión de persistencia con JPA y la implementación de seguridad básica.

## Requisitos de Instalación

Para compilar y ejecutar este proyecto es necesario contar con el siguiente software:

* **Java Development Kit (JDK) 17**: Entorno de ejecución y compilación.
* **Apache Maven 3.8+**: Gestión de dependencias y construcción del proyecto.
* **SQLite Browser o DBeaver**: Opcional, para la inspección manual de los datos.

## Configuración de la Base de Datos

El proyecto utiliza la base de datos Northwind en formato SQLite. Para facilitar la portabilidad y agilizar el entorno de desarrollo, el archivo de la base de datos se encuentra incluido dentro del repositorio.

* **Ruta del archivo:** `src/main/resources/db/sqlite_northwind.db`
* **Estrategia de Naming:** Se ha configurado explícitamente el uso de **snake_case** para los nombres de los campos y tablas. Esta decisión técnica se tomó para garantizar una compatibilidad directa y sin fricciones con la estructura original de la base de datos Northwind en SQLite, evitando así errores de mapeo o transformaciones innecesarias durante las consultas SQL.

## Seguridad

El acceso a los endpoints está protegido mediante Spring Security. Se requiere autenticación básica (Basic Auth) para todas las peticiones:

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

El desarrollo emplea una arquitectura por capas:

* **Controladores:** Gestión de peticiones HTTP y exposición de recursos.
* **Servicios:** Implementación de la lógica de negocio.
* **Validación:** Uso de `jakarta.validation` en los DTOs de entrada para asegurar la integridad de los datos recibidos.
* **Persistencia:** Spring Data JPA con un dialecto personalizado para soporte óptimo de SQLite.

## Instrucciones de Ejecución

1.  **Construir el proyecto:**
    `mvn clean install`

2.  **Iniciar el servicio:**
    `mvn spring-boot:run`

La API estará disponible en `http://localhost:8080`.

---

**Autor:** Hiram Martínez
**Nota:** Este repositorio es de carácter educativo y de práctica personal.
