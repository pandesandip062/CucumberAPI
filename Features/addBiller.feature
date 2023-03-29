Feature: addBiller

  Scenario: post biller details succefully
    Given when user launch the url "https://np-api.leaguedata.ca/int1/forge-eapi/v1"
    Then post the payload
    Then post the response and validate the body

    Then api should return the response value

    Example:
      |vendorId| |vendorMemberAccount| |nickname|
      |110| |0000901220| |rushi1vendorId|
