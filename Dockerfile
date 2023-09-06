# Usa l'immagine base di OpenJDK
FROM openjdk:17-jdk-slim

# Informazioni sul manutentore (opzionale)
LABEL maintainer="gaetano.erizian@gmail.com"

# Crea una directory nel container dove l'applicazione risiederà
WORKDIR /app

# Copia il JAR dell'applicazione all'interno del container
COPY target/carbroker-0.0.1-SNAPSHOT.jar /app/spring-boot-app.jar

# Configura la porta e l'entry point
EXPOSE 8080
ENTRYPOINT ["java", "-jar", "/app/spring-boot-app.jar"]