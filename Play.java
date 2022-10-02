//add code to validate misspellings by asking the user "did you mean "rock"?" if yes assign variable, if no display "pc with attitude" comment & reprompt

import java.util.Random;
import javax.swing.JOptionPane;

public class Play {
	
	private String playerChoiceInput, playerChose, systemChose, winner;
	int systemChoiceInt;
	
	//user chooses rps
	public void setPlayerChoice() {
			playerChoiceInput = JOptionPane.showInputDialog(null, "Make your choice:\n" + "(R)ock, (P)aper, or (S)cissors?", "Choose!", JOptionPane.PLAIN_MESSAGE);
			
			//if player does not choose rps, or enters more than one letter, reprompt with funny message
			while (playerChoiceInput.charAt(0)!='r' && playerChoiceInput.charAt(0)!='R' 
					&& playerChoiceInput.charAt(0)!='p' && playerChoiceInput.charAt(0)!='P'
					&& playerChoiceInput.charAt(0)!='s' && playerChoiceInput.charAt(0)!='S') {
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
			//setRounds in Stats class
			winner = "It's a tie!\nYou both chose " + getPlayerChoice() + "!";
		}
		
		else if (pc.equals("rock")) {
			if (sc.equals("paper")) {
				//setRounds in Stats class
				winner = "Paper covers Rock.\nI win!";
			}
			else {
				//setRounds in Stats class
				winner = "Rock crushes Scissors.\nYou win!";
			}
		}
		else if (pc.equals("paper")) {
			if (sc.equals("rock")) {
				//setrounds in Stats class
				winner = "Paper covers Rock.\nYou win!";
			}
			else {
				//setRounds in Stats class
				winner = "Scissors cut Paper.\nI win!";
			}
		}
		else { //pc=scissors
			if (sc.equals("rock")) {
				//setRounds in Stats class
				winner = "Rock crushes Scissors.\nI win!";
			}
			else {
				//setrounds in Stats class
				winner = "Scissors cut Paper.\nYou win!";
			}
		}
		return winner;
	}
	
	public String getWinner() {
		return winner;
	}
	
	//toString
	public String toString() {
		return "Player Choice: " + playerChose
				+ "\nSystem Choice Random Int: " + systemChoiceInt
				+ "\nSystem Choice: " + systemChose
				+ "Winner: " + winner + "\n";
	}
}
