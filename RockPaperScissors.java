//9.29.22 add more reasons for rejection to reasonForRejection method

import javax.swing.JOptionPane;
import java.util.Scanner;
import java.util.Random;

public class RockPaperScissors {

	public static void main(String[] args) {
		//global variables
		String playAgain = "y", quitNow = "n", mainMenuChoice, playerReason;
		int rulesYesNo;
		
		//welcome screen
		JOptionPane.showMessageDialog(null, "Hello!\n\nWelcome to Rock, Paper, Scissors!\n\nLet's Play!");
		
		//while player does not want to quit
		while (quitNow.equalsIgnoreCase("n")){
			
			//Main Menu: Rules Play History Quit Admin
			Scanner mainMenuKeyboard = new Scanner(System.in);
			mainMenuChoice = JOptionPane.showInputDialog(null, "What do you want to do?\n\n"
												+ "1. See the rules.\n"
												+ "2. Play the game.\n"
												+ "3. See the stats.\n"
												+ "4. Quit\n"
												+ "5. Do boring administrative stuff.\n", "Main Menu", JOptionPane.QUESTION_MESSAGE);
			//mainMenuChoice = mainMenuKeyboard.nextLine();		
			mainMenuKeyboard.close();
			
			switch (mainMenuChoice) {
			
				case "1":
					Scanner rulesKeyboard = new Scanner(System.in);
					rulesYesNo = JOptionPane.showConfirmDialog(null, "RULES:\n\n"
							+ "When asked, you will choose R, P, or S for Rock, Paper, or Scissors.\n"
							+ "I will do the same.\n"
							+ "Winner is determined based on the following:\n\t"
							+ "Rock beats Scissors.\n\t"
							+ "Scissors beats Paper.\n\t"
							+ "Paper beats Rock.\n\t"
							+ "If we choose the same, it's a draw.\n\n"
							+ "Do you understand and accept these rules?", "Rules", JOptionPane.YES_NO_OPTION);
					if (rulesYesNo == JOptionPane.YES_OPTION) {
						JOptionPane.showMessageDialog(null, "Awesome! Let's Play!");
					}
					else {
						playerReason = JOptionPane.showInputDialog(null, "Why do you not agree?", "Explain Please", JOptionPane.QUESTION_MESSAGE);
						//show a "thinking screen" for 5 seconds
						JOptionPane.showInternalMessageDialog(null, "I have considered your reason. \n\n"
																	+ "I find your reason to be " + reasonForRejection() + ".\n"
																	+ "These rules have existed as long as\n"
																	+ "there have been rocks, paper, and scissors.\n\n"
																	+ "Traditional rules remain.", "No. Just no.", rulesYesNo);
					}
					rulesKeyboard.close();
					break;
					
				case "2":
					System.out.println("Placeholder");
				break;
				}
					
			}//close while quitNow.equalsIgnoreCase("n")
		}
public static String reasonForRejection() {
	Random rejection = new Random();
	int rejectionChoice = rejection.nextInt(3);
	String[] rejectionReasons = {"annoying", "irritating", "boring", "too human"};
	return rejectionReasons[rejectionChoice];
}
}

