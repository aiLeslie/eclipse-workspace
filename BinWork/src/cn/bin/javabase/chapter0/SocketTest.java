package cn.bin.javabase.chapter0;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class SocketTest {
	private final static String MY_IPAddRESS = "192.168.10.244";

	public static void main(String[] args) {

		new Thread() {
			@Override
			public void run() {
				super.run();
				ServerSocket serverSocket = null;
				Socket mSocket = null;
				try {
					serverSocket = new ServerSocket(1000);
					mSocket = new Socket(MY_IPAddRESS, 1000);
					System.out.println("开启服务端");

					Socket socket = serverSocket.accept();
					System.out.println(socket);
					socket.close();
					socket = serverSocket.accept();
					System.out.println(socket);
					byte[] bytes = new byte[5];
					socket.getInputStream().read(bytes);

					if (socket.getInputStream().available() > 0)
						System.out.println(new String(bytes));

				} catch (IOException e) {
					e.printStackTrace();
				} finally {
					// 关闭系统资源
					try {
						if (mSocket != null) {
							mSocket.close();
						}

						if (serverSocket != null) {
							serverSocket.close();
						}

					} catch (IOException e) {
						e.printStackTrace();
					}

				}
			}
		}.start();

	}
}
