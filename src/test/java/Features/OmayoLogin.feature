Feature: Login to omayo Application

Scenario Outline: User should only be able to login with valid credential
Given I visite to application website
When I enter Username as "<someusernames>" and Pasword as "<somepasswords>" into the fields
And I click on login button
Then User should be able to login based on "<expected>" login status 
Examples:
|someusernames|somepasswords|expected|
|arun|1234|failure|
|SeleniumByArun|Test143$|success|
|test|1234|failure|