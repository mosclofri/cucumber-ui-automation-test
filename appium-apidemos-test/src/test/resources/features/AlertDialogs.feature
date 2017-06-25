Feature: Alert Dialogs
  As I user
  I would like to set alert
  So that the application can send alerts

  Background:
    Given I am on 'Alert Dialogs' screen

  Scenario: Repeat Alarm for all days
    Given I am on 'Repeat Alarm' screen
    When I check all days for alarm
    Then all days should be checked for alarm

  @ignore
  Scenario: Repeat Alarm for only week days
    Given I am on 'Repeat Alarm' screen
    When I check all week days for alarm
    Then week days should be checked for alarm