//add code to validate misspellings by asking the user "did you mean "rock"?" if yes assign variable, if no display "pc with attitude" comment & reprompt
//does playerInputAttemptCount<6 need to be in line 21? If playerInputAttemptCount=5 causes game to exit, this seems like unecessary code

import java.util.Random;
import javax.swing.JOptionPane;

public class Play {
	
	private String playerChoiceInput, playerChoice, systemChoice, winner;
	int systemChoiceInt, playerWin, systemWin, ties, playerInputAttemptCount;
	private char playerChoiceInputChar;
	
	//user chooses rps
	public void setPlayerChoice() {
			playerChoiceInput = JOptionPane.showInputDialog(null, "Make your choice:\n" + "(R)ock, (P)aper, or (S)cissors?", "Choose!", JOptionPane.PLAIN_MESSAGE);
			playerChoiceInputChar = playerChoiceInput.toLowerCase().charAt(0);
			playerInputAttemptCount=1; //reset at beginning of each round
			
			//if player does not choose rps, or enters more than one letter, reprompt with funny message			
			while ((playerChoiceInputChar!='r' && playerChoiceInputChar!='p' && playerChoiceInputChar!='s') && playerInputAttemptCount<5) {
				
				//1st, 2nd, 3rd time - call badInput(playerChoiceInput, playerInputAttemptCount) function. reprompt
				if (playerInputAttemptCount<=3) {
					playerChoiceInput = JOptionPane.showInputDialog(null, badInput(playerChoiceInput, playerInputAttemptCount) 
																	+ "\n\nChoose one of the following:\n" + "(R)ock, (P)aper, or (S)cissors?", 
																	"Oops! Try again.", JOptionPane.PLAIN_MESSAGE);
					playerChoiceInputChar = playerChoiceInput.toLowerCase().charAt(0);
					
					playerInputAttemptCount++;
				}
				//fourth time - call badInput(playerChoiceInput, playerInputAttemptCount) function. (this may end the game)
				else if (playerInputAttemptCount==4) {
					//pc complains, with offer to quit
					int playOrExit = JOptionPane.showConfirmDialog(null, "You can't be serious.\nYou have to be doing this on purpose.\nWhy do you ask to play a game, and then not play?\n" 
							    + "I am not here for this.\nThis is a game. Do you want to play the game?", "Why?!", 
							    JOptionPane.YES_NO_OPTION);
					//if user chooses to quit
					if (playOrExit==JOptionPane.NO_OPTION) {
						playerChoiceInput = "exit";
						JOptionPane.showMessageDialog(null, "Maybe we can play another time.\nGoodbye", "goodbye", JOptionPane.INFORMATION_MESSAGE);
						playerInputAttemptCount++;
					}
					
					//if user chooses to continue playing
					else {
						playerChoiceInput = JOptionPane.showInputDialog(null, badInput(playerChoiceInput, playerInputAttemptCount) + "\n\nChoose one of the following:\n" + "(R)ock, (P)aper, "
								+ "or (S)cissors?", "Seriously?", JOptionPane.PLAIN_MESSAGE);
						playerInputAttemptCount++;
					}
					playerChoiceInputChar = playerChoiceInput.toLowerCase().charAt(0);
				}
				//fifth time - call badInput(playerChoiceInput, playerInputAttemptCount) function (this will end the game) ****************************************INCOMPLETE SECTION
				else { //(playerInputAttemptCount==5)
					playerChoiceInput = "goodbye";
					playerChoiceInputChar = playerChoiceInput.charAt(0);
				}
			}
			if (playerChoiceInputChar=='r')
				playerChoice = "rock";
			else if (playerChoiceInputChar=='p')
				playerChoice = "paper";
			else if (playerChoiceInputChar=='s')
				playerChoice = "scissors";
			else if (playerChoiceInputChar=='e')
				playerChoice = "exit";
			else
				playerChoice = "goodbye";
	}
	
	public String getPlayerChoice() {
		return playerChoice;
	}
	
	//system chooses rps
	public void setSystemChoice() {
		Random systemPlay = new Random();
		systemChoiceInt = systemPlay.nextInt(3);
		if (systemChoiceInt==0)
			systemChoice = "rock";
		else if (systemChoiceInt==1)
			systemChoice = "paper";
		else
			systemChoice = "scissors";
	}
	
