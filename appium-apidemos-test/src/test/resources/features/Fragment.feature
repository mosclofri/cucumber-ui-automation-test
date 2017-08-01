@fragment
Feature: Fragment
  As I user
  I would open control fragments
  So that the application can show fragment

  Background:
    Given I am on 'Fragment' screen

  @p1
  Scenario: Long press button
    Given I am on 'Context Menu' screen
    When I long press 'Long Press Me' button
    Then a new pop fragment with 2 item should be displayed

  @p2
  Scenario: Long press button
    Given I am on 'Context Menu' screen
    When I short press 'Long Press Me' button
    Then I should stay on 'Context Menu' screen

  @p1
  Scenario: Hide fragments
    Given I am on 'Hide And Show' screen
    When click hide for both fragments
    Then both fragments should disappear
