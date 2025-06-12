# ====================================
# Etapa 1: Construcción del proyecto
# ====================================
FROM maven:3.8.7-eclipse-temurin-17 AS build

WORKDIR /app

# Copiamos todo el proyecto (incluye src/, pom.xml, etc.)
COPY . .

# ✅ Asegúrate de que esta ruta coincida con donde está tu DB (dentro del proyecto)
# En tu caso: src/main/resources/db/sqlite_northwind.db ya va incluido al hacer COPY . .
# No es necesario un COPY adicional para eso aquí.

# Compilamos el proyecto (sin ejecutar tests)
RUN mvn clean package -DskipTests


# ====================================
# Etapa 2: Imagen liviana de ejecución
# ====================================
FROM eclipse-temurin:17-jdk-alpine

WORKDIR /app

# Copiamos el .jar compilado desde la etapa anterior
COPY --from=build /app/target/*.jar app.jar

# ✅ Copiamos también la base de datos compilada que está en el jar,
# pero si quieres asegurarte, incluye el recurso manualmente también:
COPY --from=build /app/src/main/resources/db ./src/main/resources/db

# Exponemos el puerto que usará Spring Boot
EXPOSE 8080

# Comando para lanzar la aplicación
ENTRYPOINT ["java", "-jar", "app.jar"]
