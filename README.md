<h1 align= "center">🛠️ Plataforma de Renta de Herramientas y Equipos de Construcción</h1>

Realización del proyecto final con Campuslands; desarrollado con Spring Boot para facilitar el alquiler eficiente de herramientas y maquinaria de construcción por parte de contratistas, empresas y usuarios particulares...


## 📌Descripción

La Plataforma de Renta de Herramientas y Equipos de Construcción es una aplicación web desarrollada con Spring Boot y PostgreSQL que automatiza el proceso de alquiler de herramientas entre clientes, proveedores y el administrador. El objetivo es modernizar la gestión de inventario, reservas, pagos y devoluciones, eliminando procesos manuales y mejorando la eficiencia operativa.

El sistema permite a los proveedores registrar herramientas con disponibilidad y precios, mientras que los clientes pueden explorar el catálogo, realizar reservas, efectuar pagos en línea y recibir notificaciones. Por otra parte, el administrador supervisa toda la operación, gestiona usuarios, genera reportes y monitorea la facturación.

Este proyecto lo divididimos en un backend robusto en Spring Boot, con una autenticación segura mediante JWT, y un frontend responsivo basado en HTML, CSS y JavaScript, adaptable para dispositivos móviles y de escritorio. Además, incluye documentación detallada con Swagger, scripts SQL, y pruebas automatizadas para garantizar su calidad.

## 🚀 Tecnologías Utilizadas

### 🔧 Backend

<img src="https://img.shields.io/badge/Spring_Security-6DB33F?style=for-the-badge&logo=Spring-Security&logoColor=white">

<img src="https://img.shields.io/badge/PostgreSQL-316192?style=for-the-badge&logo=postgresql&logoColor=white">

<img src="https://img.shields.io/badge/Postman-FF6C37?style=for-the-badge&logo=Postman&logoColor=white">

<img src="https://img.shields.io/badge/GitHub-100000?style=for-the-badge&logo=github&logoColor=white">

<img src="https://img.shields.io/badge/JWT-000000?style=for-the-badge&logo=JSON%20web%20tokens&logoColor=white">

<img src="https://img.shields.io/badge/GIT-E44C30?style=for-the-badge&logo=git&logoColor=white">

<img src="https://img.shields.io/badge/Java-323330?style=for-the-badge&logo=java&logoColor=F7DF1E">

### 💻 Frontend

<img src="https://img.shields.io/badge/JavaScript-323330?style=for-the-badge&logo=javascript&logoColor=F7DF1E">

<img src="https://img.shields.io/badge/HTML5-E34F26?style=for-the-badge&logo=html5&logoColor=white">

<img src="https://img.shields.io/badge/CSS3-1572B6?style=for-the-badge&logo=css3&logoColor=white">

## 🧩 Estructura del Proyecto

## 🔐 Seguridad

Para la seguridad del proyecto implementamos la autenticación con JWT definiendo los roles ya predefinidos(ADMIN, SUPPLIER, CUSTOMER); tambien manejamos la protección de las rutas vulnerables según los permisos dados por los tokens.

## 🗃️ Base de Datos - PostgreSQL

Creamos la estructura ER, el diagrama relacional y el UML en el cual mostramos de manera clara todas las relaciones existentes entre las tablas y entidades.

Los Scripts SQL son:

- [db.sql]: Para la creación de las tablas.

- [insert.sql]: Para los datos de prueba.

## ✅ Entidades

1. Damage Report
2. Invoices
3. Notifications
4. Payments
5. Persons
6. Reservations
7. ReturnsDeliveries
8. Stastics
9. ToolsEquipmentConstruction
10. ToolsInvoices
11. Users

## 📷 Diagrama de base de datos relacional

![alt text](<Relational Database Schema Diagram.png>)

## 📷 Diagrama UML

![alt text](UML.png)

## 👥 Perfiles de Usuario y Funcionalidades

### 1️⃣ Admin

El rol de Admin tiene 4 partes claves a cumplir en nuestro proyecto:

1. Gestión de usuarios (clientes/proveedores)
2. Validación de devoluciones y daños
3. Monitoreo de pagos y reportes
4. Estadísticas

### 2️⃣ Suppliers

El rol de Suppliers tiene 4 partes claves a cumplir en nuestro proyecto:

1. Gestión de herramientas
2. Confirmación de reservas y devoluciones
3. Generación de facturas automáticas al aceptar una reserva
4. Notificaciones en tiempo real

### 3️⃣ Customer

El rol de Customer tiene 5 partes claves a cumplir en nuestro proyecto:

1. Registro e inicio de sesión con JWT
2. Exploración de herramientas
3. Realización de reservas
4. Pagos en línea y descarga de facturas
5. Notificaciones sobre vencimientos

