package net;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * Serves multiple requests for a single client
 * Please debug me
 * 
 * @author t.perennou
 */
public class ServerForSingleClient {
	public static void main(String[] args) throws IOException {
		ServerSocket serverSocket = new ServerSocket(2000);
		Socket clientSocket = serverSocket.accept();
		PrintWriter socketWriter = new PrintWriter(clientSocket.getOutputStream());
		BufferedReader socketReader = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
		String request = "dummy";
		String reply = request.toUpperCase() + " " + request.toUpperCase();
		socketWriter.println(reply);
		request = socketReader.readLine();
		clientSocket.close();
		serverSocket.close();
	}
}
