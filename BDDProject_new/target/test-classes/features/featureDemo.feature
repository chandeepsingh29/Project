@MercuryLogin

Feature: Test Mercury Login

  Scenario Outline: Test Login
    Given Mercury Login page is open
    When User enters "<username>" and "<password>"
    Then Page "<page>" is displayed
    Examples:
      | username | password | page          |
      | mercury  | mercury1 | Sign-on       |
      | mercury  | mercury  | Find a Flight |

   # Scenario: Test login with valid credentials
    #  Given Mercury Login page is open
     # When User enters "mercury" and "mercury"
      #Then Page "Find a flight" is displayed

  Scenario: Find a Flight
    Given Page "Find a Flight" is displayed
    When User selects a "One Way" Trip from "Paris" to "Zurich" for "1" passanger(s) in "Business" Class of "Unified Airlines"
    And Clicks on continue button
    Then Page "Select a Flight" is displayed