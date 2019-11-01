/* TB.java
 * Creating a thread B
 * City University of New York - Queens College
 * Author: Edgar Lizarraga
 * Instructor: Dr. Simina Fluture
 * Subject: Distributed Computing
 * Date: 04-18-2018
 * Version: 1.0
 * */
import java.io.InputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.OutputStream;

public class TB extends Thread {

	// to write Objects
	private ObjectInputStream ois;
	private ObjectOutputStream oos1;

	// to write raw bytes
	private InputStream is;
	private OutputStream os;
	private OutputStream os1;

	public TB(InputStream is, OutputStream os, ObjectInputStream ois, ObjectOutputStream oos, OutputStream os1,
			ObjectOutputStream oos1) {
		this.is = is;
		this.os = os;
		this.ois = ois;
		this.os1 = os1;
		this.oos1 = oos1;
	} // end CONSTRUCTOR

	public void run() {
		System.out.println("Thread TB starting execution.");
		System.out.println();
		try {
			// TB receives an object from TA
			ois = new ObjectInputStream(is);
			Message m = (Message) ois.readObject();
			System.out.println("Thread TB receives an object from TA: ");
			System.out.println(m);
			System.out.println();

			// TB sends primitive to TA
			int number = 153;
			System.out.println("Thread TB sends a primitive int value to TA: " + number);
			os.write(number);

			// create the message
			Message m1 = new Message(222, 6666);
			System.out.println("Thread TB sends an object to TC: ");
			System.out.println(m1);

			// TB sends an object to TC
			oos1 = new ObjectOutputStream(os1);
			oos1.writeObject(m1);

		} // end TRY
		catch (Exception exc) {
			System.out.println("Error TB: " + exc);
		} // end CATCH

	} // end METHOD run
}
