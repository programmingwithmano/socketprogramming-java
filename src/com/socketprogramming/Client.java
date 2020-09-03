/**
 * 
 */
package com.socketprogramming;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.net.UnknownHostException;

/**
 * @author Mano's Comrade
 *
 */
public class Client {

	private Socket socket = null;
	private DataInputStream dataInputStream = null;
	private DataOutputStream dataOutputStream = null;

	public Client(String host, int port) throws UnknownHostException, IOException {
		socket = new Socket(host, port);
		dataInputStream = new DataInputStream(System.in);
		dataOutputStream = new DataOutputStream(socket.getOutputStream());
		String line = "";

		while (!"Over".equalsIgnoreCase(line)) {
			line = dataInputStream.readLine();
			dataOutputStream.writeUTF(line);
		}

		socket.close();
		dataInputStream.close();
		dataOutputStream.close();
	}

	/**
	 * @param args
	 * @throws IOException
	 * @throws UnknownHostException
	 */
	public static void main(String[] args) throws UnknownHostException, IOException {
		new Client("127.0.0.1", 5000);
	}
}