# Proyecto Integrador: Programación 2

Este proyecto es una app en Java que gestiona usuarios y credenciales, conectándose a una base de datos MySQL usando un pool de conexiones (HikariCP).

LINK al video: https://drive.google.com/file/d/1_yW2VsYcUVSlKspJ7lh2pKX2m4kyf6zg/view?usp=sharing

---

## Cómo Levantar el Entorno (Setup)

Sigue estos pasos para poder ejecutar el proyecto en tu máquina local.

### 1. Prerrequisitos y Librerías

Asegúrate de tener instalado:
* Java JDK 17 (o la versión que estén usando)
* MySQL Server 8.0 (o el que usen)
* Un IDE (NetBeans, IntelliJ, Eclipse, etc.)

Además, debes agregar las siguientes librerías `.jar` al **Build Path** de tu proyecto:

1.  **MySQL Connector/J:** El driver oficial de MySQL.
2.  **HikariCP:** El pool de conexiones (ej. `HikariCP-5.1.0.jar`).
3.  **SLF4J API:** Requerido por Hikari (ej. `slf4j-api-2.0.7.jar`).
4.  **jbcrypt:** Para el hashing de contraseñas (ej. `jbcrypt-0.4.jar`).

### 2. Base de Datos

**IMPORTANTE:** El esquema de la base de datos se encuentra en el archivo `/sql/schema.sql`.

1.  Inicia tu servidor MySQL.
2.  Crea la base de datos: `CREATE DATABASE gestion_usuarios_2;`
3.  Selecciona la base de datos: `USE gestion_usuarios_2;`
4.  Ejecuta el script `/sql/schema.sql` para crear las tablas (`usuario`, `credencial_acceso`) con todas sus restricciones.

### 3. Configuración de Credenciales (¡El paso clave!)

Este proyecto **NO** guarda las contraseñas en el código por seguridad. Para que la app funcione, debes crear tu propio archivo de configuración:

1.  Abre el proyecto con tu IDE.
2.  En NetBeans, haz clic derecho sobre **`Source Packages`** > **`New`** > **`Other...`**.
3.  Selecciona **`Other`** > **`Properties File`**.
4.  Nombra el archivo **`db`** y haz clic en "Finish".
5.  Pega el siguiente contenido en el `db.properties` que acabas de crear, **reemplazando con tus datos locales**:

```properties
# Credenciales de la Base de Datos Local
db.url=jdbc:mysql://localhost:3306/gestion_usuarios_2
db.user=root
db.password=TU_CONTRASENIA_LOCAL