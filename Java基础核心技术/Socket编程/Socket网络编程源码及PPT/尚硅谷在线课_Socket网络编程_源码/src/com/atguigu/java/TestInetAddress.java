package com.atguigu.java;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class TestInetAddress {
	public static void main(String[] args) throws IOException {
		
		Socket socket = new Socket("192.168.1.109", 9090);
		//2.
		OutputStream os = socket.getOutputStream();
		//3.
		os.write("你好，我是客户端".getBytes());
		//4.
		os.close();
		socket.close();
	}
}
