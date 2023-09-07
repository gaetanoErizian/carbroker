# Car Broker Application

Un'applicazione Spring Boot per gestire l'acquisto di automobili.

## Prerequisiti

- Java 17
- Maven
- Docker
- MySQL

## Come iniziare

1. **Clonare il repository**:
    ```bash
    git clone https://github.com/yourusername/carbroker.git
    cd carbroker
    ```

2. **Avviare MySQL usando Docker**:
    ```bash
    docker run --name carbroker-mysql -e MYSQL_ROOT_PASSWORD=my-secret-pw -d -p 3306:3306 mysql:latest
    ```

3. **Creare il database**:
   Accedi al tuo MySQL e crea un database chiamato `carbroker`:

    ```bash
    docker exec -it carbroker-mysql mysql -uroot -p
    ```

   Poi, per lanciare il motore database tramite container, esegui:
    ```docker-compose up -d
    ```

4. **Configurare `application.properties`**:
   Assicurati che `src/main/resources/application.properties` abbia le seguenti proprietà:

    ```properties
    spring.datasource.url=jdbc:mysql://localhost:3306/carbroker
    spring.datasource.username=root
    spring.datasource.password=my-secret-pw
    spring.jpa.hibernate.ddl-auto=update
    ```

5. **Compilare e avviare l'applicazione**:

    ```bash
    mvn clean install
    mvn spring-boot:run
    ```

6. **Accesso a Swagger UI**:
   Una volta avviata l'applicazione, puoi navigare a `http://localhost:8080/swagger-ui.html` per visualizzare e testare le API esposte attraverso Swagger.

## Caricare dati tramite CSV

Per caricare dati nel sistema attraverso un file CSV:

1. Preparare il file CSV con le seguenti colonne:
    - fourByFour
    - priceRange
    - age
    - automaticTransmission
    - fuelType

2. Usare un tool come Postman per effettuare una POST request all'endpoint `/api/cars/bulk-insert` allegando il file CSV.

## Test

Per eseguire test unitari ed integrati:

```bash
mvn test
```

## File CSV di esempio

Un file grezzo .csv di esempio si trova nel package resources

```bash
src/main/resources/cars.csv
```

## Estrarre auto con filtri

C'è la possibilità di chiamare l'endpoint ```/api/cars/filtered``` e fornire qualsiasi combinazione di parametri per ottenere i risultati filtrati desiderati.

Ecco come potresti usarlo:

Per ottenere tutte le auto di 1 anno con cambio automatico:

``` bash
/api/cars/filtered?age=ONE&automaticTransmission=true
```

Per quelle più vecchie a gasolio:

``` bash
/api/cars/filtered?fuelType=gasolio
```
Per quelle con anzianità di 3 anni, fascia di prezzo 5k/10k e cambio automatico:

```bash
/api/cars/filtered?age=THREE&priceRange=5k10K&automaticTransmission=true
```

Aggiungere ```&fourByFour=true``` a qualsiasi delle chiamate precedenti se desideri filtrare per 4x4.