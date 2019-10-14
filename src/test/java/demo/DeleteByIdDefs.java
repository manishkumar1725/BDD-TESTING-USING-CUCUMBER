package demo;

import static org.assertj.core.api.Assertions.assertThat;

import java.net.URI;
import java.net.URISyntaxException;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.RequestEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class DeleteByIdDefs {

	String uri;
	HttpHeaders headers;
	RestTemplate restTemplate;
	ResponseEntity<Void> response;

	@Given("^I Set DELETE_BY_ID employee service api endpoint$")
	public void setEndPoints() {
		
		uri = "http://localhost:8888/deleteProduct/";
		
	}

	@When("^Send a DELETE_BY_ID HTTP request with (\\d+) as ID$")
	public void sendPostRequest(int id) throws URISyntaxException {

		headers = new HttpHeaders();
		headers.add("Accept", "application/json");
		headers.add("Content-Type", "application/json");
		
		RequestEntity<Void> request = RequestEntity.delete(new URI(uri + id)).build();

		this.restTemplate = new RestTemplate();
		this.response =this.restTemplate.exchange(request, Void.class);
	}

	@Then("^I receive NO Response$")
	public void verifyPostResponse() {

		assertThat(response.getStatusCode().equals(HttpStatus.NO_CONTENT));

	}

}
