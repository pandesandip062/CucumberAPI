Feature: Creating accounts
  Scenario: when api send all details required for account creation then account should create
    Given when we launch url "https://np-api.leaguedata.ca/int1/asapp-eapi/v1"
    Then sending all details required for acc creation
    Then validate for the acc creation