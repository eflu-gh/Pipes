/*ConnectionManager.java
 * Creating pipes for communication between threads
 * City University of New York - Queens College
 * Author: Edgar Lizarraga
 * Instructor: Dr. Simina Fluture
 * Subject: Distributed Computing
 * Date: 04-18-2018
 * Version: 1.0
 * */
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.PipedInputStream;
import java.io.PipedOutputStream;

public class ConnectionManager {
	// Pipe between TA and TB, from pos1 to pis1
	static private PipedInputStream pis1;
	static private PipedOutputStream pos1;

	// Pipe between TB and TA, from pos2 to pis2
	static private PipedInputStream pis2;
	static private PipedOutputStream pos2;

	// Pipe between TB and TC, from pos3 to pis3
	static private PipedInputStream pis3;
	static private PipedOutputStream pos3;

	// Pipe between TC and TA, from pos4 to pis4
	static private PipedInputStream pis4;
	static private PipedOutputStream pos4;

	static private ObjectOutputStream oos;
	static private ObjectInputStream ois;

	static private ObjectOutputStream oos1;
	static private ObjectInputStream ois1;

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		try {
			// set up a pipe
			System.out.println("Pipe setup");
			pos1 = new PipedOutputStream();
			pis1 = new PipedInputStream(pos1);

			pos2 = new PipedOutputStream();
			pis2 = new PipedInputStream(pos2);

			pos3 = new PipedOutputStream();
			pis3 = new PipedInputStream(pos3);

			pos4 = new PipedOutputStream();
			pis4 = new PipedInputStream(pos4);

			System.out.println("Object creation TA");
			TA threadTA = new TA(pis2, pos1, ois, oos, pis4);
			TB threadTB = new TB(pis1, pos2, ois, oos, pos3, oos1);
			TC threadTC = new TC(pis3, ois1, pos4);

			threadTA.start();
			threadTB.start();
			threadTC.start();
		} // end TRY
		catch (Exception exc) {
			System.out.println(exc);
		} // end CATCH
	}

}
