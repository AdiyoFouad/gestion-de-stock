FROM eclipse-temurin:17-jdk-alpine

LABEL author="AdiyoFouad"

WORKDIR /app

COPY target/gestion-de-stock.jar ./gestion-de-stock.jar

EXPOSE 8082

CMD [ "java", "-jar", "gestion-de-stock.jar" ]