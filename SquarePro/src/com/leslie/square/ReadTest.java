package com.leslie.square;

import java.io.File;
import java.io.IOException;
import java.nio.charset.Charset;

import okio.BufferedSource;
import okio.Okio;
import okio.Source;

public class ReadTest {
	public static void main(String[] args) throws IOException {
		readLines(new File("./read.xml"));
	}
	
	public static void readLines(File file) throws IOException {
		  try (Source fileSource = Okio.source(file);
				  
				  
				 
		       BufferedSource bufferedSource = Okio.buffer(fileSource)) {
			  int i = 100;

		    while (i-- != 0) {
		    	
		      String line = bufferedSource.readString(Charset.forName("utf-8"));
		      
		      if ("".equals(line)) break;
		      System.out.println(line);
		      
		    }

		  }
		}
}
