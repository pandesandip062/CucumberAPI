Feature: getPartybyId

  Scenario: get member details by member id

    Given create a access token to access
    When user hit the user send the url3 "https://np-api.leaguedata.ca/uat/asapp-eapi/v1"
    Then user should get all details related with that last name
    Then verify the taxId of member
    Then verify the taxIdType of firstName
    Then verify the taxIdType of lastName
    Then verify the taxIdType of birthDay
    Then verify the taxIdType of phoneNumber
