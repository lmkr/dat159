### Week 2: Simulating a room heater device, temperature sensor, and heater controller with MQTT protocol & cloud services - hands-on assignment

##### Task description
You will implement a heating device (actuator), temperature sensor (sensing), and heater controller to simulate remote controlling of room heating device using MQTT protocol and cloud services (see Fig.1). The heat device is turned on to heat the room upon receiving state signal subscribed to and published by the controller. The temperature sensor senses the temperature in the room and publishes the temperature value to the cloud at certain time interval. The controller subscribes to the temperature and uses a rule logic to decide the state of the heater device (On or Off). The heater device is turned off when the room is too hot, and it is turned on when the room is too cold. You will decide the baseline (normal) temperature value (e.g. 25oC).

We will use CloudMQTT as the cloud Broker for subscribing to and publishing to a topic. To use the CloudMQTT, you will need to register for a free account (see step 1 below).

You will receive a sample code that publishes temperature sensor values to the temp topic on the CloudMQTT and also a sample code that subscribes to the temp topic on the CloudMQTT.

You will then need to implement:
1.	A remote controller that publishes heater device ‘state’ (on/off) to the CloudMQTT ‘Heat’ topic based on the temperature of the room (subscribed to the topic ‘Temp’).
2.	Heater device action (on/off) based on the signal received from the controller (subscribed to the topic ‘Heat’).
3.	A logic in the Temperature sensor to reasonably simulate switching between below normal temperature, normal temperature and above normal temperature over some time intervals.

To get started follow the 2 steps below:

Step 1: Register on CloudMQTT (Broker/Server)
-	go to: https://www.cloudmqtt.com
-	Create a free account on CloudMQTT (Cute Cat)
  If you have a github or google account you can use it

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

Step 3: Complete your task!!!

For approval of the assignment you will have to show a working solution within 5 mins during the lectures on Monday (11.11.18) and Tuesday (12.11.18)
