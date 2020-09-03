/**
 * 
 */
package com.socketprogramming;

import java.io.BufferedInputStream;
import java.io.DataInputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * @author Mano's Comrade
 *
 */
public class Server {
	private Socket socket = null;
	private ServerSocket serverSocket = null;
	private DataInputStream dataInputStream = null;
	
	public Server(int port) throws IOException {
		serverSocket = new ServerSocket(port);
		socket = serverSocket.accept();
		
		dataInputStream = new DataInputStream(new BufferedInputStream(socket.getInputStream()));
		String line = "";
		
		while (!"Over".equalsIgnoreCase(line)) {
			line = dataInputStream.readUTF();
			System.out.println(line);
		}
	}
	
	/**
	 * @param args
	 * @throws IOException 
	 */
	public static void main(String[] args) throws IOException {
		new Server(5000);
	}
}