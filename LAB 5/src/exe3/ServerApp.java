package exe3;

import java.net.DatagramPacket;
import java.net.DatagramSocket;

public class ServerApp {
	
public static void main(String[] args) {
		
		// Server UDP socket runs at this port
		final int serverPort=50001;
		int bufferSize = 1024;
		
		System.out.println("Server-Side Application for UDP demo\n");
		
		try {
			
			// Create a new DatagramSocket to receive responses from the client
		    DatagramSocket serverSocket = new DatagramSocket(50001);
		    
		    // Create buffer to hold receiving data.
		    byte[] inData = new byte[bufferSize];
		    
		    // Create a UDP packet to store the client data using the buffer 
		    // for receiving data
		    DatagramPacket inputPacket = new DatagramPacket(inData,
		    		inData.length);
		    System.out.println("Ready to receive connection... ");
		    
		    // Receive data from the client and store in inputPacket
		    serverSocket.receive(inputPacket);
		    
		    // Printing out the client sent data
		    String data = new String(inputPacket.getData());
		    System.out.println("Data from the client: " + data);
		    
		    // Close the socket connection
		    serverSocket.close();
		      
		} catch (Exception ex) {
			
			System.out.println("Durian Tunggal... we got problem");
			ex.printStackTrace();
		}
		
		System.out.println("\nProgram at server-side ends");

	}

}
