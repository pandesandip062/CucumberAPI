Feature: getpartybyName
  Scenario: get member details by last name

    Given create a access token to access
    When user hit the user send the url3 "https://np-api.leaguedata.ca/int1/asapp-eapi/v1/"
    Then user should get all dtails related with that last name
