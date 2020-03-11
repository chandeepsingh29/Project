@BookAFlightTicket
Feature: Book a Flight Ticket

As a user on Mercury Tours
I want to login
Because I want to book a flight ticket
and display the price

Scenario: User should be able to login and book tickets

Given User is on the Mercury Tours Page
When User enters valid UserName and Password
And Click the SignIn Button
Then "Find a Flight" Page is displayed
When User selects flight details
And Clicks on FindFlight button
Then "Select a Flight" Page is displayed
When User clicks on ReserveFlight button
Then "Book a Flight" Page is displayed
When User clicks on BuyFlight button
Then "Flight Confirmation" Page is displayed
And Ticket Price should be displayed