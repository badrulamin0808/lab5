package exe2;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.InetAddress;
import java.net.Socket;
import java.util.ArrayList;
import java.util.List;
import exe1.Exercise1;

public class Client {

public static void main(String[] args) {
		
		System.out.println("ClientSideApp: Demo to process a list of objects on TCP \n");

		// Request data
		
		Exercise1 p1 = new Exercise1();
		p1.setName("Mouse");
		p1.setPrice(10.10f);
		
		// Add into list
		List<Exercise1> products = new ArrayList<Exercise1>();
		products.add(p1);
		

		try {

			// Data to establish connection to server
			int portNo = 5001;
			InetAddress serverAddress = InetAddress.getLocalHost();

			// Connect to the server at localhost, port 4228
			Socket socket = new Socket(serverAddress, portNo);

			// Open stream to send object
			ObjectOutputStream objectOS = new ObjectOutputStream(socket.getOutputStream());

			// Send request to server
			System.out.println("Send object to server: " + products);
			objectOS.writeObject(products);
			objectOS.flush();
			
			// Open stream to receive object
			ObjectInputStream objectIS = new ObjectInputStream(socket.getInputStream());
			
			// Get object from stream, cast and display details
			products = (ArrayList<Exercise1>) objectIS.readObject();
			for (Exercise1 product:products)
				System.out.println ("Id for " + product.getName() + " is " + product.getitemProductid());
			
			// Close all closeable objects
			objectOS.close();
			objectIS.close();
			socket.close();

		} catch (IOException | ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		System.out.println("\nClientSideApp: End of application.\n");

	}

}
