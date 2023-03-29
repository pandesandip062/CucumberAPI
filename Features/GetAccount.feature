Feature: GetAccount

  Scenario: Get accounts details succefully
    Given when launch the url "https://np-api.leaguedata.ca/int1/forge-eapi/v1/accounts"
    Then api should return the response value
