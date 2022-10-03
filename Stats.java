//class to create and store statistics from the game
//can be reset from administrative menu

public class Stats{

	private int rounds=0, playerWins=0, systemWins=0, ties=0;
	
	//talley number of rounds played: setRounds will count the number of rounds in a game, then reset at the beginning of a game
	public void setRounds() {
		rounds++;
	}
	
	public int getRounds() {
		return rounds;
	}
	
	public void setPlayerWinCount() {
		playerWins++;
	}
	
	public int getPlayerWinCount() {
		return playerWins;
	}
	
	public void setSystemWinCount() {
		systemWins++;
	}
	
	public int getSystemWinCount() {
		return systemWins;
	}
	
	public void setTies() {
		ties++;
	}
	
	public int getTies() {
		return ties;
	}
	
	//tally number of times player and system each chooses rock, paper, scissors
	//statistics: percent of rounds won by player/system (and raw numbers)
	//				percent of rounds where rock, paper, scissors each won (and raw numbers)
	//store statistics (long term)
	//set a method to erase all data (option only available in administrative choice)
	
}
