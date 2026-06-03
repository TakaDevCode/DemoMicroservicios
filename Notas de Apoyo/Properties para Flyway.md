# ── Datasource ──────────────────────────────────────────────────────────────

# URL de conexión a la base de datos. 
# Define el motor (postgresql, mysql, etc.), host, puerto y nombre de la BD

spring.datasource.url=jdbc:postgresql://localhost:5432/mydb

# Usuario con permisos para conectarse y ejecutar migraciones

spring.datasource.username=myuser

# Contraseña del usuario de base de datos

spring.datasource.password=mypassword

# Clase del driver JDBC correspondiente al motor de base de datos utilizado

spring.datasource.driver-class-name=org.mysql.Driver

# ── Flyway core ──────────────────────────────────────────────────────────────

# Activa o desactiva Flyway completamente. 
# En false, no se ejecuta ninguna migración al iniciar

spring.flyway.enabled=true

# Ruta donde Flyway buscará los scripts SQL. 
# Puede apuntar a classpath o a una ruta del sistema de archivos

spring.flyway.locations=classpath:db/migration

# Nombre de la tabla interna donde Flyway registra el historial de migraciones ejecutadas

spring.flyway.table=flyway_schema_history

# ── Naming convention de scripts ────────────────────────────────────────────

# Prefijo que deben tener los archivos de migración versionados 
# (por defecto V). Ejemplo: V1__nombre.sql

spring.flyway.sql-migration-prefix=V

# Separador entre el número de versión y la descripción del script. 
# Por defecto son dos guiones bajos

spring.flyway.sql-migration-separator=__

# Extensión de los archivos que Flyway reconocerá como scripts de migración

spring.flyway.sql-migration-suffixes=.sql

# ── Comportamiento ───────────────────────────────────────────────────────────

# Si está en true, Flyway valida que los scripts ya aplicados 
# no hayan sido modificados al iniciar la app

spring.flyway.validate-on-migrate=true

# Permite ejecutar migraciones con versiones anteriores a la última aplicada. Útil en equipos con ramas paralelas

spring.flyway.out-of-order=false

# Permite aplicar Flyway sobre una BD que ya tiene tablas 
# pero sin historial previo de migraciones

spring.flyway.baseline-on-migrate=true

# Versión desde la cual se considera el baseline cuando 
# baseline-on-migrate está en true

spring.flyway.baseline-version=1

# ── Seguridad (importante en producción) ─────────────────────────────────────

# Deshabilita el comando clean, que borra todos los objetos de la BD. 
# Debe estar en true en producción

spring.flyway.clean-disabled=true

# Si está en true, ejecuta un clean automático cuando falla la validación. 
# Extremadamente peligroso en producción

spring.flyway.clean-on-validation-error=false