FROM java:8
EXPOSE 8093
ADD /target/Candidat-0.0.1-SNAPSHOT.jar Candidat.jar
ENTRYPOINT ["java","-jar","Candidat.jar"]