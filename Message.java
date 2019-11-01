/* Message.java
 * Creating a message
 * City University of New York - Queens College
 * Author: Edgar Lizarraga
 * Instructor: Dr. Simina Fluture
 * Subject: Distributed Computing
 * Date: 04-18-2018
 * Version: 1.0
 * */
import java.io.Serializable;

public class Message implements Serializable {
	private int number;
	private int id;

	public Message(int number, int id) {
		this.number = number;
		this.id = id;
	}

	public String toString() {
		String s = "Message number: " + number + "\nMessage id: " + id;

		return s;
	} // end METHOD toString
}
