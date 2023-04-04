Feature: getpartybyName
  Scenario: get member details by last name

    Given create a access token to access
    When user hit the user send the url3 "https://np-api.leaguedata.ca/int1/asapp-eapi/v1/"
    Then user should get all details related with that last name
    Then validate the member id
    Then validate member first name & last name
    Then validate the member birth date
    Then validate the member contact address
    Then validate the member branch & close indicator value
    Then validate the status code for valid headers
    Then validate the status code for in-valid headers
