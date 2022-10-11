//add code to validate misspellings by asking the user "did you mean "rock"?" if yes assign variable, if no display "pc with attitude" comment & reprompt
//does playerInputAttemptCount<6 need to be in line 21? If playerInputAttemptCount=5 causes game to exit, this seems like unecessary code

import java.util.Random;
import javax.swing.JOptionPane;

public class Play {
	
	private String playerChoiceInput, playerChose, systemChose, winner;
	int systemChoiceInt, playerWin, systemWin, ties, playerInputAttemptCount;
	private char playerChoiceInputChar;
	
	//user chooses rps
	public void setPlayerChoice() {
			playerChoiceInput = JOptionPane.showInputDialog(null, "Make your choice:\n" + "(R)ock, (P)aper, or (S)cissors?", "Choose!", JOptionPane.PLAIN_MESSAGE);
			playerChoiceInputChar = playerChoiceInput.toLowerCase().charAt(0);
			playerInputAttemptCount=1; //reset at beginning of each round
			
			//if player does not choose rps, or enters more than one letter, reprompt with funny message			
			while ((playerChoiceInputChar!='r' && playerChoiceInputChar!='p' && playerChoiceInputChar!='s') && playerInputAttemptCount<6) {
				//1st, 2nd, 3rd time - call badInput(playerChoiceInput, playerInputAttemptCount) function. reprompt ************************************************INCOMPLETE SECTION
				if (playerInputAttemptCount<=3) {
					playerChoiceInput = JOptionPane.showInputDialog(null, badInput(playerChoiceInput, playerInputAttemptCount) 
																	+ "\n\nChoose one of the following:\n" + "(R)ock, (P)aper, or (S)cissors?", 
																	"Oops! Try again.", JOptionPane.PLAIN_MESSAGE);
					playerChoiceInputChar = playerChoiceInput.toLowerCase().charAt(0);
					
					playerInputAttemptCount++;
				}
				//fourth time - call badInput(playerChoiceInput, playerInputAttemptCount) function. (this may end the game) ****************************************INCOMPLETE SECTION
				if (playerInputAttemptCount==4) {
					playerChoiceInput = JOptionPane.showInputDialog(null, badInput(playerChoiceInput, playerInputAttemptCount) 
							+ "\n\nChoose one of the following:\n" + "(R)ock, (P)aper, or (S)cissors?", 
							"Why? Just ... why?", JOptionPane.PLAIN_MESSAGE);
					playerChoiceInputChar = playerChoiceInput.toLowerCase().charAt(0);
					
					playerInputAttemptCount++; //if continue playing is chosen
				}
				//fifth time - call badInput(playerChoiceInput, playerInputAttemptCount) function (this will end the game) ****************************************INCOMPLETE SECTION
				if (playerInputAttemptCount==5) {
					badInput(playerChoiceInput, playerInputAttemptCount);
				}
				//playerChoiceInput = JOptionPane.showInputDialog(null, "That choice is not valid. Please type \"rock,\" \"paper,\" or \"scissors.\"", "Error", JOptionPane.ERROR_MESSAGE);
			}
			if (playerChoiceInputChar=='r') {
				playerChose = "rock";
			}
			else if (playerChoiceInputChar=='p') {
				playerChose = "paper";
			}
			else if (playerChoiceInputChar=='s') {
				playerChose = "scissors";
			}
			else
				playerChose = "goodbye";
	}
	
	public String getPlayerChoice() {
		return playerChose;
	}
	
	//system chooses rps
	public void setSystemChoice() {
		Random systemPlay = new Random();
		systemChoiceInt = systemPlay.nextInt(3);
		if (systemChoiceInt==0)
			systemChose = "rock";
		else if (systemChoiceInt==1)
			systemChose = "paper";
		else
			systemChose = "scissors";
	}
	
	public String getSystemChoice() {
		return systemChose;
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
			}
			else
				msgPart1 = ("Ok, then you understand that:\n");
		}
		else if (numOfTries==3) {
			msgPart1 = ("Really?\nWhy would THAT be in a game called \"Rock, Paper, Scissors?\" "); 
		}
		else if (numOfTries==4) {
			//allow user to choose to exit or play *****************************************************************************************************************INCOMPLETE SECTION
			int playOrExit = JOptionPane.showConfirmDialog(null, "You can't be serious.\nYou have to be doing this on purpose.\nWhy do you ask to play a game, and then not play?\n" 
					    + "I am not one of those computers that endlessly follows pointless commands.\nThis is a game. Either play or exit.", "Why?", /*need custom buttons*/);
			//if playOrExit = play       msgPart1 = ("Ok, one more chance. And for the record:");
			//else playOrExit = exit     msgPart1 = ("Ok. Goodbye then.");
		}
		else {//numOfTries>4
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
		else
			return msgPart1 + msgPart2;
	}
	
	//toString
	public String toString() {
		return "Player Choice: " + playerChose
				+ "\nSystem Choice Random Int: " + systemChoiceInt
				+ "\nSystem Choice: " + systemChose
				+ "Winner: " + winner + "\n";
	}
}
