FROM eclipse-temurin:21-jdk-alpine
EXPOSE 8081
COPY /target/product-catalog.jar product-catalog.jar
ENTRYPOINT [ "java","-jar","product-catalog.jar" ]