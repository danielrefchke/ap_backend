# Imagen base
FROM amazoncorretto:11

# Etiqueta de mantenimiento
LABEL maintainer="Daniel Refchke <xshade@gmail.com>"

# Copiar el archivo JAR de la aplicación Spring en el contenedor Docker
COPY target/apirest-0.0.1-SNAPSHOT.jar /app.jar

# Comando para iniciar la aplicación
ENTRYPOINT ["java", "-jar", "/app.jar"]