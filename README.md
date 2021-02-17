# pplflow Assessment

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

-  my silver bullet, concerns while you're reviewing this part is as folllow:
    * Make use of static analysis tool such as SonarQube
    * Check the components in code, their sizes, and their interactions with other components in the code.
       * Identify and look closely at certain types of code hot-spots, such as:
       * Large classes
       * Complex methods
       * Large components
       * Lot of dependencies
       * Uncovered code