## 📂 Configuración del Proyecto

Para la configuración del proyecto usamos el archivo [application.properties] en la carpeta [resources].

spring.application.name=toolshare

spring.datasource.url=jdbc:postgresql://127.0.0.1:5432/ToolsShare
spring.datasource.username=postgres
spring.datasource.password=(ingresar la contraseña de su postgrest.)

spring.jpa.show-sql=true
spring.jpa.hibernate.ddl-auto=update
spring.jpa.properties.hibernate.dialect=org.hibernate.dialect.PostgreSQLDialect

## 🧾 Características

El proyecto ha sido organizado utilizando la arquitectura Modelo-Vista-Controlador (MVC), lo que permite una separación clara de responsabilidades entre el backend y el frontend, distribuidos en carpetas y archivos específicos:

La carpeta [Application]: Esta carpeta contiene la estructura principal de la lógica de negocio de la aplicación.
- La carpeta[Service]: Esta carpeta incluye en los archivos todas las interfaces Service correspondientes a las distintas entidades del sistema, estas definen los métodos que encapsulan la lógica de la plataforma de renta y que serán implementados posteriormente en las clases ServiceImpl.

La carpeta [Config]: Esta carpeta contiene dos archivos [.java] que gestionan la configuración de seguridad del sistema. En ellos se define el control de acceso según los distintos roles (Admin, Supplier y Customer) y se implementa la generación y validación de tokens para autenticar y autorizar el acceso a los recursos protegidos.

La carpeta [Domain]: Esta carpeta nos permite almacenar en los archivos todos los atributos de las entidades de la BBDD, en ella también tenemos 4 carpetas más:

- La carpeta [Dto]: Esta carpeta nos permite encapsular y simplificar en archivos los datos de una entidad. Tambien nos ayuda a manejar de manera más ligera y rápida los atributos extrictamente necesarios para la función y ejecución del código.
- La carpeta [Enum]: Esta carpeta nos permite organizar en archivos los enums utilizados en las entidades de nuestro proyecto en una sola parte. Esto nos ayuda en la mejora de la estructura del código, nos es útil para representar los estados, roles, categorías, etc, de una manera más clara y segura.
- La carpeta [Request]: Esta carpeta nos permite organizar en los archivos todas las clases que definen la estructura de los datos entrantes, separándolos de las entidades del sistema y de otros tipos de DTOs.
- La carpeta [Response]: Esta carpeta nos almacena los archivos que nos permitiran modelar la respuesta que enviamos de la API al frontend, separando las estructuras de las entidades del sistema y de las clases request.

La carpeta [Infraestructure]: Nos guarda dos carpetas esenciales del código:

- La carpeta [Controller]: Esta carpeta nos permite, mediante los archivos poder manejar las solicitudes (HTTP) entrantes desde los roles (Admin, Supplier y Customer).
- La carpeta [Repository]: Esta carpeta es la encargada de guardar las interfaces responsables de la persistencia de datos(consultas, inserciones, actualizaciones y borrados), la que se comunica directamente con la base de datos. Dentro de esta carpeta se incluye también:
    - La carpeta [RepositoryImpl]: Esta subcarpeta contiene los archivos con las implementaciones personalizadas de los repositorios. Las clases en esta carpeta implementan interfaces personalizadas y utilizan @Service para interactuar directamente con la base de datos.

La carpeta [JWT]: Esta carpeta nos permite crear el filtro de autenticación de la seguridad.

## 📝 Documentación Swagger

Incluye:

- Todos los endpoints
- Ejemplos de solicitudes/respuestas JSON
- Requerimientos de autenticación con JWT

## ⚙️ Instrucciones de Ejecución del proyecto

### 1. Clonar el repositorio

https://github.com/MariaGLi/FerreteriaLosM_LizarazoMaria_LassoValerie_CaicedoLuis.git

### 2. Importar el proyecto como Maven en tu IDE preferido

### 3. Configurar PostgreSQL y ejecutar los scripts SQL ubicados en /sql

### 4. Configurar el archivo application.properties

### 5. Ejecutar la aplicación desde tu IDE o con el siguiente comando:
./mvnw spring-boot:run


## ✌️  Desarrollado por:
Proyecto realizado por María Guadalupe Lizarazo Leal, Valerie Michell Lasso y Luis Miguel Caicedo Bermón, estudiantes de Campus-Lands como filtro previo a la evaluación final del módulo.

## 📬 Contacto de los desarrolladores:

* mlizarazoleal@gmail.com
* valerie01liz01@gmail.com
* luismiguel110205@gmail.com