package stepDefine;

import org.testng.Assert;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.RestAssured;
import io.restassured.http.Method;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class StepsM3 {
	RequestSpecification httpRequest;
	Response response;
	String userid;
	@Given("sets base url")
	public void sets_base_url() {
		RestAssured.baseURI ="https://gorest.co.in";
		httpRequest = RestAssured.given();
	}

	@When("sends get request  {string}")
	public void sends_get_request(String string) {
		 response = httpRequest.request(Method.GET, "public/v1/users");
	}

	@Then("it will give status code {int} for given {string}")
	public void it_will_give_status_code_for_given(Integer statuscode, String string) {
		int a=statuscode;
		Assert.assertEquals(response.getStatusCode(),a);
	}

	@When("sends post request {string},{string}, {string},{string} and {string}")
	public void sends_post_request_and(String name, String email, String gender, String status, String endpoint, Integer statuscode)  {
		httpRequest.header("Content-Type", "application/json");
		httpRequest.header("Authorization", "Bearer c138c963e288ff568e25647d7659ccb7c63a9d15ecfddd2c0be2ee77d7d03811").header("Content-Type","application/json");
		String details=" {\r\n"
				+ "            \"name\": \""+name+"\",\r\n"
				+ "            \"email\": \""+email+"\",\r\n"
				+ "            \"gender\": \""+gender+"\",\r\n"
				+ "            \"status\": \""+status+"\"\r\n"
				+ "        }";
		Response postdata = httpRequest.body(details).post(endpoint);
		postdata.prettyPrint();
		String id=postdata.getBody().asString();
		 userid=JsonPath.from(id).getString("data.id");
		System.out.println(userid);
	}

	@Then("it will add the values of {string},{string}, {string},{string} and {string} and give status code {int}")
	public void it_will_add_the_values_of_and_and_give_status_code(String string, String string2, String string3, String string4, String string5, Integer int1) {
	    System.out.println("details added");
	}

	@When("sends put request of {string},{string}, {string},{string} and user {string}")
	public void sends_put_request_of_and_user(String name, String email, String gender, String status, String endpoint, Integer statuscode) {
		String update=" {\r\n"
				+ "            \"name\": \""+name+"\",\r\n"
				+ "            \"email\": \""+email+"\",\r\n"
				+ "            \"gender\": \""+gender+"\",\r\n"
				+ "            \"status\": \""+status+"\"\r\n"
				+ "        }";
		httpRequest.header("Content-Type","application/json");
		System.out.println(userid);
		Response changeDetails = httpRequest.body(update).put(endpoint+userid);
		changeDetails.prettyPrint();
		int b=statuscode;
		Assert.assertEquals(b, changeDetails.getStatusCode());
	}

	@Then("it will update the values of user with {string},{string}, {string},{string} and {string} and give status code {int}")
	public void it_will_update_the_values_of_user_with_and_and_give_status_code(String string, String string2, String string3, String string4, String string5, Integer int1) {
	    System.out.println("details updated");
	}

	@When("sends delete endpoint with userID {string}")
	public void sends_delete_endpoint_with_user_id(String endpoint) {
		response = httpRequest.delete(endpoint+userid);
		
	}

	@Then("it will delete the records  {string} with {int}")
	public void it_will_delete_the_records_with(String endpoint, Integer statuscode) {
		int c=statuscode;
		Assert.assertEquals(c, response.getStatusCode());
	}

}
