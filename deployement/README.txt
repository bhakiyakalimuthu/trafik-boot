1.Before running the following step,Make sure to have maven & Java installed.Class paths are set.Versions used
  for testing is provided below.
2.Download the code,cd to trafik-boot.
3.To run the application, execute the below command from Unix/Mac terminal:
./mvnw clean package && java -jar executable/target/trafik-boot-executable-1.0-SNAPSHOT.jar



Version used for testing Application:
=====================================
Mac(10.14)
Maven - 3.3.9
Spring Boot - 2.1.2.RELEASE
Java - 11.0.2 2019-01-15 LTS(OpenJDK build by Oracle)

Note:
=====
Application will print expected output ie.Top 10 busline numbers as well as the bustops along with the busstop numbers
as json object on the console,everytime application started.


