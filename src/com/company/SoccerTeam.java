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
        totalGames++;
        totalGoals+= myScore;
        totalGoals += otherScore;

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
	SoccerTeam transformers = new SoccerTeam();
	SoccerTeam powerRangers = new SoccerTeam();
	SoccerTeam ninjaTurtles = new SoccerTeam();
	SoccerTeam avengers = new SoccerTeam();

	powerRangers.played(transformers, 5, 7);
	ninjaTurtles.played(avengers, 9, 4);
	transformers.played(avengers, 3, 2);
	powerRangers.played(ninjaTurtles, 6, 6);

	System.out.println(powerRangers.numPoints()); //1
	System.out.println(transformers.numPoints()); //6
	System.out.println(ninjaTurtles.numPoints()); //4
	System.out.println(avengers.numPoints()); //0
	System.out.println(getGames()); //4
	System.out.println(getGoals()); //42

    /* transformers.reset();
    powerRangers.reset();
    ninjaTurtles.reset();
    avengers.reset(); */

	transformers.played(ninjaTurtles, 1, 0);
	powerRangers.played(avengers, 10, 12);
	transformers.played(powerRangers, 7, 7);
	ninjaTurtles.played(avengers, 4, 3);

	System.out.println(powerRangers.numPoints()); //1
	System.out.println(transformers.numPoints()); //4
	System.out.println(ninjaTurtles.numPoints()); //3
	System.out.println(avengers.numPoints()); //3
	System.out.println(getGames()); //4 or 8
	System.out.println(getGoals()); //44 or 86
    }

    /*
Output for first tournament:
1
6
4
0
4
42

Output for second tournament:
2
10
7
3
8
86

Output for second tournament after reset method is called:
1
4
3
3
8
86

Output if only the second tournament is executed:
1
4
3
3
4
44
     */
}
