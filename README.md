# **Pricing Service Project**
## Descripción

Este proyecto es una aplicación de Spring Boot que ofrece un servicio REST para consultar precios de productos de una base de datos H2 en memoria. La arquitectura utilizada es la arquitectura hexagonal, que separa las preocupaciones entre las diferentes capas del sistema, asegurando un diseño limpio y mantenible.

## Funcionalidad

El servicio REST proporciona un endpoint para consultar precios basados en una fecha de aplicación, un identificador de producto y un identificador de cadena. La respuesta incluye:

* Identificador del producto
* Identificador de la cadena
* Tarifa aplicada
* Fechas de aplicación
* Precio final

## Endpoints
**GET /price**

### **Parámetros de entrada:**

productId (int): Identificador del producto

brandId (Long): Identificador de la cadena

applicationDate (String en formato ISO): Fecha de consulta (ej. 2020-06-14T10:00:00)

### Ejemplo de uso:
**GET /price?productId=35455&brandId=1&applicationDate=2020-06-14T10:00:00**

**Respuesta:**

{
"productId": 35455,
"brandId": 1,
"priceList": 1,
"startDate": "2020-06-14T00:00:00",
"endDate": "2020-12-31T23:59:59",
"price": 35.50
}

## Configuración de la Base de Datos H2

#### La aplicación utiliza una base de datos H2 en memoria. La configuración se encuentra en application.properties:

spring.datasource.url=jdbc:h2:mem:testdb

spring.datasource.driverClassName=org.h2.Driver

spring.datasource.username=sa

spring.datasource.password=password

spring.jpa.database-platform=org.hibernate.dialect.H2Dialect

spring.h2.console.enabled=true

spring.jpa.hibernate.ddl-auto=create-drop

## Inicialización de Datos

El método initDatabase en la clase LoadDatabase carga los datos de ejemplo al iniciar la aplicación.

## Pruebas
El proyecto incluye pruebas de integración en PriceControllerTest para validar las solicitudes al endpoint REST. Se utilizan MockMvc y JUnit 5.

## Requisitos
* Java 17

* Maven

## Cómo Ejecutar

Clonar el repositorio.

Navegar al directorio del proyecto.

Ejecutar mvn spring-boot:run.

Acceder al endpoint en http://localhost:8080/price.

## Autor

#### Proyecto desarrollado por Emmanuel Jean-Pierre Auguste.