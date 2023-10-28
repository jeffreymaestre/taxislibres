# Usar la imagen base de OpenJDK 17 en Alpine Linux
FROM openjdk:17-jdk-alpine

# Establecer el directorio de trabajo en /app
WORKDIR /app

# Instalar las herramientas necesarias (Git, Maven)
RUN apk update && \
    apk add --no-cache git && \
    apk add --no-cache maven

# Clonar el repositorio de GitHub
RUN git clone https://github.com/jeffreymaestre/taxislibres.git .

# Compilar el proyecto
RUN mvn clean package

# Exponer el puerto 8080
EXPOSE 8080

# Establecer el punto de entrada para el contenedor
ENTRYPOINT ["java", "-jar", "./target/maestre-0.0.1-SNAPSHOT.jar"]
