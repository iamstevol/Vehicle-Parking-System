FROM eclipse-temurin:19.0.2_7-jdk-alpine
EXPOSE 5000
#ARG JAR_FILE=target/VehicleParkingSystem-0.0.1-SNAPSHOT.jar
ADD target/vehicle_parking_system.jar vehicle_parking_system.jar
ENTRYPOINT ["java","-jar","vehicle_parking_system.jar"]