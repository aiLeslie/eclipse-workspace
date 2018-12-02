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
 * 项目名称：JsonProject 类名称：DownPic 类描述： 创建人：李玮斌 创建时间：2018年8月27日 下午4:46:12
 * 
 * @version 1.0
 */

public class DownPic {
	/**
	 * 用的是接口是：http://gank.io/api/data/福利/{请求个数}/{第几页}
	 * 例如：每页显示10个，第一页：http://gank.io/api/data/福利/10/1
	 */
	private static String RES_PATH = "./res";

	private static final int COUNT = 10;
	private static final int PAGE = 1;
	private static OkControlor client = new OkControlor();

	public static void main(String[] args) {

		client.stringBodyAsync("http://gank.io/api/data/福利/" + COUNT + "/" + PAGE, new StrHandler() {

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
			
			// 图片名字
			// 获得图片名字
			final String name = url.substring(url.lastIndexOf("/") + 1);
			

			// 获得图片数据
			client.bytesBodyAsync(url, new ByteHandler() {

				@Override
				public void onSucceed(byte[] body) {

					// 字节输出流
					OutputStream out = null;

					// 文件对象
					File file = null;

					// 实例化文件对象
					file = new File(RES_PATH, name);
					// 实例化输出流
					try {
						out = new FileOutputStream(file);
						// 写入内容
						out.write(body, 0, body.length);
						
						System.out.println("Download  " + name + "  successful");

					} catch (FileNotFoundException e) {
						e.printStackTrace();
					} catch (IOException e) {
						e.printStackTrace();
					} finally {
						if (out != null) {
							try {
								// 关闭输出流
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
