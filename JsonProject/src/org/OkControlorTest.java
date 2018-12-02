package org;

import com.leslie.javabase.OkControlor;
import com.leslie.javabase.OkControlor.StrHandler;

public class OkControlorTest {
	public static void main(String[] args) {
		String rightUrl = "http://www.baidu.com";
		String errorUrl = "http://www.bi.com";
		
		OkControlor okControl = new OkControlor();
		/**
		 * ����ֽ���������
		 */
//		okControl.bytesBodyAsync(rightUrl, new ByteHandler() {
//
//			@Override
//			public void onSucceed(byte[] body) {
//				System.out.println(new String(body));
//
//			}
//
//			@Override
//			public void onError() {
//				System.out.println("onError()");
//
//			}
//		});

		/**
		 * ����ַ�������
		 */
		okControl.stringBodyAsync(rightUrl, new StrHandler() {

			@Override
			public void onSucceed(String body) {
				System.out.println(new String(body));

			}

			@Override
			public void onError() {
				System.out.println("onError()");

			}
		});
		
		okControl.stringBodyAsync(errorUrl, new StrHandler() {

			@Override
			public void onSucceed(String body) {
				System.out.println(new String(body));

			}

			@Override
			public void onError() {
				System.out.println("onError()");

			}
		});

	}
}
