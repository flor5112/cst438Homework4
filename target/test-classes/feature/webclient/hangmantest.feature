Feature: Hangman web app 
	As user I want to be able to play hangman so I can have an interactive guessing game. 

	Scenario: I enter a letter in the word to be guess
		Given I am in the hangman page 
		When I enter letter h
		Then I see the letter h appears on the guess word spot 

	