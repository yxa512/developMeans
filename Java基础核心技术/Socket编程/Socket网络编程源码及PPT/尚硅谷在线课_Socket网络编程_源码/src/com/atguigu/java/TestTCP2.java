package com.atguigu.java;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;

import org.junit.Test;

//客户端发送内容给服务端，服务端给予反馈。

public class TestTCP2 {
	//客户端
	@Test
	public void client() throws Exception{
		//1.
		Socket socket = new Socket("127.0.0.1", 9090);
		//2.
		OutputStream os = socket.getOutputStream();
		//3.
		os.write("你好，我是客户端".getBytes());
		//表明客户端给服务端发送的内容结束
		socket.shutdownOutput();
		//4.
		InputStream is = socket.getInputStream();
		byte[] b = new byte[1024];
		int len;
		while((len = is.read(b)) != -1){
			System.out.print(new String(b,0,len));
		}
		
		//5.
		is.close();
		os.close();
		socket.close();
		
	}
	//服务端
	@Test
	public void server() throws Exception{
		//1.
		ServerSocket ss = new ServerSocket(9090);
		//2.
		Socket s = ss.accept();
		//3.
		InputStream is = s.getInputStream();
		byte[] b = new byte[1024];
		int len;
		while((len = is.read(b)) != -1){
			String str = new String(b,0,len);
			System.out.print(str);
		}
		//4.
		OutputStream os = s.getOutputStream();
		os.write("帅哥，人家是服务端的啦".getBytes());
		
		//5.
		os.close();
		is.close();
		s.close();
		ss.close();
		
	}
}
