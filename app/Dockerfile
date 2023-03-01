##
# build stage
##
FROM gradle:8.0.1-jdk11-alpine as build
ENV APP_HOME=/usr/app
WORKDIR $APP_HOME
COPY settings.gradle gradlew $APP_HOME
COPY gradle $APP_HOME/gradle
RUN gradle build || return 0
COPY . .
RUN gradle build --exclude-task test
RUN echo "hello"


##
# package stage
##
FROM openjdk:11
WORKDIR /
COPY --from=build /usr/app/build/libs/app-v1.jar /
#RUN java -jar /app-v1.jar
#RUN echo "test"
EXPOSE 8080
ENTRYPOINT ["java", "-jar", "/app-v1.jar"]