# Laboratorio 3: Gestión de Playlists 🎵

Este proyecto es una aplicación de gestión musical que permite crear, editar y visualizar canciones y playlists. Fue desarrollado como parte del curso **Bases de Datos I (CC3088)** en la **Universidad del Valle de Guatemala**.

## 📌 Descripción

La aplicación permite:

- Crear, ver, editar y eliminar **canciones**
- Crear, ver, editar y eliminar **playlists**
- Crear, ver, editar y eliminar **albumes**
- Crear, ver, editar y eliminar **cantantes**

- Asociar múltiples canciones a una playlist usando un formulario con selección múltiple
- Visualizar playlists con sus canciones a través de una **vista SQL (`vista_playlist_completa`)** ubicada en src/main/java/com/uvg/resources/schema.sql

---

## 🛠️ Tecnologías usadas

- Java 21+
- Spring Boot
- Spring Data JPA (Hibernate ORM)
- PostgreSQL
- Thymeleaf
- Maven

---

## ⚙️ Configuración del proyecto

### 1. Clona el repositorio

```bash
git clone https://github.com/tu-usuario/proyecto-lab3.git
cd proyecto-lab3
```

### 2. Configura application.properties

En src/main/resources/application.properties, reemplaza con tus credenciales de PostgreSQL:

```
spring.application.name=Laboratorio 3

spring.datasource.url=jdbc:postgresql://localhost:5432/[TU BASE DE DATOS]
spring.datasource.username=[USERNAME]
spring.datasource.password=[PASSWORD]

spring.jpa.hibernate.ddl-auto=update
spring.jpa.show-sql=true
spring.jpa.properties.hibernate.format_sql=true
```

### 3. Importa y ejecuta desde tu IDE (IntelliJ, Eclipse, etc.)
Este proyecto está diseñado para ejecutarse desde un IDE, no desde consola.

### 🗃️ Base de datos

Se usa PostgreSQL como base de datos.

La estructura se define automáticamente desde las clases @Entity gracias a spring.jpa.hibernate.ddl-auto=update

También se incluye un schema.sql personalizado que puede utilizarse para inicializar manualmente la base de datos con tipos personalizados (estado_animo, formato_audio) y relaciones.

Vista utilizada
El proyecto incluye una vista llamada vista_playlist_completa que une playlists con sus canciones, álbumes, géneros y cantantes para facilitar el despliegue.

### 📥 Inserción de datos
Los datos iniciales fueron insertados manualmente usando data.sql y el psql. Se incluyen relaciones múltiples (una playlist puede tener varias canciones y viceversa).

### 🔄 Funcionalidades
CRUD completo con relaciones (playlist_cancion)

Selección múltiple de canciones desde formulario form.html

Vista HTML (Thymeleaf)

Endpoints web (controladores MVC)


### 📘 Créditos
Este proyecto fue desarrollado como parte del curso:

Bases de Datos I (CC3088)
Universidad del Valle de Guatemala
Ciclo 1, 2025

Por:
- Leonardo Dufrey Mejía Mejía, 23648
- María José Girón Isidro, 23559

### ⚖️ Licencia
Uso académico. No se distribuye con una licencia específica.