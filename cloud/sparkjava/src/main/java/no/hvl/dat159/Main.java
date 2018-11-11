package no.hvl.dat159;

import static spark.Spark.*;

public class Main {
    public static void main(String[] args) {
    	
    	port(8080);
        get("/hello", (req, res) -> "Hello World");
    }
}
