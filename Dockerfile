#// Pull jdk image
#// Add: Copy jar file from target to Docker file system
#//

FROM openjdk:11
ADD ./target/player-service-0.0.1-SNAPSHOT.jar /usr/src/player-service-0.0.1-SNAPSHOT.jar
WORKDIR usr/src
ENTRYPOINT ["java","-jar", "player-service-0.0.1-SNAPSHOT.jar"]