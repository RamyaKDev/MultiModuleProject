FROM eclipse-temurin:21-jdk-alpine
EXPOSE 8093
COPY /target/product-notify.jar product-notify.jar
ENTRYPOINT [ "java","-jar","product-notify.jar" ]