Feature: BookingSystem Automated Tests
Description: This test suite will test the new filters added to the booking portal

Scenario: Filter by is selected as sauna in the booking.com website
		 Given user is on booking.com page
		 When search by location is entered as "Limerick"
		 And Dates entered is One night stay (3 months from today’s date) 
		 And Number of People is 2 adults
		 And Room: 1 Room
		 And Search is performed
		 And Filter by selected as Sauna
		 Then Limerick Strand Hotel should be Listed and George Limerick Hotel should not be Listed

Scenario: Filter by i selected as 5 star in the booking.com website
		Given user is on booking.com page
		 When search by location is entered as "Limerick"
		 And Dates entered is One night stay (3 months from today’s date) 
		 And Number of People is 2 adults
		 And Room: 1 Room
		 And Filter by selected as 5 star
		 Then The Savoy Hotel should be Listed and George Limerick Hotel should not be Listed 
		 
		 