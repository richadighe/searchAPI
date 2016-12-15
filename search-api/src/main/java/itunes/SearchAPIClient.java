package itunes;

import org.apache.http.*;
import org.apache.http.client.methods.*;
import org.apache.http.impl.client.*;
import org.apache.http.util.*;

public class SearchAPIClient {

	public String search(String parameterkeyvalue) {
		DefaultHttpClient httpclient = new DefaultHttpClient();
		try {
			HttpGet getRequest = new HttpGet("https://itunes.apple.com/search?" + parameterkeyvalue);
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
