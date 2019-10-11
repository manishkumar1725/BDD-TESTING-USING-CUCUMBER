package demo;

import static org.assertj.core.api.Assertions.assertThat;

import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

import com.example.cucumber_bdd.Product;

import cucumber.api.PendingException;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class GetDefs {
	

	String uri;
	HttpHeaders headers;
	RestTemplate restTemplate;
	ResponseEntity<String> response;

	@Given("^I Set GET employee service api endpoint$")
	public void setEndPoints() {
		uri = "http://localhost:8888/getAllProduct";
	}

	@When("^Send a GET HTTP request$")
	public void sendPostRequest() {

		headers = new HttpHeaders();
		headers.add("Accept", "application/json");
		headers.add("Content-Type", "application/json");

		this.restTemplate = new RestTemplate();
		this.response = this.restTemplate.getForEntity(uri,String.class);
		
	
	}

	@Then("^I receive content type as application/json;charset=UTF-8$")
	public void verifyPostResponse() {

		assertThat(response.getHeaders().getContentType().equals("application/json;charset=UTF-8"));
		

	}


}
