package com.atguigu.java;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;

import org.junit.Test;

//3.�ӿͻ��˷���ͼƬ������ˣ�����˱��浽���ء������ء����ͳɹ������ͻ��ˡ����ر���Ӧ������

public class TestTCP3 {
	//�ͻ���
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
		//�����ͻ��˸�����˷��͵����ݽ���
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
	//�����
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
		os.write("������������յ�������".getBytes());
		
		//5.
		os.close();
		is.close();
		s.close();
		ss.close();
		
	}
}
