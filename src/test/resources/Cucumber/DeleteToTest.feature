Feature: Read the Data
  AS A user
  I WANT TO delete a set of data from the Data Base
  SO THAT I can see the data is not in the list anymore

  Scenario: A language is still displayed in the screen
    Given I want to delete a language
    When I introduce an id and I press the delete button
    Then The data is not in the data base anymore