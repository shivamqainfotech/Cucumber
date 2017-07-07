#Author: shivambharadwaj@qainfotech.com

#Scenario Outline: List of steps for data-driven as an Examples and <placeholder>

#Background: List of steps run before each of the scenarios
#""" (Doc Strings)
#| (Data Tables)
#@ (Tags/Labels):To group Scenarios 
#<> (placeholder)
#""
## (Comments)

#Sample Feature Definition Template
@tag
Feature: Twitter Login and Feed Test
	Description: This feature will test a LogIn and feed functionality

@tag1
Scenario:  Successful Login with Valid Credentials and open selected feed
Given I am on twitter home page
	
When I nevigate to LogIn page 
	And I enters valid username and password
	
Then page should be updated with feeds
	And feed number four should be selected

