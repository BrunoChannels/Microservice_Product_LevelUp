# LevelUp Gaming - Microservicio de Productos (Product Microservice)

Este microservicio es el **backend de gestión de productos** para la tienda en línea LevelUp Gaming. Desarrollado con **Spring Boot**, proporciona una API RESTful robusta para realizar todas las operaciones CRUD (Crear, Leer, Actualizar, Eliminar) sobre el catálogo de juegos, consolas y accesorios.

---

## Características Destacadas

* **API RESTful:** Endpoints bien definidos para la gestión de la entidad `Product`.
* **Gestión de Inventario:** Control directo sobre el stock de cada producto.
* **Persistencia:** Utiliza **Spring Data JPA** para una gestión eficiente de la base de datos.
* **Data Seeding:** Incluye un `DataSeeder` para inicializar automáticamente el catálogo con productos de muestra al primer inicio.
* **Documentación Interactiva:** Integración con **Swagger/OpenAPI** para documentar y probar los endpoints.
* **CORS Configurado:** Permite peticiones desde el frontend en `http://localhost:5173`.

---

## Tecnologías y Dependencias

| Tecnología | Descripción |
| :--- | :--- |
| **Java** | Java 24. |
| **Spring Boot** | Framework principal para el desarrollo de microservicios. |
| **Spring Data JPA** | Abstracción para la persistencia de datos. |
| **Lombok** | Librería para reducir código repetitivo (getters, setters, constructores). |
| **Swagger/OpenAPI** | Para la documentación de la API. |
| **Base de Datos** | Configurarse mediante `application.properties/yml`. |

---

## Estructura del Proyecto

El proyecto sigue la arquitectura de capas típica de Spring Boot:

* **`model/Product.java`**: La entidad de la base de datos (`@Entity`), que define los atributos del producto: `id`, `name`, `price`, `stock`, `category`, etc.
* **`repository/ProductRepository.java`**: Interfaz que extiende `JpaRepository` para el acceso directo a la base de datos.
* **`service/ProductService.java`**: Contiene la lógica de negocio (`@Transactional`) y los métodos CRUD básicos.
* **`controller/ProductController.java`**: La capa REST, maneja las peticiones HTTP en la ruta `/api/v1/products`.
* **`config/Dataseeder.java`**: Ejecuta una `CommandLineRunner` para precargar la base de datos con un catálogo inicial si está vacía.

---

## Endpoints de la API REST

La ruta base para todos los endpoints es: `/api/v1/products`.

| Método | Endpoint | Operación | Cuerpo de Petición (Request Body) | Códigos de Respuesta |
| :--- | :--- | :--- | :--- | :--- |
| **GET** | `/` | Listar todos los productos. | *Ninguno* | `200`, `204` |
| **POST** | `/` | Crear un nuevo producto. | Objeto `Product` (JSON) | `201`, `400` |
| **GET** | `/{id}` | Obtener un producto por ID. | *Ninguno* | `200`, `404` |
| **PUT**
