# pplflowAssessment

**First Part:**
frist part is implemented with its considarations
- Being simply executable with the least effort Ideally using Docker.
 yo can create a docker image using the following command 
 ```
 sudo ./mvnw spring-boot:build-image -Dspring-boot.build-image.imageName=springio/employee-docker
 ```
and then you can run the image in the container using the following command 
```
sudo docker run -p 8080:8080 springio/employee-docker
```
-  For state machine could be as simple as of using ENUM so i'm using ENUM as the states is not so complix 

- Complete test coverage is in the test folder of the app and you can run tests using the following command 
```
./mvnw test
```
- API contract and documentation is Done using OPEN API complient SWAGGER 2 and is available at the following link while the app is running  at the following link
```
http://localhost:8080/swagger-ui/
```
**Second Part**
