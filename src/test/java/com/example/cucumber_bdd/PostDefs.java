package com.example.cucumber_bdd;

import static org.assertj.core.api.Assertions.assertThat;

import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class PostDefs {
	
	String uri;
	HttpHeaders headers;
	RestTemplate restTemplate;
	ResponseEntity<String> response;

	@Given("^I Set POST employee service api endpoint$")
	public void setEndPoints() {
		uri = "http://localhost:8888/addProduct";
	}

	@When("^Send a POST HTTP request$")
	public void sendPostRequest() {

		headers = new HttpHeaders();
		headers.add("Accept", "application/json");
		headers.add("Content-Type", "application/json");

		String body = "{\"id\":9,\"name\":\"manish1\"}";

		HttpEntity<String> entity = new HttpEntity<String>(body, headers);

		this.restTemplate = new RestTemplate();
		this.response = this.restTemplate.postForEntity(uri, entity, String.class);

	}

	@Then("^I receive valid Response$")
	public void verifyPostResponse() {

		assertThat(response.getStatusCode().equals(HttpStatus.OK));

	}

}

//ResponseEntity represents an HTTP response, including headers, body, and status. 
//While @ResponseBody puts the return value into the body of the response, 
//ResponseEntity also allows us to add headers and status code.


