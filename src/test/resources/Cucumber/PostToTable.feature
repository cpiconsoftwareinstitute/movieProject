Feature: I to want to post a new actor

  Scenario:Language is not Spanish
    Given I want to have a new actor
    When The user adds a new actor
    Then The actor is saved to the data base