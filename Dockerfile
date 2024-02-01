FROM eclipse-temurin:17-alpine

RUN mkdir /opt/app

COPY "build/libs/launchdarkly-shelter-demo-0.0.1-SNAPSHOT.jar" /opt/app/launchdarkly-shelter-demo.jar

CMD ["java", "-jar", "/opt/app/launchdarkly-shelter-demo.jar"]