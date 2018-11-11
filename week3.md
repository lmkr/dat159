### Week 3: REST APIs and WoT

This assignment can be done in groups of up to three students.

#### Heating Control System

You will implement the same control system as in the week 2 assignment. The implementation will be based on a REST-based API implemented using the Spark/Java framework (http://sparkjava.com).

The virtual heating device (actuator), the virtual temperature sensor, the virtual display, and the (remote) heating/temperature controller will now be clients using the REST-based API. All data exchanged between the web-service and the clients will be in JSON.

#### Task 1 - Implement REST API

The first step is to implement the REST API using Spark/Java and test it using the Postman tool (https://www.getpostman.com/tools).

To get started we have provided parts of an implementation

https://github.com/lmkr/dat159/tree/master/cloud

which provides a REST API for retrieving and updating the current value of the temperature as a resource using the following operations

`GET http://localhost:8080/tempsensor/current`

`PUT http://localhost:8080/tempsensor/current`

where the body of the request/response is used to provide the current temperature in JSON format.

You start the Spark/Java web service locally by running the Main.java file.

You will have to augment the API such that there are also methods for retrieving and updating the current state of the heating actuator as a resource.

#### Task 2 - Implement the virtual IoT devices as clients

The virtual IoT devices and the controller from week 2 will be client using the REST API from task 2. You can find some example code for performing HTTP requests in Java here: https://github.com/lmkr/dat159/blob/master/iotprotocols/dweet/src/no/hvl/dat159/dweet/DweetClient.java

You may also use the Postman tool to generate Java code.

In this context, the virtual temperature sensor will have to periodically update the current temperature using the REST API and the display and the controller will have to periodically request the temperature resource. Similarly, the heating actuator will have to periodically determine whether to switch on/off the heating.

#### Task 3 - Deploy the REST API in the cloud.

This final step is **optional**.

Deploy your Spark/Java REST API on Heroku. Instructions can be found here: http://sparkjava.com/tutorials/heroku


#### Task 4 - Demonstration

For approval of the hands-on you will have to briefly demonstrate a working solution during the lectures on Friday (16.11) or on Monday (19.11.18), or Tuesday (20.11.18).
