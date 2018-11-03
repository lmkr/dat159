package cloudmqttsample;

import java.util.Random;

import org.eclipse.paho.client.mqttv3.MqttClient;
import org.eclipse.paho.client.mqttv3.MqttConnectOptions;
import org.eclipse.paho.client.mqttv3.MqttException;
import org.eclipse.paho.client.mqttv3.MqttMessage;
import org.eclipse.paho.client.mqttv3.MqttPersistenceException;
import org.eclipse.paho.client.mqttv3.persist.MemoryPersistence;

/*
 * tosindo
 */

public class MQTTPubTemperature {

	private String topic = "Temp";
	private int qos = 1;
	private String broker = "tcp://your-cloudmqtt-instance:port”;
	private String clientId = "MQTT_Temperature";
	private String username = ""; 
	private String password = "";

	private MqttClient publisherClient;
	private Random rand;

	public MQTTPubTemperature() {

		rand = new Random();
	}

	private void publish() throws MqttPersistenceException, MqttException, InterruptedException {

		// loop forever
		while (true) {
			String temp = String.valueOf(rand.nextInt(60));
			System.out.println("Publishing message: " + temp);
			MqttMessage message = new MqttMessage(temp.getBytes());
			message.setQos(qos);
			publisherClient.publish(topic, message);
			Thread.sleep(4000);
		}

	}

	private void connect() {
		MemoryPersistence persistence = new MemoryPersistence();

		try {
			publisherClient = new MqttClient(broker, clientId, persistence);
			MqttConnectOptions connOpts = new MqttConnectOptions();
			connOpts.setCleanSession(true);
			connOpts.setUserName(username);
			connOpts.setPassword(password.toCharArray());
			System.out.println("Connecting to broker: " + broker);
			publisherClient.connect(connOpts);
			System.out.println("Connected");

		} catch (MqttException e) {
			System.out.println("reason " + e.getReasonCode());
			System.out.println("msg " + e.getMessage());
			System.out.println("loc " + e.getLocalizedMessage());
			System.out.println("cause " + e.getCause());
			System.out.println("excep " + e);
			e.printStackTrace();
		}
	}

	public static void main(String[] args) throws InterruptedException, MqttPersistenceException, MqttException {

		MQTTPubTemperature mqttpub = new MQTTPubTemperature();
		mqttpub.connect();
		mqttpub.publish();

	}
}
