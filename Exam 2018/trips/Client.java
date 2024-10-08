package net;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.Scanner;

/**
 * DO NOT EDIT THIS CLASS 
 * Errors must be corrected in the ServerForSingleClient class
 */
public class Client {
	public static void main(String[] args) throws IOException {
		// Initialize socket to exchange text messages with server using TCP
		Socket socket = new Socket("localhost", 6789);
		PrintWriter socketWriter = new PrintWriter(socket.getOutputStream());
		BufferedReader socketReader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
		
		// Initialize scanner to read input typed by the user on the keyboard
		Scanner userReader = new Scanner(System.in);
		String userInput = null;
		do {
		    // read user input on keyboard
			userInput = userReader.nextLine();
			
			// send request on socket
			String request = userInput;
			socketWriter.println(request);
			socketWriter.flush();
			
			// read reply from socket
			String reply = socketReader.readLine();
			
			// display reply on console
			System.out.println(reply);
		} while(! userInput.equalsIgnoreCase("exit"));
		
		userReader.close();
		socket.close();
	}
}
