FROM eclipse-temurin:21-jdk-alpine
EXPOSE 8082
COPY /target/product-info.jar product-info.jar
ENTRYPOINT [ "java","-jar","product-info.jar" ]