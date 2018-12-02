package cn.bin.javabase;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

public class NetWorkTest {
	public static void main(String[] args) {
		HttpURLConnection urlConnection = null;
        BufferedReader bufferedReader = null;

        try {
            URL url = new URL("http://ghost.25pp.com/soft/pppc_setup/wandoujia_3.0.0.3003_25pp_wdjgw_1502264586_setup.exe");
            //URL url = new URL("http://www."+ ((EditText) findViewById(R.id.urlText)).getText().toString()+".com");
            urlConnection = (HttpURLConnection) url.openConnection();
            urlConnection.setRequestMethod("GET");
            urlConnection.setConnectTimeout(8000);
            urlConnection.setReadTimeout(8000);
            InputStream in = urlConnection.getInputStream();
            bufferedReader = new BufferedReader(new InputStreamReader(in));
            StringBuilder builder = new StringBuilder();
            String line = null;
            while((line = bufferedReader.readLine()) != null){
                builder.append(line);
                builder.append(System.getProperties().getProperty("line.separator"));
            }
            System.out.println(builder.toString());

        } catch (IOException e) {
            e.printStackTrace();
        }finally {
            try {
                if (bufferedReader != null) bufferedReader.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
            if(urlConnection != null)urlConnection.disconnect();
        }
	}

}
