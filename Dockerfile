FROM amazoncorretto:17
MAINTAINER filia.aleks@gmail.com
COPY target/webflux-fargate-0.0.1-SNAPSHOT.jar app
ENTRYPOINT ["java","-jar","$JAVA_OPTIONS", "/app"]