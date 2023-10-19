FROM eclipse-temurin:17-jdk-alpine
VOLUME /tmp
COPY target/D387_sample_code-0.0.2-SNAPSHOT.jar app.jar
EXPOSE 8080/tcp
ENTRYPOINT ["java","-jar","/app.jar"]