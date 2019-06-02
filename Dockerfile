FROM maven:3.6.1-jdk-11-slim as build
COPY . .
RUN mvn install

FROM openjdk:11
WORKDIR /app
COPY --from=build executable/target/trafik-boot.jar /app
#ADD /app/trafik-boot.jar trafik-boot.jar
#ENTRYPOINT ["java", "-jar", "/trafik-boot.jar"]
ENTRYPOINT ["sh", "-c"]
CMD ["java -jar trafik-boot.jar"]