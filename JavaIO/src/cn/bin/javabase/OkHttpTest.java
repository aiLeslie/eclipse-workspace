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
	 * 向服务器获取数据
	 * 
	 * @param String url(要访问的网址)
	 * @return String content (服务器返回的内容)
	 * @throws IOException
	 */
	public static String stringBody(String url) throws IOException {
		Request request = new Request.Builder().url(url).build();

		Response response = client.newCall(request).execute();
		return response.body().string();
	}

	/**
	 * 获得输入流把内容读到字节数组并返回
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
	 * 向服务器提交数据
	 * 
	 * @param      url(要访问的网址)
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
