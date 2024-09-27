@All
Feature: Login

  @Test1
  Scenario Outline: Successful login
    Given I am on the login page
    When I enter username <username> and password <password>
    Then I should see the dashboard page
    Examples:
      | username       | password     |
      | standard_user  | secret_sauce |

  @Test2
  Scenario Outline: Failed login
    Given I am on the login page
    When I enter invalid username <username> and password <password>
    Then I should see message "Username and password do not match any user in this service"
    Examples:
      | username       | password     |
      | standard_user  | secret_sauce1|

  @Test3
  Scenario Outline: Failed login
    Given I am on the login page
    When I click Login Button
    Then I should see message "Username is required"