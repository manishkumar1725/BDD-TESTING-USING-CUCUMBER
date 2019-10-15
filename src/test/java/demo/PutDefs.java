package demo;

import static org.assertj.core.api.Assertions.assertThat;

import java.net.URI;
import java.net.URISyntaxException;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.RequestEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

import com.example.cucumber_bdd.Product;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class PutDefs {
	
	String uri;
	HttpHeaders headers;
	RestTemplate restTemplate;
	ResponseEntity<String> response;

	@Given("^I Set PUT_BY_ID employee service api endpoint$")
	public void setEndPoints() {
		
		uri = "http://localhost:8888/updateProduct/";
		
	}

	@When("^Send a PUT_BY_ID HTTP request with (\\d+) as ID$")
	public void sendPutRequest(int id) throws URISyntaxException {

		headers = new HttpHeaders();
		headers.add("Accept", "application/json");
		headers.add("Content-Type", "application/json");
		
		String object = "{\"id\":6,\"name\":\"manish1\"}";
		
		//RequestEntity is Extension of HttpEntity that adds a method and uri
		
		RequestEntity<String> request = RequestEntity.put(new URI(uri + id)).contentType(MediaType.APPLICATION_JSON).body(object);

		this.restTemplate = new RestTemplate();
		this.response =this.restTemplate.exchange(request, String.class);
	}

	@Then("^I receive content type as text/plain;charset=UTF-8$")
	public void verifyPutResponse() {

		assertThat(response.getStatusCode().equals(HttpStatus.CREATED));

	}

}
