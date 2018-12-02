package pic;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;

import org.JSONArray;
import org.JSONObject;

import com.leslie.javabase.OkControlor;
import com.leslie.javabase.OkControlor.ByteHandler;
import com.leslie.javabase.OkControlor.StrHandler;

/**
 * 
 * ��Ŀ���ƣ�JsonProject �����ƣ�DownPic �������� �����ˣ������ ����ʱ�䣺2018��8��27�� ����4:46:12
 * 
 * @version 1.0
 */

public class DownPic {
	/**
	 * �õ��ǽӿ��ǣ�http://gank.io/api/data/����/{�������}/{�ڼ�ҳ}
	 * ���磺ÿҳ��ʾ10������һҳ��http://gank.io/api/data/����/10/1
	 */
	private static String RES_PATH = "./res";

	private static final int COUNT = 10;
	private static final int PAGE = 1;
	private static OkControlor client = new OkControlor();

	public static void main(String[] args) {

		client.stringBodyAsync("http://gank.io/api/data/����/" + COUNT + "/" + PAGE, new StrHandler() {

			@Override
			public void onSucceed(String body) {
				System.out.println(body);
				String[] urls = parseObjForURL(body);
				download(urls);

			}

			@Override
			public void onError() {
				// TODO Auto-generated method stub

			}
		});

	}

	private static String[] parseObjForURL(String body) {
		String[] urls = new String[COUNT];

		JSONObject obj = new JSONObject(body);
		JSONArray array = obj.getJSONArray("results");

		for (int i = 0; i < COUNT; i++) {
			obj = (JSONObject) array.get(i);
//			System.out.println(obj.getString("url"));
			urls[i] = obj.getString("url");
		}
		return urls;
	}

	private static void download(String[] urls) {
		
		for (String url : urls) {
			
			// ͼƬ����
			// ���ͼƬ����
			final String name = url.substring(url.lastIndexOf("/") + 1);
			

			// ���ͼƬ����
			client.bytesBodyAsync(url, new ByteHandler() {

				@Override
				public void onSucceed(byte[] body) {

					// �ֽ������
					OutputStream out = null;

					// �ļ�����
					File file = null;

					// ʵ�����ļ�����
					file = new File(RES_PATH, name);
					// ʵ���������
					try {
						out = new FileOutputStream(file);
						// д������
						out.write(body, 0, body.length);
						
						System.out.println("Download  " + name + "  successful");

					} catch (FileNotFoundException e) {
						e.printStackTrace();
					} catch (IOException e) {
						e.printStackTrace();
					} finally {
						if (out != null) {
							try {
								// �ر������
								out.close();
							} catch (IOException e) {
								e.printStackTrace();
							}
						}
					}

				}

				@Override
				public void onError() {
					System.out.println("Download  " + name + "  failed");

				}
			});

		}
	}

}
