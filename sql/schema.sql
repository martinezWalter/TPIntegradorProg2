-- TABLA: credencial_acceso
-- Almacena la información de autenticación de cada usuario. La relación con usuario es 1 a 1 mediante user_id UNIQUE
DROP TABLE IF EXISTS `credencial_acceso`;

CREATE TABLE `credencial_acceso` (

  -- Identificador único de la credencial
  `id` int NOT NULL AUTO_INCREMENT,

  -- Contraseña almacenada como hash BCrypt
  `hash_password` varchar(255) NOT NULL,

  -- Salt utilizado para generar el hash
  `salt` varchar(64) DEFAULT NULL,

  -- Fecha y hora del último cambio de contraseña
  `last_change` datetime DEFAULT CURRENT_TIMESTAMP,

  -- Indica si el usuario debe cambiar la contraseña
  `require_reset` tinyint(1) DEFAULT '0',

  -- Referencia al usuario propietario de la credencial
  `user_id` int DEFAULT NULL,

  -- Clave primaria
  PRIMARY KEY (`id`),

  -- Evita almacenar hashes duplicados
  UNIQUE KEY `hash_password` (`hash_password`),

  -- Garantiza la relación 1 a 1: un usuario solo puede tener una credencial
  UNIQUE KEY `user_id` (`user_id`),

  -- Clave foránea hacia la tabla usuario. Si el usuario se elimina físicamente, su credencial también se elimina
  CONSTRAINT `fk_user_id` FOREIGN KEY (`user_id`) REFERENCES `usuario` (`id`) ON DELETE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=500001 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;


-- TABLA: usuario
-- Almacena la información principal del sistema
DROP TABLE IF EXISTS `usuario`;

CREATE TABLE `usuario` (
  -- Identificador único del usuario
  `id` int NOT NULL AUTO_INCREMENT,
  
  -- Nombre de usuario único para login
  `username` varchar(30) NOT NULL,

  -- Correo electrónico del usuario
  `email` varchar(120) NOT NULL,

  -- Fecha y hora de registro
  `fecha_registro` datetime DEFAULT CURRENT_TIMESTAMP,

  -- Estado del usuario: 0 = Inactivo, 1 = Activo
  `activo` tinyint(1) DEFAULT '1',

  -- Lógica de eliminado: 0 = Visible, 1 = Eliminado
  `eliminado` tinyint(1) DEFAULT '0',

  -- Clave primaria
  PRIMARY KEY (`id`),

  -- No se permiten usernames repetidos
  UNIQUE KEY `username` (`username`),

  -- No se permiten emails repetidos
  UNIQUE KEY `email` (`email`),

  -- Validación básica de formato de email
  CONSTRAINT `usuario_chk_1` CHECK ((`email` like _utf8mb4'%@%.%')),

  -- El campo activo solo puede valer 0 o 1
  CONSTRAINT `usuario_chk_2` CHECK ((`activo` in (0,1))),

  -- El campo eliminado solo puede valer 0 o 1
  CONSTRAINT `usuario_chk_3` CHECK ((`eliminado` in (0,1)))
) ENGINE=InnoDB AUTO_INCREMENT=524281 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;