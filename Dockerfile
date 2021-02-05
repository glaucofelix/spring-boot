#SETA O JDK
FROM openjdk:8-jdk-alpine
#CRIA UM USUARIO PRA RODAR
RUN addgroup -S spring && adduser -S spring -G spring 
#TROCA PARA O USUARIO
USER spring:spring
#CRIA VARIAVEL COM NOME DO JAR
ARG JAR_FILE=target/*.jar
# COPIAR O JAR PARA VM DO DOCKER
COPY ${JAR_FILE} app.jar
ENTRYPOINT ["java","-Xmx512m","-Dserver.port=${PORT}","-Dspring.profiles.active=${PROFILE}","-jar","/app.jar"]