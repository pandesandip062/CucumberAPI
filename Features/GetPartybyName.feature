Feature: getpartybyName
  Scenario: get member details by last name

    When user hit the user send the url for getpartybyName "https://np-api.leaguedata.ca:443/uat/asapp-eapi/v1"
    Then user get all details related with that last name
    Then validate the member id
    Then validate member first name & last name
    Then validate the member birth date
    Then validate the member contact address
    Then validate the member branch & close indicator value
    Then validate the status code for valid headers
    Then validate the status code for in-valid headers
