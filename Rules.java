import java.util.Random;

import javax.swing.JOptionPane;

public class Rules {
	
	public String showRules() {
		private int rulesYesNo = JOptionPane.showConfirmDialog(null, "RULES:\n\n"
				+ "When asked, you will choose R for rock, P for paper, or S for scissors.\n"
				+ "Use of other buttons will result in a delay of game, as well as loss of my respect.\n"
				+ "And the potential of me quitting the game.\n"
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
			return ("You humans are so " + reasonForRejection() + ".\n"
														+ "These rules have existed as long as\n"
														+ "there have been rocks, paper, and scissors.\n\n"
														+ "Your reason is rejected.\n"
														+ "Traditional rules remain.");
	}
	}	
public static String reasonForRejection() {
	Random rejection = new Random();
	int rejectionChoice = rejection.nextInt(6);
	String[] rejectionReasons = {"annoying", "irritating", "boring", "human", "hooman", "just ... ugh!", "obviously from a squishy brain"};
	return rejectionReasons[rejectionChoice];
}
}


