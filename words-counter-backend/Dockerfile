FROM gradle:7-jdk11 AS build
COPY --chown=gradle:gradle . /home/gradle/src
WORKDIR /home/gradle/src
RUN gradle shadowJar --no-daemon

FROM openjdk:11
EXPOSE 80
RUN mkdir /app
COPY --from=build /home/gradle/src/build/libs/ /app/
ENTRYPOINT ["java","-jar","/app/com.wordscounter.words-counter-all.jar"]
