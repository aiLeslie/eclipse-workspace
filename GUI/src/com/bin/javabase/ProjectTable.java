package com.bin.javabase;

import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTable;

public class ProjectTable {
	public static void main(String[] args) {
		JFrame frame = new JFrame("project table");
		JTable table = new JTable(new MyTableModel());
		JScrollPane jScrollPane = new JScrollPane(table);
		frame.add(jScrollPane);
		frame.pack();
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setVisible(true);
		
	}
}
