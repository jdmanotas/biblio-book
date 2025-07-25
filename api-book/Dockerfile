# Usa una imagen base de OpenJDK 17 en Alpine para reducir el tamaño de la imagen
FROM openjdk:17-jdk-alpine

# Establece el directorio de trabajo dentro del contenedor
WORKDIR /app

# Copia el archivo JAR generado por Maven (asegúrate de que el nombre del archivo JAR sea correcto)
COPY ./app.jar app.jar

# Define el comando de entrada para ejecutar la aplicación Spring Boot
ENTRYPOINT ["java", "-jar", "app.jar"]

# Expone el puerto en el que la aplicación Spring Boot está configurada para escuchar
EXPOSE 8091
