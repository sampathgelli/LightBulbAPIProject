@Smoke
Feature: I want to turn on and off my light
  As a user turn on and off my light api
  I want to Switch on and Switch off buld
  So that I use light when it is required

  @Success
  Scenario Outline: Successful Scenario for light on and off
    Given lightbulb application url
    When user request to switch "<state>"
    Then I should get response "<statuscode>"
    And Result should be "<Result>"

  @prod
    Examples: Valid Data
      | state | statuscode | Result                  |
      | on    | 200        | Switch set successfully |
      | off   | 200        | Switch set successfully |
      | off   | 200        | Switch set successfully |

  @Power
  Scenario Outline: Unsuccessful Scenario for light on and off
    Given lightbulb application url
    When user request to switch "<state>" and power as "<power>"
    Then I should get response "<statuscode>"
    And Result should be "<Result>"

  @SIT
    Examples: Valid Data
      | state | statuscode | Result                                 | power |
      | on    | 200        | Switch & custom power set successfully | 10    |
      | on    | 200        | Switch & custom power set successfully | 60    |
      | on    | 200        | Switch & custom power set successfully | 20    |
      | on    | 200        | Switch & custom power set successfully | -50   |