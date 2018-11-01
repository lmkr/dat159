# DANGER: ASSIGNMENT UNDER CONSTRUCTION - CHANGES UNDERWAY

### Week 2: IoT and Publish-Subscribe Middleware

#### Heating Control System

You will implement a control system consisting of a virtual heating device (actuator), a virtual temperature sensor, and a (remote) heating/temperature controller aimed at keeping the temperature in a room within and upper and lower bound. The two IoT devices and the controller will communicate using the MQTT protocol and cloud services.  

#### Task 1: Design

The first step is to decide on the messaging architecture, i.e., which topics are to be used in the system.  

The heat device can be turned on to heat the room upon receiving message. The temperature sensor senses the temperature in the room and can send messages with the current temperature at certain time intervals. The controller should receive the temperature and use some logic to decide whether the state of the heating device should be on or off. The heater device should be turned off when the room is too hot (above some limit), and it should turned on when the room is too cold (below some limit). You will decide the baseline (normal) temperature value (e.g. 25oC).

#### Task 2: CloudMQTT

We will use CloudMQTT as the cloud Broker for subscribing to and publishing to a topic. To use the CloudMQTT, you will need to register for a free account (see step 1 below).

You have to register on CloudMQTT (Broker/Server) by going to https://www.cloudmqtt.com and create a free account on CloudMQTT (Cute Cat). If you have a github or google account you can use it.

Step 2: Implement MQTT clients
-	We are going to use Eclipse Paho client as client publisher and subscriber
  - The simplest way is to:
  - Create a maven project in Eclipse IDE
  - Include the dependency (paho.client.mqttv3) in your pom.xml file (copy it from the site below) https://mvnrepository.com/artifact/org.eclipse.paho/org.eclipse.paho.client.mqttv3/1.2.0
  - Copy the sample code (MQTTPubTemperature.java and MQTTSubTemperature.java)
  - Change the connection parameters to your CloudMQTT parameters (Click Details on your CloudMQTT)
  - broker: <tcp://your-cloudmqtt-instance:port>
  - username: <username-from-cloudmqtt>
  - password: <password-from-cloudmqtt>
  - Test that you can connect to CloudMQTT and publish/subscribe to the ‘Temp’ topic.

#### Task 3: Virtual Sensors and Actuators

Start by implementing a virtual temperature sensor and a virtual heating device following the same principles as was shown in the lecture.

#### Task 4: MQTT Clients and Controller

You will receive a sample code that publishes temperature sensor values to the temp topic on the CloudMQTT and also a sample code that subscribes to the temp topic on the CloudMQTT.

You will then need to implement:
1.	A remote controller that publishes heater device ‘state’ (on/off) to the CloudMQTT ‘Heat’ topic based on the temperature of the room (subscribed to the topic ‘Temp’).
2.	Heater device action (on/off) based on the signal received from the controller (subscribed to the topic ‘Heat’).
3.	A logic in the Temperature sensor to reasonably simulate switching between below normal temperature, normal temperature and above normal temperature over some time intervals.

#### Task 5: Demonstration

For approval of the assignment you will have to briefly demonstrate a working solution during the lectures on Friday (09.11), Monday (11.11.18) or Tuesday (12.11.18)
