## Usa l'immagine base di OpenJDK
#FROM openjdk:17-jdk-slim
#
## Informazioni sul manutentore (opzionale)
#LABEL maintainer="your.email@example.com"
#
## Crea una directory nel container dove l'applicazione risiederà
#WORKDIR /app
#
## Copia il JAR dell'applicazione all'interno del container
#COPY target/your-application-name.jar /app/spring-boot-app.jar
#
## Configura la porta e l'entry point
#EXPOSE 8080
#ENTRYPOINT ["java", "-jar", "/app/spring-boot-app.jar"]