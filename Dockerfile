FROM openjdk:8
ADD executable/target/trafik-boot.jar trafik-boot.jar
ENTRYPOINT ["java", "-jar", "/trafik-boot.jar"]