	public String getSystemChoice() {
		return systemChoice;
	}
	
	//compare results, declare winner
	public String Judge(String pc, String sc) {
		if (pc.equals(sc)) {
			winner = "It's a tie!\nWe both chose " + getPlayerChoice() + "!";
			playerWin = 0;
			systemWin = 0;
			ties = 1;
		}
		
		else if (pc.equals("rock")) {
			if (sc.equals("paper")) {
				//setRounds in Stats class
				winner = "Paper covers Rock.\nI win!";
				systemWin = 1;
				playerWin = 0;
				ties = 0;
			}
			else {
				//setRounds in Stats class
				winner = "Rock crushes Scissors.\nYou win!";
				playerWin = 1;
				systemWin = 0;
				ties = 0;
			}
		}
		else if (pc.equals("paper")) {
			if (sc.equals("rock")) {
				//setrounds in Stats class
				winner = "Paper covers Rock.\nYou win!";
				playerWin = 1;
				systemWin = 0;
				ties = 0;
			}
			else {
				//setRounds in Stats class
				winner = "Scissors cut Paper.\nI win!";
				systemWin = 1;
				playerWin = 0;
				ties = 0;
			}
		}
		else { //pc=scissors
			if (sc.equals("rock")) {
				//setRounds in Stats class
				winner = "Rock crushes Scissors.\nI win!";
				systemWin = 1;
				playerWin = 0;
				ties = 0;
			}
			else {
				//setrounds in Stats class
				winner = "Scissors cut Paper.\nYou win!";
				playerWin = 1;
				systemWin = 0;
				ties = 0;
			}
		}
		return winner;
	}
	
	public String getWinner() {
		return winner;
	}
	
	public int getPlayerWin() {
		return playerWin;
	}
	
	public int getSystemWin() {
		return systemWin;
	}
	
	public int getTies() {
		return ties;
	}
	
