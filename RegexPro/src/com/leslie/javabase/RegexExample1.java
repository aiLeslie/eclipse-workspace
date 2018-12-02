package com.leslie.javabase;

import java.util.regex.Pattern;


public class RegexExample1 {
	public static void main(String args[]) {
		
		
		
		String content = "I am noob " + "from runoob.com.";

		String pattern = ".*runoob\\s.";
		
//		Pattern compile = Pattern.compile(pattern);
//		
//		Matcher matcher = compile.matcher(content);
//		
//		boolean find = matcher.matches();
//
		boolean isMatch = Pattern.matches(pattern, content);
		
		System.out.println("\"" + content + "\"\n\n" + "上面字符串中是否包含 \" "+ "runoob" + "\" 子字符串? \t" + isMatch);
	}
}
