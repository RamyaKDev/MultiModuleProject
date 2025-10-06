FROM eclipse-temurin:21-jdk-alpine
EXPOSE 8089
COPY /target/product-cart.jar product-cart.jar
ENTRYPOINT [ "java","-jar","product-cart.jar" ]