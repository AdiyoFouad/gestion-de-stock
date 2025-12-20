#FROM eclipse-temurin:17-jdk-alpine
#
#LABEL author="AdiyoFouad"
#
#WORKDIR /app
#
#COPY target/gestion-de-stock.jar ./gestion-de-stock.jar
#
#EXPOSE 8082
#
#CMD [ "java", "-jar", "gestion-de-stock.jar" ]

# Étape 1 : build Maven
FROM maven:3.9.9-eclipse-temurin-17-alpine AS build

WORKDIR /app

# Copier le pom et les sources
COPY pom.xml .
COPY src ./src

# Build du jar
RUN mvn clean package -DskipTests

# Étape 2 : image finale légère
FROM eclipse-temurin:17-jdk-alpine

WORKDIR /app

# Copier le jar buildé depuis l'étape précédente
COPY --from=build /app/target/gestion-de-stock.jar ./gestion-de-stock.jar

EXPOSE 8082

CMD ["java", "-jar", "gestion-de-stock.jar"]
