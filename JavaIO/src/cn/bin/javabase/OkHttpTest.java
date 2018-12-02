package cn.bin.javabase;

import java.io.IOException;
import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.FormBody;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;

public class OkHttpTest {
	private static OkHttpClient client = new OkHttpClient();

	public static void main(String[] args) {

		try {
			System.out.println(stringBody("https://www.360.com"));

//			post("http://www.baidu.com", null);
		} catch (IOException e) {
			e.printStackTrace();
		}

	}

	/**
	 * ���������ȡ����
	 * 
	 * @param String url(Ҫ���ʵ���ַ)
	 * @return String content (���������ص�����)
	 * @throws IOException
	 */
	public static String stringBody(String url) throws IOException {
		Request request = new Request.Builder().url(url).build();

		Response response = client.newCall(request).execute();
		return response.body().string();
	}

	/**
	 * ��������������ݶ����ֽ����鲢����
	 * 
	 * @param InputStream in
	 * @return byte[] bytes
	 */
	public static byte[] getBytes(String url) throws IOException {

		Request request = new Request.Builder().url(url).build();

		Response response = client.newCall(request).execute();

		return response.body().bytes();

	}

	/**
	 * ��������ύ����
	 * 
	 * @param      url(Ҫ���ʵ���ַ)
	 * @param json
	 * @throws IOException
	 */
	public static void post(String url, String json) throws IOException {
		OkHttpClient client = new OkHttpClient();
		RequestBody formBody = new FormBody.Builder().add("name", "liming").add("school", "beida").build();

		Request request = new Request.Builder().url(url).post(formBody).build();

		Call call = client.newCall(request);
		call.enqueue(new Callback() {
			@Override
			public void onFailure(Call call, IOException e) {
				System.out.println(e.getMessage());
			}

			@Override
			public void onResponse(Call call, Response response) throws IOException {
				String str = response.body().string();
				System.out.println(str);

			}

		});
	}
}
