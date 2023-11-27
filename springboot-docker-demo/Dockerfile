# define base docker image
FROM openjdk:17
LABEL maintainer="truongnvph29176"
ADD target/truongnvph29176-0.0.1-SNAPSHOT.jar truongnvph29176.jar
ENTRYPOINT ["java", "-jar", "truongnvph29176.jar"]