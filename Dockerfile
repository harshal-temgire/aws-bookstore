FROM openjdk:17-oracle
EXPOSE 8080
ADD target/awsbookstore.jar awsbookstore.jar 
ENTRYPOINT ["java","-jar","/awsbookstore.jar"]