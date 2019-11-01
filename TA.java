/* TA.java
 * Creating a thread A
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

public class TA extends Thread {
	// to write Objects
	private ObjectOutputStream oos;

	// to write raw bytes
	private InputStream is;
	private OutputStream os;
	private InputStream is1;

	public TA(InputStream is, OutputStream os, ObjectInputStream ois, ObjectOutputStream oos, InputStream is1) {
		this.is = is;
		this.os = os;
		this.oos = oos;

		this.is1 = is1;
	} // end
		// CONSTRUCTOR

	public void run() {
		System.out.println("Thread TA starting execution.");
		try {
			// create the message
			Message m = new Message(150, 2052);
			System.out.println("Thread TA sends an object to TB: ");
			System.out.println(m);

			// TA sends message to TB
			oos = new ObjectOutputStream(os);
			oos.writeObject(m);

			// TA receives a primitive from TB
			System.out.println("Thread TA receives a primitive int value from TB: " + is.read());

			// TA receives a primitive from TC
			System.out.println("Thread TA receives a primitive int value from TC: " + is1.read());

		} // end TRY
		catch (Exception exc) {
			System.out.println("Error TA: " + exc);
		} // end CATCH

	} // end METHOD run

}
