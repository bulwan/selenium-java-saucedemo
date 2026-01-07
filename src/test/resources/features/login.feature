Feature: Login
  As an user I should be able to log in using username and password to have access to all products.

  Scenario: Successful login
    When I log in as "standard_user"
    Then I should be redirected to the products page

  Scenario: Unsuccessful login - wrong data
    When I log in as "user123"
    Then I should see "Epic sadface: Username and password do not match any user in this service" message

  Scenario: Unsuccessful login - locked out user
    When I log in as "locked_out_user"
    Then I should see "Epic sadface: Sorry, this user has been locked out." message