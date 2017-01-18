package cn.rgd.demo;

import java.io.PrintStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

class MyThread implements Runnable {
	private Socket client;
	public MyThread(Socket client) {
		this.client = client;
	}
	@Override
	public void run() {
		try {
			Scanner in = new Scanner(client.getInputStream());
			PrintStream out = new PrintStream(client.getOutputStream());
			boolean flag = true;
			while(flag) {
				String s = in.next();
				out.println("EHCO:"+ s);
				if(s.equalsIgnoreCase("ByeBye")) {
					flag = false;
				}
			}
			out.close();
			in.close();
			client.close();
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
}
public class Tests {
	public static void main(String[] args) throws Exception {
		ServerSocket server = new ServerSocket(9999);
		boolean flag = true;
		while(flag) {
			Socket client = server.accept();
			new Thread(new MyThread(client)).start();
		}
		server.close();
	}
}
