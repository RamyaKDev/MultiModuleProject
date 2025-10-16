FROM eclipse-temurin:21-jdk-alpine
EXPOSE 8092
COPY /target/product-order.jar product-order.jar
ENTRYPOINT [ "java","-jar","product-order.jar" ]