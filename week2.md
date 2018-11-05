### Week 2: IoT and Publish-Subscribe Middleware

#### Heating Control System

You will implement a control system consisting of a virtual heating device (actuator), a virtual temperature sensor, a virtual display, and a (remote) heating/temperature controller aimed at keeping the temperature in a room within an upper and lower bound. The three IoT devices and the controller will communicate using the MQTT protocol and cloud services.  

#### Task 1: Design

The first step is to decide on the messaging architecture, i.e., which topics are to be used in the system and what the role (publisher/subscriber) the display, controller, temperature sensor, and heater should have. This was discussed at the lecture on Monday, November 5.  

The heat device can be turned on to heat the room upon receiving message. The temperature sensor senses the temperature in the room and sends messages with the current temperature. The controller should receive the temperature and use some logic to decide whether the state of the heating device should be on or off. The heater device should be turned off when the room is too hot (above some limit), and it should turned on when the room is too cold (below some limit).

#### Task 2: Setup CloudMQTT

We will use CloudMQTT as the cloud Broker for subscribing to and publishing to a topic. You have to register for a free account (Cute Cat) on CloudMQTT (Broker/Server) by going to https://www.cloudmqtt.com and create a free account on CloudMQTT.

#### Task 3: Sample Client Implementation

You will be implementing the three virtual IoT devices and the controller as cloud clients using the Eclipse Paho MQTT https://www.eclipse.org/paho/ client publisher and subscriber.

To get you started we have made an initial implementation of the system which is available from here:

https://github.com/lmkr/dat159/tree/master/roomcontrol

as an Eclipse project.

The project contains implementations of the virtual temperature sensor, the heating element, and a display. Furthermore, the code for the temperature sensor shows how to publish message to an MQTT topic. The code for the display shows how to subscribe to a topic and receive messages.

To make the start code run you need to provide the following information in the publisher and subscriber code which can be obtained via your CloudMQTT account:

  - broker: <tcp://your-cloudmqtt-instance:port>
  - username: <username-from-cloudmqtt>
  - password: <password-from-cloudmqtt>

Test that you can connect to CloudMQTT and publish/subscribe to the ‘Temp’ topic by running the main method in the MQTTSubTemperature class and the RoomDevice.

#### Task 4: Controller and Heating

You will have to implement the following

1. The logic in the controller to determine whether to switch the heater on/off depending on the temperature received on the temperature topic.

2. The publishing to the CloudMQTT ‘Heat’ topic in the controller of the heater device ‘state’ (on/off)

3. The subscriber part of the heater device that sets the state of the heating device (on/off) depending on the message received from the controller

#### Task 5: Demonstration

For approval of the assignment you will have to briefly demonstrate a working solution during the lectures on Friday (09.11), Monday (11.11.18), or Tuesday (12.11.18)
