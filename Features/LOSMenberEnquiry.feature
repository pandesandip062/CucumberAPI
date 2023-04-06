Feature: MemberProfileEnquiry
  Scenario: when member search with memberID is should show all details of member
    When user hits the url "https://np-api.leaguedata.ca:443/int1/horizon-los-eapi/v1/"
    Then user should get all details related with memberID
    Then validate memberid
    Then validate branchNumber
    Then validate members FirstName, MiddleName & LastName
    Then validate mambers sex,status & DOB
    Then validate members Contact Details
    Then validate members Address Details
    Then validate memebrs empoccuptaion
    Then validate for invalidHeaders




