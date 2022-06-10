/*
Problem Statement

Beat the Star is a TV game show franchise started by the German original Schlag den Raab. In the game show a candidate attempts to beat a celebrity in a series of games. There are N games, numbered 1 to N. Each game has a winner and a loser. The winner of game X is awarded X points. The winner of the game show is the player (either the celebrity or the candidate) whose point total at the end is bigger.

In this problem we will make two simplifying assumptions (in comparison to the actual show):

N will be such that the total number of points is odd, so that we do not have to handle ties.
We will assume that all games always get played, even if the final winner is already known by that point.
You are soon going to take part in the game show as the candidate. The celebrity you'll compete against happens to be your twin. When trying to find an edge that would help you in the game, you watched many episodes of the show and you realized that the early games matter even less than it seems. Hence, you could save your strength by giving up some of the early games with the hope that this will help you beat your twin in the later games that are worth more points.

In this problem we want you to analyze how much each of the individual games matters. More precisely, we ask the following question: Assume that in each game each player wins with probability 50 percent. What is the probability that at the end game number G actually matters? (Given the full results of the show, game G matters if changing the winner of G would change the winner of the show.)


Definition

Class:	BeatTheStar
Method:	doesItMatter
Parameters:	int, int
Returns:	double
Method signature:	double doesItMatter(int N, int G)
(be sure your method is public)


Notes
-	The return value must have an absolute error at most 1e-9.

Constraints
-	N will be between 1 and 100, inclusive.
-	N will be such that the total number of points in the show is odd.
-	G will be between 1 and N, inclusive.

Examples
0)

2
1
Returns: 0.0
There are two games: game 1 awards one point and game 2 awards two. In this setting, game 1 does not matter at all: the winner of game 2 wins the show.
1)

5
5
Returns: 0.625
If there are five games, game 5 matters quite often so winning it is crucial.
2)

5
1
Returns: 0.125
Game 1 matters much less.
3)

5
2
Returns: 0.125
Perhaps quite surprisingly, even though game 2 is worth twice as many points as game 1, in this particular format their importance is exactly the same.
4)

9
7
Returns: 0.328125
* */
public class BeatTheStar {
    public static void main(String[] args) {
        int a = 5;
        int b = 5;
        BeatTheStar bts = new BeatTheStar();
        double result = bts.doItMatter(a, b);
        System.out.println(result);
    }

    public double doesItMatter(int N, int G) {
        int total = N * (N + 1) / 2;
        double[] pr = new double[total + 1];
        pr[0] = 1.0;

        for (int i = 1; i <= N; ++i) {
            if (i == G) continue;
            for (int old = pr.length - 1; old >= 0; --old)
                if (pr[old] > 0) {
                    pr[old] *= 0.5;
                    pr[old + i] += pr[old];
                }
        }

        double res = 0;
        for (int c = 0; c < pr.length; ++c)
            if (pr[c] > 0) {
                if (c * 2 < total && (c + G) * 2 > total) {
                    res += pr[c];
                }
            }
        return res;
    }
}