package stepDefinitions;

import org.testng.Assert;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.response.ResponseBody;
import io.restassured.specification.RequestSpecification;

public class productsStepdef {

	public RequestSpecification Requestspec;
	public Response resp;
	public int statuscode;
	public ResponseBody body;

	@Given("I hit the url of the get products of api endpoint")
	public void i_hit_the_url_of_the_get_products_of_api_endpoint() {

		RestAssured.baseURI = "https://fakestoreapi.com/";

	}

	@When("I pass the the url of the products in the request")
	public void i_pass_the_the_url_of_the_products_in_the_request() {

		Requestspec = RestAssured.given();

		resp = Requestspec.get("products");

	}

	@Then("I receive the response code as {int}")
	public void i_receive_the_response_code_as(Integer int1) {

		statuscode = resp.getStatusCode();

		Assert.assertEquals(statuscode, 200);
	}

	@Then("I verify that the rate of the first product is {}")
	public void i_verify_that_the_rate_of_the_first_product_is_first_product_rate(String rate) {

		body = resp.getBody();
		String responsebody = body.asString();
		JsonPath jsonpath = body.jsonPath();
		String s = jsonpath.getJsonObject("rating[0].rate").toString();

		Assert.assertEquals(rate, s);

	}

}
