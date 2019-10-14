package demo;

import static org.assertj.core.api.Assertions.assertThat;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class GetByIdDefs {
	
	String uri;
	HttpHeaders headers;
	RestTemplate restTemplate;
	ResponseEntity<String> response;

	@Given("^I Set GET_BY_ID employee service api endpoint$")
	public void setEndPoints() {

		uri = "http://localhost:8888/getProduct/";

	}

	@When("^Send a GET_BY_ID HTTP request with (\\d+) as Id$")
	public void sendGetRequest(int id) {

		headers = new HttpHeaders();
		headers.add("Accept", "application/json");
		headers.add("Content-Type", "application/json");

		this.restTemplate = new RestTemplate();
		this.response = this.restTemplate.getForEntity(uri + id, String.class);

	}

	@Then("^I receive status as 200 OK$")
	public void verifyGetResponse() {

		assertThat(response.getStatusCodeValue() == 200);

	}


}
