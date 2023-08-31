Feature: AddLoanBallonPayment

  Scenario: create ballon payment with approprite payload
    Given when user launch the url for addLoanBallonPayment "https://np-api.leaguedata.ca:443/int1/horizon-los-eapi/v1/"
    When post the payload of addLoan
    Then Validate the response body