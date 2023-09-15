Feature: Trello Board Operations

  Scenario: Create a board and cards, update one card randomly, delete cards and board
    Given I create a board on Trello
    And I create two cards on the board
    When I update one card randomly
    Then I delete the cards
    And I delete the board