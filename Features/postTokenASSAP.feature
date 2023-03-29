Feature: postTokenASAAP

  Scenario: post token details succesfully for ASAAP
    Given when launch the url1 "https://np-api.leaguedata.ca:443/uat/asapp-eapi/v1"
    Then api should return the token value with endpoint url2 "/oauth/token"