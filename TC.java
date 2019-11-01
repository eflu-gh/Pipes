/* TC.java
 * Creating a thread C
 * City University of New York - Queens College
 * Author: Edgar Lizarraga
 * Instructor: Dr. Simina Fluture
 * Subject: Distributed Computing
 * Date: 04-18-2018
 * Version: 1.0
 * */
import java.io.InputStream;
import java.io.ObjectInputStream;
import java.io.OutputStream;

public class TC extends Thread {

	// to write Objects
	private ObjectInputStream ois1;

	// to write raw bytes
	private InputStream is;
	private OutputStream os;

	public TC(InputStream is, ObjectInputStream ois1, OutputStream os) {
		this.is = is;
		this.ois1 = ois1;
		this.os = os;

	} // end

	public void run() {
		System.out.println("Thread TC starting execution.");
		System.out.println();
		try {
			// TC receives an object from TB
			ois1 = new ObjectInputStream(is);
			Message m = (Message) ois1.readObject();
			System.out.println("Thread TC receives an object from TB: ");
			System.out.println(m);
			System.out.println();

			// TC sends a primitive to TA
			int number = 1;
			System.out.println("Thread TC sends a primitive int value to TA: " + number);
			os.write(number);

		} // end TRY
		catch (Exception exc) {
			System.out.println("Error TB: " + exc);
		} // end CATCH

	} // end METHOD run

}
