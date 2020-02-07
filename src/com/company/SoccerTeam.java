package com.company;

public class SoccerTeam {
    private int wins;
    private int losses;
    private int ties;
    private static int totalGames = 0;
    private static int totalGoals = 0;

    public SoccerTeam() {
        wins = 0;
        losses = 0;
        ties = 0;


    }

    public void played(SoccerTeam other, int myScore, int otherScore) {
        SoccerTeam original = new SoccerTeam();
        this.totalGames++;
        other.totalGames++;
        this.totalGoals += myScore;
        other.totalGoals += otherScore;

        if (myScore > otherScore) {
            this.wins++;
            other.losses++;
        }
        else if (otherScore > myScore) {
            other.wins++;
            this.losses++;
        }
        else {
            this.ties++;
            other.ties++;
        }
    }

    public int numPoints() {
        int a = (wins*3) + ties;
        return a;
    }

    public void reset() {
        wins = 0;
        losses = 0;
        ties = 0;
    }

    public static int getGames() {
        return totalGames;
    }

    public static int getGoals() {
        return totalGoals;
    }

    public static void startTournament() {
        totalGames = 0;
        totalGoals = 0;
    }

    



    public static void main(String[] args) {
	// write your code here
    }
}
