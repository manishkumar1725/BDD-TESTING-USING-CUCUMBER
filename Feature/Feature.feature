Feature: Basic CRUD Operation
     
   Scenario: GET employee record
     Given I Set GET employee service api endpoint
     When Send a GET HTTP request
     Then I receive content type as application/json;charset=UTF-8
     
   Scenario: POST employee record
     Given I Set POST employee service api endpoint
     When Send a POST HTTP request
     Then I receive valid Response
     
     
     
   
     
  