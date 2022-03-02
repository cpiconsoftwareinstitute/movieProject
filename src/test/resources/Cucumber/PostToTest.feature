Feature: Add a new data
  AS A user
  I WANT TO add date to my Data Base
  SO THAT I can use see them in the future

  Scenario: This Language is not in the list
    Given I want to add a new language
    When A new language was added
    Then The language should turn out in the language list and return save

  Scenario: This actor is not in the actor list
    Given I want to add a new Actor
    When A new Actor is now in the List
    Then The Actor should turn out in the Actor list and return save


