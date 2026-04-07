# Prueba Técnica - Developer (Spring Boot)

## Descripción
Este proyecto corresponde a la implementación de un servicio REST en Java usando Spring Boot, el cual permite registrar empleados y calcular información adicional como:

- Edad actual del empleado (años, meses y días)
- Tiempo de vinculación a la compañía (años y meses)


## Tecnologías utilizadas

- Java 17
- Spring Boot
- Spring Data JPA
- MySQL
- Lombok
- Maven


## Configuración del proyecto

## 1. Clonar repositorio

git clone https://github.com/jeiner21/pruebaTecnica
cd 


## 2. Configurar base de datos MySQL

Crear una base de datos:

CREATE DATABASE empleados_db;

Configurar el archivo `application.properties`:

 spring.datasource.url=jdbc:mysql://localhost:3306/empleados_db?createDatabaseIfNotExist=true 
 spring.datasource.username=TU-USUARIO
 spring.datasource.password=TU-PASWORD
  spring.datasource.driver-class-name=com.mysql.cj.jdbc.Driver
   spring.jpa.hibernate.ddl-auto=update
    spring.jpa.show-sql=true 
   spring.jpa.database-platform=org.hibernate.dialect.MySQLDialect

---

## 3. Ejecutar el proyecto

mvn spring-boot:run

El servicio estará disponible en:

http://localhost:8080

---

##  Endpoints

## Crear empleado

POST /empleados

#### Request JSON:

{
  "nombres": "Jeiner",
  "apellidos": "Perez",
  "tipoDocumento": "CC",
  "numeroDocumento": "12345678",
  "fechaNacimiento": "2000-05-10",
  "fechaVinculacion": "2020-03-15",
  "cargo": "Backend Developer",
  "salario": 1000
}

#### Response:

{
  "empleado": {
    "id": 1,
    "nombres": "Jeiner",
    "apellidos": "Perez"
  },
  "edad": "25 años, 10 meses, 2 días",
  "tiempoVinculacion": "5 años, 1 meses"
}


## Listar empleados

GET /empleados


## Obtener empleado por ID

GET /empleados/{id}


## Validaciones implementadas

- Campos obligatorios (Bean Validation)
- Validación de formato de fechas
- Validación de mayoría de edad (≥ 18 años)


## Lógica implementada

- Uso de LocalDate y Period para cálculo de:
  - Edad exacta del empleado
  - Tiempo de vinculación a la empresa
- Arquitectura en capas:
  - Model
  - Controller
  - Service
  - Repository

---

## Autor

Desarrollado por Jeiner Arenas Perez

---

## Notas adicionales
Pruebas con Postman para cualquier error.
El proyecto fue desarrollado siguiendo buenas prácticas como:
- Uso de DTO para respuestas
- Separación de responsabilidades
- Código limpio con Lombok