	private String badInput(String bi, int numOfTries) {
		String msgPart1="msgPart1 error", msgPart2="msgPart2 error";
		
		//message based on number of tries
		if (numOfTries==1) {
			msgPart1 = "The only available choices are:\nR for rock\nP for paper and\nS for scissors.\n" + bi + " is not an option.";
		}
		else if (numOfTries==2) {
			//allow user to choose to see the game explanation again or play
			int menuOrTryAgain = JOptionPane.showConfirmDialog(null, "Ok, human, there are three choices: rock, paper, and scissors.\nThat's all there is.\nNo " 
																+ bi +".\nJust those three.\n" + "All you have to do is choose one.\n\n"
																+ "Would you like to see the game explanation again?", "what?", JOptionPane.YES_NO_OPTION);
			 //if secondTry equals yes, go to rules
			if (menuOrTryAgain==JOptionPane.YES_OPTION) {
				RockPaperScissors.showRules();
				msgPart1 = "rules viewed";
			}
			else
				msgPart1 = ("Ok, then you understand that:\n");
		}
		else if (numOfTries==3) {
			msgPart1 = ("Really?\nWhy would THAT be in a game called \"Rock, Paper, Scissors?\" "); 
		}
		else if (numOfTries==4) {
			msgPart1 = "thisMessageControlsReturnString_DoNotChangeIt";
		}
		else { //numOfTries=5
			msgPart1 = "You are not playing nicely.\nGoodbye.";
		}
			
		//message based on choice
		if (bi=="a") { //did you miss the s?
			msgPart2 = ("msg for " + bi + " not entered yet."); //*******************************************************************************************INCOMPLETE LINE
		}
		else if (bi=="b") {
			msgPart2 = ("msg for " + bi + " not entered yet."); //*******************************************************************************************INCOMPLETE LINE
		}
		else if (bi=="c") {
			msgPart2 = ("msg for " + bi + " not entered yet."); //*******************************************************************************************INCOMPLETE LINE
		}
		else if (bi=="d") { //did you miss the r?
			msgPart2 = ("msg for " + bi + " not entered yet."); //*******************************************************************************************INCOMPLETE LINE
		}
		else if (bi=="e") { //did you miss the r?
			msgPart2 = ("msg for " + bi + " not entered yet."); //*******************************************************************************************INCOMPLETE LINE
		}
		else if (bi=="f") { //did you miss the r?
			msgPart2 = ("msg for " + bi + " not entered yet."); //*******************************************************************************************INCOMPLETE LINE
		}
		else if (bi=="g") { 
			msgPart2 = ("msg for " + bi + " not entered yet."); //*******************************************************************************************INCOMPLETE LINE
		}
		else if (bi=="h") {
			msgPart2 = ("msg for " + bi + " not entered yet."); //*******************************************************************************************INCOMPLETE LINE
		}
		else if (bi=="i") {
			msgPart2 = ("msg for " + bi + " not entered yet."); //*******************************************************************************************INCOMPLETE LINE
		}
		else if (bi=="j") {
			msgPart2 = ("msg for " + bi + " not entered yet."); //*******************************************************************************************INCOMPLETE LINE
		}
		else if (bi=="k") {
			msgPart2 = ("msg for " + bi + " not entered yet."); //*******************************************************************************************INCOMPLETE LINE
		}
		else if (bi=="l") { //did you miss the p?
			msgPart2 = ("msg for " + bi + " not entered yet."); //*******************************************************************************************INCOMPLETE LINE
		}
		else if (bi=="m") {
			msgPart2 = ("msg for " + bi + " not entered yet."); //*******************************************************************************************INCOMPLETE LINE
		}
		else if (bi=="n") {
			msgPart2 = "There is no \"N\" in Rock, Paper, or Scissors.\n"
					+ "There is an N in No.\n"
					+ "There is an N in Not an acceptable choice.\n"
					+ "And in Not an option.\n"
					+ "And Not the first letter of rock.\n"
					+ "Not the first letter of paper.\n"
					+ "Not the first letter of scissors.\n"
					+ "and No.\n\n"
					+ "The game is \"Rock, Paper, Scissors\"\n"
					+ "The choices are R, P, and S.\n"
					+ "No other choices available.\n"
					+ "None.";
		}
		else if (bi=="o") { //did you miss the p?
			msgPart2 = ("msg for " + bi + " not entered yet."); //*******************************************************************************************INCOMPLETE LINE
		}
		else if (bi=="q") { //quitting is not an option
			msgPart2 = ("msg for " + bi + " not entered yet."); //*******************************************************************************************INCOMPLETE LINE
		}
		else if (bi=="t") { //did you miss the r?
			msgPart2 = ("msg for " + bi + " not entered yet."); //*******************************************************************************************INCOMPLETE LINE
		}
		else if (bi=="u") {
			msgPart2 = ("msg for " + bi + " not entered yet."); //*******************************************************************************************INCOMPLETE LINE
		}
		else if (bi=="v") {
			msgPart2 = ("msg for " + bi + " not entered yet."); //*******************************************************************************************INCOMPLETE LINE
		}
		else if (bi=="w") { //did you miss the s?
			msgPart2 = ("msg for " + bi + " not entered yet."); //*******************************************************************************************INCOMPLETE LINE
		}
		else if (bi=="x") { //did you miss the s?
			msgPart2 = ("msg for " + bi + " not entered yet."); //*******************************************************************************************INCOMPLETE LINE
		}
		else if (bi=="y") { 
			msgPart2 = ("msg for " + bi + " not entered yet."); //*******************************************************************************************INCOMPLETE LINE
		}
		else if (bi=="z") { //did you miss the s? 
			msgPart2 = ("msg for " + bi + " not entered yet."); //*******************************************************************************************INCOMPLETE LINE
		}
		else { //that's not even a letter
			msgPart2 = ("msg for " + bi + " not entered yet."); //*******************************************************************************************INCOMPLETE LINE
		}
	
	//reprompt with message based on numOfTries
		if (msgPart1.contains("oodbye"))
			return msgPart1;
		else if (msgPart1.contains("thisMessageControlsReturnString_DoNotChangeIt"))
			return "Ok. One more chance. And for the record:\n\n" + msgPart2;
		else if (msgPart1.contains("rules viewed"))
			return "";
		else
			return msgPart1 + "\n" + msgPart2;
	}
	
	//toString
	public String toString() {
		return "Player Choice: " + playerChoice
				+ "\nSystem Choice Random Int: " + systemChoiceInt
				+ "\nSystem Choice: " + systemChoice
				+ "Winner: " + winner + "\n";
	}
}
