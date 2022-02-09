Feature: Is it in Spanish?
  People want to know if it is Spanish
  Scenario:Language is not Spanish
  Given I have chosen a film
  When Film is not in "Spanish"
  Then it says is not in Spanish

