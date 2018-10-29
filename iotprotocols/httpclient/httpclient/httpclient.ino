
#include <WiFi.h>

char ssid[] = "os21-1-netgear";     //  your network SSID (name)
char pass[] = "XXXXXX";    // your network password
int status = WL_IDLE_STATUS;     // the Wifi radio's status

WiFiClient client;

// server address:
// 192.168.0.1 
//byte server[] = { 93, 184, 216, 34 };
//char server[] = "www.example.com";
IPAddress server_address(192, 168, 1, 1);
int server_port = 80;
 
unsigned long lastConnectionTime = 0;            // last time you connected to the server, in milliseconds
const unsigned long postingInterval = 10L * 1000L; // delay between updates, in milliseconds

void setup() {
  // initialize serial:
  Serial.begin(9600);

  // attempt to connect using WPA2 encryption:
  Serial.println("Attempting to connect to WPA network...");
  status = WiFi.begin(ssid, pass);
  delay(10000);
  //WiFi.mode(WIFI_STA);
  // if you're not connected, stop here:
  if ( status != WL_CONNECTED) {
    Serial.println("Couldn't get a wifi connection");
    // while(true);
  }
  // if you are connected, print out info about the connection:
  else {
    Serial.println("Connected to network");

    printWifiStatus();
  }
}

void loop() {
  // if there's incoming data from the net connection.
  // send it out the serial port.  This is for debugging
  // purposes only:

  Serial.println("\nStarting connection to server...");
  // if you get a connection, report back via serial:
  delay(10000);

  if (status == WL_CONNECTED) {

    if (!client.connected())
    {
      Serial.println("attempt connect");
      client.connect(server_address, server_port);
      delay(1000);
      client.stop();
    }
    else
    {
      Serial.println("connected to server");
      client.stop();
    }
    delay(10000);
  }
}

// this method makes a HTTP connection to the server:
void httpRequest() {
  // close any connection before send a new request.
  // This will free the socket on the WiFi shield
  client.stop();

  // if there's a successful connection:
  if (client.connect(server_address, 80)) {
    Serial.println("connecting...");
    // send the HTTP PUT request:
    client.println("GET /latest.txt HTTP/1.1");
    client.println("Host: www.arduino.cc");
    client.println("User-Agent: ArduinoWiFi/1.1");
    client.println("Connection: close");
    client.println();

    // note the time that the connection was made:
    lastConnectionTime = millis();
  } else {
    // if you couldn't make a connection:
    Serial.println("connection failed");
  }
}

void printWifiStatus() {
  // print the SSID of the network you're attached to:
  Serial.print("SSID: ");
  Serial.println(WiFi.SSID());

  // print your WiFi shield's IP address:
  IPAddress ip = WiFi.localIP();
  Serial.print("IP Address: ");
  Serial.println(ip);

  // print the received signal strength:
  long rssi = WiFi.RSSI();
  Serial.print("signal strength (RSSI):");
  Serial.print(rssi);
  Serial.println(" dBm");

  Serial.print("Firmware version: ");
  Serial.println(WiFi.firmwareVersion());
}


