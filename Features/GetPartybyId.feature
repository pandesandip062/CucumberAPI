Feature: GetPartybyId

  Scenario: When user serch by Id all details needs to fetch successfully

    Given generate access token
    When user launch the url "https://np-api.leaguedata.ca/int1/asapp-eapi/"
    Then user should get all edtails realtd to that id
