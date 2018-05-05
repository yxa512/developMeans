package com.atguigu.java;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;

import org.junit.Test;

//�ͻ��˷������ݸ�����ˣ�����˽����ݴ�ӡ������̨�ϡ�
public class TestTCP1 {
	//�ͻ���
	@Test
	public void client() throws Exception{
		//1.
		Socket socket = new Socket("127.0.0.1", 9090);
		//2.
		OutputStream os = socket.getOutputStream();
		//3.
		os.write("��ã����ǿͻ���".getBytes());
		//4.
		os.close();
		socket.close();
		
	}
	//�����
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
		is.close();
		s.close();
		ss.close();
		
	}
}
