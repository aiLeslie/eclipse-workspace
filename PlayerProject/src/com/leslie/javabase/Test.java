package com.leslie.javabase;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.Scanner;

import javazoom.jl.decoder.JavaLayerException;
import javazoom.jl.player.Player;



public class Test {
	public static final String MUSIC_STORAGE = "D:/KuGou";
	public static final int NORMAL_EXIT = 0;
	public static final int FILE_NO_FOUND = -1;
	public static final int NEXT_MUSIC = 1;

	private static Scanner scanner;
	private static String input;

	public static synchronized void main(String[] args) {
		scanner = new Scanner(System.in);
		System.out.println("���ֲ�����");

		while (true) {
			if (playMusic() == NORMAL_EXIT)
				break;

		}

		scanner.close();

	}

	/**
	 * ѡ������
	 * 
	 * @return �����ļ�����
	 */
	private static synchronized File choiseMusic() {
		System.out.print("��������Ҫ��������: ");

		input = scanner.nextLine();

		if ("exit".equals(input)) {
			return null;
		} else if ("".equals(input)) {
			while ("".equals(input))
			input = scanner.nextLine();
		}
		File dir = new File(MUSIC_STORAGE);
		for (File file : dir.listFiles()) {
			if (file.getName().endsWith(input + ".mp3")) {
				return file;
			}
		}
		return new File(MUSIC_STORAGE, input);
	}

	public static int playMusic() {

		File file = choiseMusic();
		if (file == null) {
			System.out.println("�˳�����");
			System.exit(0);
			return NORMAL_EXIT;

		} else if (!file.exists()) {
			System.err.println("File NOT FOUND!");
			return FILE_NO_FOUND;
		}

		/**
		 * �����̲߳�������
		 */
//		new Thread() {
//			public void run() {
				InputStream in = null;
				try {
					in = new FileInputStream(file);
					Player palyer = new Player(in);
					System.out.println("���ڲ�������: " + file.getName());
					palyer.play();
					System.out.println("�Y������");
				} catch (FileNotFoundException | JavaLayerException e) {
					e.printStackTrace();
				} finally {
					try {
						if (in != null)
							in.close();
					} catch (IOException e) {
						e.printStackTrace();
					}

				}
//			}
//		}.start();
		return NEXT_MUSIC;

	}
}
