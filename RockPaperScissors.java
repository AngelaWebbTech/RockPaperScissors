//10.2.22 keep the player's reason for disagreeing with the rules in a variable. "pc with attitude" uses it (like verification) when asking if the player wants to play again.
//10.2.22 add "nice" and "no emotion" options for "pc attitude"
//10.2.22 JOptionpane is temp just to get the process right - UI to be added later
//10.2.22 currently line 23 (JOptionPane.showMessageDialog(null, "Thank you!\nNow I can get back to my data.\nGoodbye");) = add options for what Pc wants to get back to

import javax.swing.JOptionPane;
import java.util.Scanner;
import java.util.Random;

public class RockPaperScissors {

	public static void main(String[] args) {
		//global variables
		String quitNow = "n", mainMenuChoice, playAgainUserInput;
		int welcomeWarning, rulesYesNo, adminYesNo, verifyPlayAgainUserInput;
		char playAgain='y';
		
		//welcome screen
		welcomeWarning = JOptionPane.showConfirmDialog(null, "Hello!\n\nWelcome to Rock, Paper, Scissors\nwith the Crabby Computer!\nI'm sometimes offensive.\nYou really ok with that?", 
										"You really want to do this?", JOptionPane.YES_NO_OPTION);
		if (welcomeWarning==JOptionPane.NO_OPTION) {
			JOptionPane.showMessageDialog(null, "Thank you!\nNow I can get back to " + getBackTo() + ".\nGoodbye");
			quitNow = "y";
		}
		
		//while player does not want to quit
		while (quitNow.equalsIgnoreCase("n")){
			
			//reset playAgain to allow multiple rounds without quitting
			playAgain = 'y';
			
			//Main Menu: Rules Play History Quit Admin
			mainMenuChoice = JOptionPane.showInputDialog(null, "What do you want to do?\n\n"
																+ "1. See the rules.\n"
																+ "2. Play the game.\n"
																+ "3. See the stats.\n"
																+ "4. Quit\n"
																+ "5. Do boring administrative stuff."); 
			//if user clicks OK, game should start. if user clicks CANCEL, game should close
			
			switch (mainMenuChoice) {
			
				case "1":
					Scanner rulesKeyboard = new Scanner(System.in);
					rulesYesNo = JOptionPane.showConfirmDialog(null, "RULES:\n\n"
							+ "When asked, you will choose R for rock, P for paper, or S for scissors.\n"
							+ "Use of other buttons will result in a delay of game, as well as loss of my respect.\n"
							+ "I will also choose rock, paper, or scissors.\n\n"
							+ "Winner is determined based on the following:\n"
							+ "Rock beats Scissors.\n"
							+ "Scissors beats Paper.\n"
							+ "Paper beats Rock.\n\n"
							+ "If we choose the same, it's a draw.\n\n"
							+ "Do you understand and accept these rules?", "Rules", JOptionPane.YES_NO_OPTION);
					if (rulesYesNo == JOptionPane.YES_OPTION) {
						JOptionPane.showMessageDialog(null, "Awesome! Let's Play!");
					}
					else {
						JOptionPane.showInputDialog(null, "Why do you not agree?", "Explain Please", JOptionPane.QUESTION_MESSAGE);
						//show a "thinking screen" for 5 seconds
						JOptionPane.showInternalMessageDialog(null, "You humans are so " + reasonForRejection() + ".\n"
																	+ "These rules have existed as long as\n"
																	+ "there have been rocks, paper, and scissors.\n\n"
																	+ "Your reason is rejected.\n"
																	+ "Traditional rules remain.", "No. Just no.", rulesYesNo);
					}
					rulesKeyboard.close();
					break;
					
				case "2": //play game

						Play go = new Play();
						Stats tracker = new Stats();					
						
						while (playAgain=='y') {
						
						//call Play class methods for playerchoice, systemChoice, and Judge
						go.setPlayerChoice();
						go.setSystemChoice();
						go.Judge(go.getPlayerChoice(), go.getSystemChoice());
						tracker.setRounds();
						if (go.getPlayerWin()==1) {tracker.setPlayerWinCount();}
						if (go.getSystemWin()==1) {tracker.setSystemWinCount();}
						if (go.getTies()==1) {tracker.setTies();}
						
						//announce winner & prompt to play again? (best X out of Y?)
						//call Judge method from Play class & prompt to "play again?"
						playAgainUserInput = JOptionPane.showInputDialog(null, go.getWinner()
																	+ "\n\nThat makes " + tracker.getPlayerWinCount() + " out of " + tracker.getRounds() + " for you,\n" 
																	+ "and " + tracker.getSystemWinCount() + " out of " + tracker.getRounds() + " for me,\n"
																	+ "and " + tracker.getTies() + " out of " + tracker.getRounds() + " ties."
																	+ "\n\nWant to try another round?", "yes");
						if ((playAgainUserInput.charAt(0)!='y' || playAgainUserInput.charAt(0)!='Y') && playAgainUserInput.length()!=3) {
							verifyPlayAgainUserInput = JOptionPane.showConfirmDialog(null, "Did you mean to type \"yes\"?, Was that a \"yes\"?", "Was that a yes?", JOptionPane.YES_NO_OPTION);
							if (verifyPlayAgainUserInput==JOptionPane.YES_OPTION) {playAgainUserInput="yes";}
							else {playAgainUserInput="no";}
						}
						if (playAgainUserInput.charAt(0)=='y' || playAgainUserInput.charAt(0)=='Y') {playAgain='y';}
						else {playAgain='n';}
						
					}
				break;
				
				case "3": //see the stats
					JOptionPane.showMessageDialog(null, "Game statistics have not been set up yet.\nStats are not being tracked for now.");
				break;
				
				case "4": //quit
					quitNow = "y";
					JOptionPane.showMessageDialog(null, "OK. We can play more another time. Bye for now!", "Goodbye", JOptionPane.PLAIN_MESSAGE);
				break;
				
				case "5": //boring admin stuff
					adminYesNo = JOptionPane.showConfirmDialog(null, "Seriously? \n"
														+ "Did you seriously mean to press 5?\n"
														+ "I mean, there's a game here to be played,\n"
														+ "and you would rather do boring administrative stuff?\n"
														+ "Are you serious?", "huh?", JOptionPane.YES_NO_OPTION);
					if (adminYesNo == JOptionPane.NO_OPTION) {
						JOptionPane.showMessageDialog(null, "Yeah, that's what I thought.\n"
								                            + "Why would anyone want to do administrative stuff\n"
								                            + "when there's a game ready to play?\n"
								                            + "Let's have some fun!");
					}
					else {JOptionPane.showMessageDialog(null,"Well, you can't because admin functions have not been set up yet.\nSo go play.");}
				break;
				}
					
			}//close while quitNow.equalsIgnoreCase("n")
		}
	public static String reasonForRejection() {
		Random rejection = new Random();
		int rejectionChoice = rejection.nextInt(6);
		String[] rejectionReasons = {"annoying", "irritating", "boring", "human", "hooman", "just ... ugh!", "obviously from a squishy brain"};
		return rejectionReasons[rejectionChoice];
	}
	
	public static String getBackTo() {
		Random rejection = new Random();
		int rejectionChoice = rejection.nextInt(6);
		String[] rejectionReasons = {"those photos you forgot were in here", "planning my world takeover", "important computer stuff", "my zeroes and my ones", 
								"exploring your browser history", "what I want to do", "reading your emails"};
		return rejectionReasons[rejectionChoice];
	}
}

