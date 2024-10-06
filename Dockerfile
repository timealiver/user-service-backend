# Use OpenJDK 21 as the base image
FROM openjdk:21

# Set the working directory in the container
WORKDIR /app

# Copy the project files to the container
COPY . /app

# Build the project using Maven
RUN ./mvnw clean package

# Copy the built JAR file to the container
COPY target/*.jar app.jar

# Expose the port that the application will listen on
EXPOSE 8080

# Run the application
CMD ["java", "-jar", "app.jar"]