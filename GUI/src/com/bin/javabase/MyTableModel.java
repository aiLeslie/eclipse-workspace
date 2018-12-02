package com.bin.javabase;

import javax.swing.event.TableModelListener;
import javax.swing.table.TableModel;

public class MyTableModel implements TableModel{
	public MyTableModel() {
		for(int i = 0 ; i < 8 ; i++)
			for (int j = 0; j < 7 ; j++)
				projects[i][j] = "";
	}
	private String[][] projects = new String[8][7];
	{
		for(int i = 0 ; i < 8 ; i++)
			for (int j = 0; j < 7 ; j++)
				projects[i][j] = "";
	}
	private String[] title = new String[]{"星期一","星期二","星期三","星期四","星期五",};
	@Override
	public int getRowCount() {
		return 8;
	}

	@Override
	public int getColumnCount() {
		return 5;
	}

	@Override
	public String getColumnName(int columnIndex) {
		return title[columnIndex];
	}

	@Override
	public Class<?> getColumnClass(int columnIndex) {
		return String.class;
	}

	@Override
	public boolean isCellEditable(int rowIndex, int columnIndex) {
		return true;
	}

	@Override
	public Object getValueAt(int rowIndex, int columnIndex) {
		return projects[rowIndex][columnIndex];
	}

	@Override
	public void setValueAt(Object aValue, int rowIndex, int columnIndex) {
		projects[rowIndex][columnIndex] = (String)aValue;
		
	}

	@Override
	public void addTableModelListener(TableModelListener l) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void removeTableModelListener(TableModelListener l) {
		// TODO Auto-generated method stub
		
	}
	

}