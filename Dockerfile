FROM openjdk:17
EXPOSE 8080
COPY "./target/Agenda_citas_laboratorio-0.0.1-SNAPSHOT.jar" "app.jar"
ENTRYPOINT ["java","-jar","app.jar"]