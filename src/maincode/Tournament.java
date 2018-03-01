package maincode;

import java.util.ArrayList;

public class Tournament {

	ArrayList<String> playerNames;
	ArrayList<Integer> scores;
	ArrayList<String> roundLog;
	ArrayList<ArrayList<String>> roundPlayers;
	int gameCounter = 0;
	int roundCounter = 1;
	int totalPlayers;

	public Tournament(String[] args) {
		int n = Integer.parseInt(args[0]);
		totalPlayers = n;
		playerNames = new ArrayList<>();
		scores = new ArrayList<>();
		roundLog = new ArrayList<>();
		roundPlayers = new ArrayList<>();
		if (n % 2 != 0) {
			throw new RuntimeException("Invalid number of players!");
		}

		for (int i = 1; i < n + 1; i++) {
			playerNames.add(args[i]);
		}
		roundPlayers.add(new ArrayList<String>(playerNames));
		int m = n + n;
		for (int i = n + 1; i < m; i++) {
			scores.add(Integer.parseInt(args[i]));
		}

	}

	public void printNames() {
		System.out.print("Players: ");
		for (String name : playerNames) {
			System.out.print(name + ", ");
		}
		System.out.println();
	}

	public void printScores() {
		System.out.print("Scores: ");
		for (int score : scores) {
			System.out.println(score);
		}
	}

	public void evaluateRound() {
		ArrayList<String> winners = new ArrayList<>();
		int gamesToPlay = playerNames.size() / 2;
		for (int i = 0; i < gamesToPlay; i++) {
			String winner;
			String loser;
			if (scores.get(gameCounter) == 1) {
				winner = playerNames.get(0);
				loser = playerNames.get(1);
				winners.add(winner);
			} else {
				winner = playerNames.get(1);
				loser = playerNames.get(0);
				winners.add(winner);
			}

			gameCounter++;
			if (totalPlayers == 2) {
				roundLog.add("round " + roundCounter + " (final), players: " + playerNames.remove(0) + " and "
						+ playerNames.remove(0) + ", champion: " + winner + ", finalist: " + loser);
			} else {
				roundLog.add("round " + roundCounter + ", players: " + playerNames.remove(0) + " and "
						+ playerNames.remove(0) + ", advances: " + winner + ", eliminated: " + loser);
			}
			totalPlayers--;
		}
		roundCounter++;
		playerNames = winners;
		roundPlayers.add(new ArrayList<String>(playerNames));
	}

	private void printLog() {
		for (String log : roundLog) {
			System.out.println(log);
		}
	}

	private void printParticipants() {
		for (int i = 0; i < roundPlayers.get(0).size(); i++) {
			for (ArrayList<String> oneRound : roundPlayers) {

				if (oneRound.size() > i) {
					System.out.print(oneRound.get(i) + " ");
				}
			}
			System.out.println();
		}

	}

	public void playAllRounds() {
		while (playerNames.size() > 1) {
			evaluateRound();
		}
		printParticipants();
		printLog();
	}

}
