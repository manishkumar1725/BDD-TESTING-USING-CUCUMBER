Feature: Basic CRUD Operation

   Scenario: Add employee record
     Given I Set POST employee service api endpoint
     When Send a POST HTTP request
     Then I receive valid Response
     
     
  