Feature: Payment

  Scenario: Send a valid payment
    Given a valid recipient email "test@example.com"
    And a valid amount 10.0
    And a supported currency "USD"
    When I send the payment
    Then the payment should be successful

  Scenario: Fetch transactions
    When I fetch all transactions
    Then I should get a non-empty list
