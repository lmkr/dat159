package cloudmqttsample;

import org.eclipse.paho.client.mqttv3.IMqttDeliveryToken;
import org.eclipse.paho.client.mqttv3.MqttCallback;
import org.eclipse.paho.client.mqttv3.MqttClient;
import org.eclipse.paho.client.mqttv3.MqttConnectOptions;
import org.eclipse.paho.client.mqttv3.MqttException;
import org.eclipse.paho.client.mqttv3.MqttMessage;
import org.eclipse.paho.client.mqttv3.persist.MemoryPersistence;

/**
 * @author tosindo
 *
 */
public class MQTTSubTemperature implements MqttCallback{
	
	private String message;
	
	public MQTTSubTemperature() throws MqttException {
		String topic    = "Temp";
        int qos         = 1;		//1 - This client will acknowledge to the Device Gateway that messages are received
        String broker   = "tcp://m23.cloudmqtt.com:14331";
        String clientId = "MQTT_Temperature_SUB";
        String username = "bstsnwbg";
        String password = "r9KiZDnb0_cF";
    	
        MqttConnectOptions connOpts = new MqttConnectOptions();
        connOpts.setCleanSession(true);
        connOpts.setUserName(username);
        connOpts.setPassword(password.toCharArray());
        
        System.out.println("Connecting to broker: "+broker);
        
        MqttClient client = new MqttClient(broker, clientId, new MemoryPersistence());
        client.setCallback(this);
        client.connect(connOpts);
        System.out.println("Connected");
        
        client.subscribe(topic, qos);
        System.out.println("Subscribed to message");

	}
    
    /**
     * @see MqttCallback#connectionLost(Throwable)
     */
	public void connectionLost(Throwable cause) {
		System.out.println("Connection lost because: " + cause);
		System.exit(1);
		
	}
	
	/**
	 * @see MqttCallback#messageArrived(String, MqttMessage)
	 */
	public void messageArrived(String topic, MqttMessage message) throws Exception {
		System.out.println(String.format("[%s] %s", topic, new String(message.getPayload())));
		this.setMessage(new String(message.getPayload()));
	}
	
	/**
	 * @see MqttCallback#deliveryComplete(IMqttDeliveryToken)
	 */
	public void deliveryComplete(IMqttDeliveryToken token) {
		// TODO Auto-generated method stub
		
	}
	
    public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public static void main(String args[]) throws MqttException {
    	new MQTTSubTemperature();
    	
    }

}
