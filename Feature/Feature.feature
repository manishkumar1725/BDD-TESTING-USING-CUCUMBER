Feature: Basic CRUD Operation
   
   Scenario: GET_ALL employee record
     Given I Set GET employee service api endpoint
     When Send a GET HTTP request
     Then I receive content type as application/json;charset=UTF-8
     
   Scenario: GET_BY_ID employee record
     Given I Set GET_BY_ID employee service api endpoint
     When Send a GET_BY_ID HTTP request with 1 as Id
     Then I receive status as 200 OK
     
   Scenario: POST employee record
     Given I Set POST employee service api endpoint
     When Send a POST HTTP request
     Then I receive valid Response
     
   Scenario: DELETE_BY_ID employee record
     Given I Set DELETE_BY_ID employee service api endpoint
     When Send a DELETE_BY_ID HTTP request with 8 as ID
     Then I receive NO Response
     
   Scenario: PUT_BY_ID employee record
     Given I Set PUT_BY_ID employee service api endpoint
     When Send a PUT_BY_ID HTTP request with 6 as ID
     Then I receive content type as text/plain;charset=UTF-8
     
     
     
   
     
  