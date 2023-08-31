Feature: PostParty

  Scenario: When user update the data it should update successfully
    Given generate access token
    When  user launches the url  "https://np-api.leaguedata.ca/int1/asapp-eapi"
    Then provide required data which needs to update
    Then user get the success message of records upated
    Then validate the status code for created which 201
