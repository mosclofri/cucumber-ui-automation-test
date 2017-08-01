@activity
Feature: Activity
  As I user
  I would open new activities
  So that application

  Background:
    Given I am on 'Activity' screen

  @p1
  Scenario Outline: Set Left Title to <left_text> Right Title to <right_text>
    Given I am on 'Custom Title' screen
    When I set left title to '<left_text>' and right title to '<right_text>'
    Then left title should be '<left_text>' and right title should be '<right_text>'
    Examples:
      | left_text | right_text |
      | Left      | Right      |
      | Alex      | Adam       |
