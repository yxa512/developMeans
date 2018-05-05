package com.atguigu.java;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;

import org.junit.Test;

//3.从客户端发送图片给服务端，服务端保存到本地。并返回“发送成功”给客户端。并关闭相应的连接

public class TestTCP3 {
	//客户端
	@Test
	public void client() throws Exception{
		//1.
		Socket socket = new Socket("127.0.0.1", 9090);
		//2.
		FileInputStream fis = new FileInputStream("10.jpg");
		OutputStream os = socket.getOutputStream();
		//3.
		byte[] b1 = new byte[1024];
		int len1;
		while((len1 = fis.read(b1)) != -1){
			os.write(b1, 0, len1);
		}
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
		FileOutputStream fos = new FileOutputStream("20.jpg");
		byte[] b = new byte[1024];
		int len;
		while((len = is.read(b)) != -1){
			fos.write(b, 0, len);
		}
		//4.
		OutputStream os = s.getOutputStream();
		os.write("你的情意我已收到。。。".getBytes());
		
		//5.
		os.close();
		is.close();
		s.close();
		ss.close();
		
	}
}
