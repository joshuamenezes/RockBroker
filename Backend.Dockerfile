FROM openjdk:22-jdk-slim
# Create a new src directory
WORKDIR /src

# Copy all the source files to it
COPY ./rockbroker-backend ./

# Note that the name is found in pom.xml, and I can increment build versions if I want to
RUN chmod +x mvnw
RUN ./mvnw package -DskipTests

EXPOSE 8080

CMD ["java", "-jar", "target/rockbroker-backend-0.0.1-SNAPSHOT.jar"]
