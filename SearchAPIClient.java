package itunes;

import org.apache.http.Header;
import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.util.EntityUtils;

public class SearchAPIClient {

	public String search(String parameterkeyvalue) {
		DefaultHttpClient httpclient = new DefaultHttpClient();
		try {
			HttpGet getRequest = new HttpGet("https://itunes.apple.com/search?"
					+ parameterkeyvalue);
			HttpResponse httpResponse = httpclient.execute(getRequest);
			HttpEntity entity = httpResponse.getEntity();
			return EntityUtils.toString(entity);
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			httpclient.getConnectionManager().shutdown();
		}
		return null;
	}
}
