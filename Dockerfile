FROM openjdk:11
ENV APP_HOME=/usr/app
WORKDIR $APP_HOME
COPY settings.gradle gradlew $APP_HOME
COPY gradle $APP_HOME/gradle
RUN gradle build || return 0
COPY . .
RUN gradle build