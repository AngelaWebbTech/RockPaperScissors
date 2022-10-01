//9.29.22 add more reasons for rejection to reasonForRejection method
//10.1.22 the winner announcement is a complete mess

import javax.swing.JOptionPane;
import java.util.Scanner;
import java.util.Random;

public class RockPaperScissors {

	public static void main(String[] args) {
		//global variables
		String playAgain = "y", quitNow = "n", mainMenuChoice, playerReason, playerChoice;
		int rulesYesNo, adminYesNo, systemChoice, rounds=0, playerChoseRock=0, systemChoseRock=0, playerChosePaper=0, systemChosePaper=0, playerChoseScissors=0, systemChoseScissors=0,
				ties=0, systemWins=0, playerWins=0;
		char winner;
		
		//welcome screen
		JOptionPane.showMessageDialog(null, "Hello!\n\nWelcome to Rock, Paper, Scissors!\n\nLet's Play!");
		
		//while player does not want to quit
		while (quitNow.equalsIgnoreCase("n")){
			
			//Main Menu: Rules Play History Quit Admin
			mainMenuChoice = JOptionPane.showInputDialog(null, "What do you want to do?\n\n"
												+ "1. See the rules.\n"
												+ "2. Play the game.\n"
												+ "3. See the stats.\n"
												+ "4. Quit\n"
												+ "5. Do boring administrative stuff.\n", "Main Menu", JOptionPane.QUESTION_MESSAGE);
			
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
						playerReason = JOptionPane.showInputDialog(null, "Why do you not agree?", "Explain Please", JOptionPane.QUESTION_MESSAGE);
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
					while (playAgain.equalsIgnoreCase("Y")) {
						//accumulate number of rounds 
						rounds++;
						
						//user chooses rps
						playerChoice = JOptionPane.showInputDialog(null, "Make your choice:\n"
																		+ "(R)ock, (P)aper, or (S)cissors?", "Choose!", JOptionPane.PLAIN_MESSAGE);
						//if player does not choose rps, or enters more than one letter, reprompt with funny message
						
						//system chooses rps
						Random systemPlay = new Random();
						systemChoice= systemPlay.nextInt(3);
						
						//compare user and system choices
						if (playerChoice.equalsIgnoreCase("R")){ //player chooses rock
							playerChoseRock++;
							if (systemChoice==0) { //system rock
								systemChoseRock++;
								winner = 't';
								ties++;
							}
							else if (systemChoice==1) { //system paper
								systemChosePaper++;
								winner='s';
								systemWins++;
							}
							else { //system scissors
								systemChoseScissors++;
								winner='p'; 
								playerWins++;
							}
						}
						else if (playerChoice.equalsIgnoreCase("P")){ //player chooses paper
							playerChosePaper++;
							if (systemChoice==0) { //system rock
								systemChoseRock++;
								winner = 'p';
							}
							else if (systemChoice==1) { //system paper
								systemChosePaper++;
								winner='t';
								ties++;
							}
							else { //system scissors
								systemChoseScissors++;
								winner='s'; 
								systemWins++;
							}
						}
						else { //player chooses scissors
							playerChoseScissors++;
							if (systemChoice==0) { //system rock
								systemChoseRock++;
								winner = 's';
							}
							else if (systemChoice==1) { //system paper
								systemChosePaper++;
								winner='p';
								playerWins++;
							}
							else { //system scissors
								systemChoseScissors++;
								winner='t'; 
								ties++;
							}
						}
											
						//announce winner & prompt to play again? (best X out of Y?)
						if (winner.equals('t')) {
							playAgain = JOptionPane.showInputDialog(null, "It's a tie!\n"
																			+ "You both chose the same!\n\n" 
																			+ "You have won " + playerWins + " out of " + rounds + "!\n"
																			+ "Want to try another round?", "Play Again?", JOptionPane.PLAIN_MESSAGE)
						}
						
						if (winner.equals('p')) {
							playAgain = JOptionPane.showInputDialog(null, "You win!\n"
																			+ playerChoice + " beats " + systemChoice + "!\n\n" 
																			+ "You have won " + playerWins + " out of " + rounds + "!\n"
																			+ "Want to try another round?", "Play Again?", JOptionPane.PLAIN_MESSAGE)
						}
					}
				break;
				
				case "3": //see the stats
					System.out.println("Game statistics have not been set up yet");
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
								                            + "Let's have some more fun!", "OK", JOptionPane.PLAIN_MESSAGE);
					}
					else {System.out.println("Administrative functions have not been set up yet.");}
				break;
				}
					
			}//close while quitNow.equalsIgnoreCase("n")
		}
	public static String reasonForRejection() {
		Random rejection = new Random();
		int rejectionChoice = rejection.nextInt(5);
		String[] rejectionReasons = {"annoying", "irritating", "boring", "human", "hooman", "just ... ugh!"};
		return rejectionReasons[rejectionChoice];
	}
}

