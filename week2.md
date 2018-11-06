### Week 2: IoT and Publish-Subscribe Middleware

#### Heating Control System

You will implement a control system consisting of a virtual heating device (actuator), a virtual temperature sensor, a virtual display, and a (remote) heating/temperature controller aimed at keeping the temperature in a room within an upper and lower bound.

The three IoT devices (heater temperature, display( and the controller will communicate using the MQTT protocol and cloud services.  

#### Task 1 - Design

The first step is to decide on the messaging architecture, i.e., which topics are to be used in the system the role (publisher/subscriber) of the display, controller, temperature sensor, and heater. This was already discussed jointly at the lecture on Monday, November 5.  

The basic idea is that the heating device can be turned on to heat the room upon receiving a message. The temperature sensor senses the temperature in the room and sends messages with the current temperature. The controller should receive the temperature and use some computational intelligence (algorithm) to decide whether the heating device should be turned on or off. The heater device should be turned off when the room is too hot (above some upper limit), and it should turned on when the room is too cold (below some lower limit).

#### Task 2 - Setup CloudMQTT

We will use CloudMQTT as the broker for subscribing to and publishing messages to topics. You have to register for a free account (Cute Cat) on CloudMQTT (Broker/Server) by going to https://www.cloudmqtt.com

#### Task 3 - Sample Client Implementation

You will be implementing the three virtual IoT devices and the controller as clients using the Eclipse Paho MQTT https://www.eclipse.org/paho/ for publishing and subscribing.

To get you started you are provided with an initial implementation of the system which is available from here:

https://github.com/lmkr/dat159/tree/master/roomcontrol

as an Eclipse project.

The project contains implementations of a virtual temperature sensor, the heating element, and a display. Furthermore, the code associated with the temperature sensor shows how to publish message to a MQTT topic. The code associated with the display shows how to subscribe to a topic and receive messages.

To make the start code run, you need to provide the following information in the publisher and subscriber code which can be obtained via your CloudMQTT account:

  - broker: <tcp://your-cloudmqtt-instance:port>
  - username: <username-from-cloudmqtt>
  - password: <password-from-cloudmqtt>

Test that you can connect to CloudMQTT and publish/subscribe to the ‘Temp’ topic by running the main method in the MQTTSubTemperature class and in the RoomDevice class.

#### Task 4 - Controller and Heating

You will have to implement the following

1. A controller and associated logic to determine whether to switch the heater on/off depending on the temperature received on the temperature topic.

2. The publishing to CloudMQTT in the controller of the heater device ‘state’ (on/off).

3. The subscriber part of the heating device that sets the state of the heating device (on/off) depending on the message received from the controller.

#### Task 5 - Demonstration

For approval of the hands-on you will have to briefly demonstrate a working solution during the lectures on Friday (09.11), Monday (11.11.18), or Tuesday (12.11.18)
