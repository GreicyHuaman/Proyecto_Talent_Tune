FROM amazoncorretto:17-alpine-jdk
MAINTAINER GREICY
COPY target/Talent_Tune-0.0.1-SNAPSHOT.jar TalentTuneBackend.jar
ENTRYPOINT ["java", "-jar", "/TalentTuneBackend.jar"]
