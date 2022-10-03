//add code to validate misspellings by asking the user "did you mean "rock"?" if yes assign variable, if no display "pc with attitude" comment & reprompt

import java.util.Random;
import javax.swing.JOptionPane;

public class Play {
	
	private String playerChoiceInput, playerChose, systemChose, winner;
	int systemChoiceInt, playerWin, systemWin, ties;
	
	//user chooses rps
	public void setPlayerChoice() {
			playerChoiceInput = JOptionPane.showInputDialog(null, "Make your choice:\n" + "(R)ock, (P)aper, or (S)cissors?", "Choose!", JOptionPane.PLAIN_MESSAGE);
			
			//if player does not choose rps, or enters more than one letter, reprompt with funny message
			while (playerChoiceInput.charAt(0)!='r' && playerChoiceInput.charAt(0)!='R' 
					&& playerChoiceInput.charAt(0)!='p' && playerChoiceInput.charAt(0)!='P'
					&& playerChoiceInput.charAt(0)!='s' && playerChoiceInput.charAt(0)!='S') {
				//first time - did you miss the letter? there are no [word that starts with that letter] in this game. reprompt
				//second time - ok, human, there are three choices: rock, paper, and scissors. that's all there is. no [whatever they entered]. just those three. 
						//all you have to do is choose one. 
				//third time - really? why would THAT be in a game called "Rock, paper, scissors?"
				//fourth time - you can't be serious. you have to be doing this on purpose. Why do you ask to play a game, and then not play? Rock, Paper, Scissors, or Forfeit?
				playerChoiceInput = JOptionPane.showInputDialog(null, "That choice is not valid. Please type \"rock,\" \"paper,\" or \"scissors.\"", "Error", JOptionPane.ERROR_MESSAGE);
			}
			if (playerChoiceInput.charAt(0)=='r' || playerChoiceInput.charAt(0)=='R') {
				playerChose = "rock";
			}
			else if (playerChoiceInput.charAt(0)=='p' || playerChoiceInput.charAt(0)=='P') {
				playerChose = "paper";
			}
			else {playerChose = "scissors";}
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
	
	private String badInput(String bi) {
		String msg;
		if (bi=="a") { //did you miss the s?
			msg = 
		}
		else if (bi=="b") {
			msg = 
		}
		else if (bi=="c") {
			msg = 
		}
		else if (bi=="d") { //did you miss the r?
			msg = 
		}
		else if (bi=="e") { //did you miss the r?
			msg = 
		}
		else if (bi=="f") { //did you miss the r?
			msg = 
		}
		else if (bi=="g") { 
			msg = 
		}
		else if (bi=="h") {
			msg = 
		}
		else if (bi=="i") {
			msg = 
		}
		else if (bi=="j") {
			msg = 
		}
		else if (bi=="k") {
			msg = 
		}
		else if (bi=="l") { //did you miss the p?
			msg = 
		}
		else if (bi=="m") {
			msg = 
		}
		else if (bi=="n") {
			msg = 
		}
		else if (bi=="o") { //did you miss the p?
			msg = 
		}
		else if (bi=="q") { //quitting is not an option
			msg = 
		}
		else if (bi=="t") { //did you miss the r?
			msg = 
		}
		else if (bi=="u") {
			msg = 
		}
		else if (bi=="v") {
			msg = 
		}
		else if (bi=="w") { //did you miss the s?
			msg = 
		}
		else if (bi=="x") { //did you miss the s?
			msg = 
		}
		else if (bi=="y") { 
			msg = 
		}
		else if (bi=="z") { //did you miss the s? 
			msg = 
		}
		else { //that's not even a letter
			msg = 
		}
		return msg;
	}
	
	//toString
	public String toString() {
		return "Player Choice: " + playerChose
				+ "\nSystem Choice Random Int: " + systemChoiceInt
				+ "\nSystem Choice: " + systemChose
				+ "Winner: " + winner + "\n";
	}
}
