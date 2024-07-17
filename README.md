# ForoHub
API REST para la gestión de tópicos de un foro.

## Índice

1. [Descripción](#descripción)
2. [Características](#características)
3. [Requisitos](#requisitos)
4. [Instalación](#instalación)
5. [Configuración](#configuración)


## Descripción

ForoHub es una API REST desarrollada con Spring Boot que permite gestionar tópicos en un foro. Incluye autenticación JWT, validación de datos, y migraciones de base de datos con Flyway.

## Características

- Creación, lectura, actualización y eliminación de tópicos.
- Autenticación y autorización con JWT.
- Migraciones de base de datos con Flyway.
- Uso de JPA para la persistencia de datos.
- Validación de datos de entrada.

## Requisitos

- Java 22
- Maven 3.6.3 o superior
- MySQL 8.0 o superior

## Instalación

1. Clonar el repositorio:
    ```sh
    git clone https://github.com/tu-usuario/forohub.git
    cd forohub
    ```

2. Compilar el proyecto:
    ```sh
    mvn clean install
    ```

## Configuración

1. Crear una base de datos MySQL:
    ```sql
    CREATE DATABASE forohub;
    ```

2. Configurar la conexión a la base de datos en `src/main/resources/application.properties`:
    ```properties
    spring.datasource.url=jdbc:mysql://localhost:3306/forohub
    spring.datasource.username=tu_usuario
    spring.datasource.password=tu_contraseña
    spring.jpa.hibernate.ddl-auto=validate
