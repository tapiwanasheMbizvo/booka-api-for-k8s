docker run --name demo-db -e POSTGRES_PASSWORD=tapiwaroot -d postgres -p 54541:5432

docker run  --name myPostgresDb -p 5455:5432 -e POSTGRES_USER=postgresUser -e POSTGRES_PASSWORD=postgresPW -e POSTGRES_DB=postgresDB -d postgres

spring:
  jpa:
    database: POSTGRESQL
    show-sql: true
    hibernate:
      ddl-auto: update
  datasource:
    url: jdbc:postgresql://localhost:5498/booksdb
    username: bookappusr
    password: bookapppwd
    driverClassName: org.postgresql.Driver
  sql:
    init:
      platform: postgres
