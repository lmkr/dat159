package no.hvl.dat159.dweet;

import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLEncoder;
import java.util.Scanner;
import java.util.logging.Logger;

import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

public class DweetClient {

	private String API_DWEET_END_POINT = "dweet.io";

	private JsonParser jsonParser = new JsonParser();
	private String thingName = "dat159-sensor";
	

	public DweetClient() {
				
	}
	
	public boolean publish(int temperature) throws IOException {
		
		JsonObject content = new JsonObject();
		
		content.addProperty("Temperature", temperature);
				
		thingName = URLEncoder.encode(thingName, "UTF-8");
		
		URL url = new URL("http" + "://" + API_DWEET_END_POINT + "/dweet/for/" + thingName);
				
		HttpURLConnection connection = (HttpURLConnection) url.openConnection();
		
		connection.setRequestProperty("Content-Type", "application/json; charset=utf-8");
		connection.setRequestMethod("POST");
		connection.setDoInput(true);
		connection.setDoOutput(true);
		
		PrintWriter out = new PrintWriter(connection.getOutputStream());
		
		out.println(content.toString());
		
		out.flush();
		out.close();
		
		JsonObject response = readResponse(connection.getInputStream());

		connection.disconnect();

		return (response.has("this") && response.get("this").getAsString().equals("succeeded"));
	}

	public String get() throws IOException {
		
		// http://dweet.io/get/latest/dweet/for/dat159-sensor
					
		thingName = URLEncoder.encode(thingName, "UTF-8");
		
		URL url = new URL("http" + "://" + API_DWEET_END_POINT + "/get/latest/dweet/for/" + thingName);
				
		HttpURLConnection connection = (HttpURLConnection) url.openConnection();
		
		connection.setRequestProperty("Content-Type", "application/json; charset=utf-8");
		connection.setRequestProperty("Accept", "application/json");
		connection.setRequestMethod("GET");
		connection.setDoInput(true);
		connection.setDoOutput(true);
		
		JsonObject response = readResponse(connection.getInputStream());

		connection.disconnect();

		if (response.has("this") && response.get("this").getAsString().equals("succeeded"))
		{
			return response.toString();
		}
		else {
			return null;
		}
	}
	
	private JsonObject readResponse(InputStream in) {
		
		Scanner scan = new Scanner(in);
		StringBuilder sn = new StringBuilder();
		
		while (scan.hasNext())
			sn.append(scan.nextLine()).append('\n');
		
		scan.close();
		
		return jsonParser.parse(sn.toString()).getAsJsonObject();
	}
}
