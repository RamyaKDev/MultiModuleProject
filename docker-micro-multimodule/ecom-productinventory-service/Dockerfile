FROM eclipse-temurin:21-jdk-alpine
EXPOSE 8087
COPY /target/product-inventory.jar product-inventory.jar
ENTRYPOINT [ "java","-jar","product-inventory.jar" ]