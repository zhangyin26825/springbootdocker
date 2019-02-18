FROM maven:3-jdk-8-slim as BUILD

COPY . /usr/src/app
RUN mvn --batch-mode -f /usr/src/app/pom.xml clean package

FROM openjdk:8-jre-slim
ENV PORT 80
EXPOSE 80
COPY --from=BUILD /usr/src/app/target /opt/target
WORKDIR /opt/target

CMD ["/bin/bash", "-c", "java -Xmx200m -jar springbootdocker-0.1.0.jar"]
