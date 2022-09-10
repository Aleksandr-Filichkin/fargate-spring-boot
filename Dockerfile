FROM amazoncorretto:17
MAINTAINER filia.aleks@gmail.com
EXPOSE 8080
COPY target/webflux-fargate-0.0.1-SNAPSHOT.jar app
ENTRYPOINT ["java","-jar","/app"]