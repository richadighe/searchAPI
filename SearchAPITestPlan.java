package itunes;

import org.junit.Assert;
import org.junit.Test;

public class SearchAPITestPlan {

	// I have put in very basic validations in the tests below.
	
	@Test
	public void testNoParamtersPassed() {
		String response = new SearchAPIClient().search("");
		Assert.assertNotNull(response);
		Assert.assertTrue(response.contains("resultCount\":0"));
		Assert.assertTrue(response.contains("results\": []"));
	}

	@Test
	public void testCountryOnly() {
		String response = new SearchAPIClient().search("country=GB");
		Assert.assertNotNull(response);
		Assert.assertTrue(response.contains("resultCount\":0"));
		Assert.assertTrue(response.contains("results\": []"));
	}

	@Test
	public void testTermOnly() {
		String response = new SearchAPIClient().search("term=Jack");
		Assert.assertNotNull(response);
		Assert.assertFalse(response.contains("resultCount\":0"));
		Assert.assertFalse(response.contains("results\": []"));
	}

	@Test
	public void testAllParameters() {
		String response = new SearchAPIClient().search("term=Jack&country=GB&media=movie&limit=1");
		Assert.assertNotNull(response);
		Assert.assertFalse(response.contains("resultCount\":0"));
		Assert.assertFalse(response.contains("results\": []"));
	}
}