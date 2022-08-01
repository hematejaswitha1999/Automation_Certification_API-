#Author: your.email@your.domain.com
#Keywords Summary :
#Feature: List of scenarios.
#Scenario: Business rule through list of steps with arguments.
#Given: Some precondition step
#When: Some key actions
#Then: To observe outcomes or validation
#And,But: To enumerate more Given,When,Then steps
#Scenario Outline: List of steps for data-driven as an Examples and <placeholder>
#Examples: Container for s table
#Background: List of steps run before each of the scenarios
#""" (Doc Strings)
#| (Data Tables)
#@ (Tags/Labels):To group Scenarios
#<> (placeholder)
#""
## (Comments)
#Sample Feature Definition Template
Feature: testing  gorest api
Scenario Outline: get the data of the user
Given sets base url
When sends get request  "<endpoint>"
Then it will give status code <statuscode> for given "<endpoint>"
Examples:
    | endpoint                | statuscode |
    |/public/v1/users         | 200			   |
    |/public/v1/users/17      | 200	       |
    
Scenario Outline: inserting the data of the user
Given sets base url
When sends post request "<name>","<email>", "<gender>","<status>" and "<endpoint>"
Then it will add the values of "<name>","<email>", "<gender>","<status>" and "<endpoint>" and give status code <statuscode>
Examples:
    | name     | email              |gender|status |statuscode|endpoint          |
    |sai       |saisiva@gmail.com	  | male |active |201			  |/public/v1/users  |
    |sravs     | sravss@gmail.com   |female|active |201       |/public/v1/users  |
    
  
Scenario Outline: update the data of the user
Given sets base url
When sends put request of "<name>","<email>", "<gender>","<status>" and user "<endpoint>"
Then it will update the values of user with "<name>","<email>", "<gender>","<status>" and "<endpoint>" and give status code <statuscode>
Examples:
    | name      | email              |gender|status |statuscode|endpoint            |
    |ravi       |ravi@gmail.com		   | male |active |200			 |/public/v1/users/   |
    |rani       | rani2@gmail.com    |female|active |200       |/public/v1/users/   |
    
    
Scenario Outline: delete the data from users
Given sets base url
When sends delete endpoint with userID "<endpoint>"
Then it will delete the records  "<endpoint>" with <statuscode>
Examples:
    | endpoint            |statuscode|
    |/public/v1/users/    |204       |
   
         
  