/*
Problem Statement

An election has just finished. There were two candidates: A and B. Each voter voted for one of the two candidates. The winner will be the candidate who received more votes. Thus, there are three possibilities for the outcome: A won, B won, or the election is a tie.

You are a journalist who observes the election committee. Your task is to report the outcome of the election as quickly as possible.



The votes cast are given in the String votes: each 'A' is a vote for candidate A and each 'B' is a vote for candidate B. You know the total number of votes cast (i.e., the length of the string votes).

The election committee is counting the votes in the order in which they are given in the string. Luckily, you just realized that you probably won't have to be there until the very end. It is quite likely that you will already know the outcome of the election before the last vote has been counted.

For example, suppose the votes cast are votes = "AABAABAAB". The election committee will count the votes in this order: one vote for A, another vote for A, then a vote for B, and so on. After they count the first seven votes ("AABAABA") you will already know the election result. (Candidate A is leading with five votes to two, and the remaining two votes can no longer change the winner of the election.)



Return the smallest X such that the result of the election will be known after the first X votes have been counted.


Definition

Class:	BallotCounting
Method:	count
Parameters:	String
Returns:	int
Method signature:	int count(String votes)
(be sure your method is public)


Constraints
-	votes will have between 1 and 50 characters, inclusive.
-	Each character in votes will be 'A' or 'B'.

Examples
0)

"AAAAABBBBB"
Returns: 10
You have to wait until all ten votes have been counted. The final result is a tie.
1)

"AAAAABBBBA"
Returns: 10
Again, you have to wait until all ten votes have been counted. After nine votes the counting is in exactly the same state as in Example 0: A has 5 votes, B has 4 votes, and one vote remains to be counted. In this case, A got the last vote and won the election.
2)

"AAAAA"
Returns: 3
This election is a landslide. After we see three of the five votes, we are already sure that A will be the winner.
3)

"AAAAAA"
Returns: 4
This is very similar to the previous example. Note that after three votes it is still possible that the election will be a tie, we have to see the fourth A to be sure.
4)

"AABAABAAB"
Returns: 7
This is the example from the problem statement.
5)

"BABABBB"
Returns: 6
Here B is the winner of the election and we will know it before we see the last vote.
* */
public class BallotCounting {
    public static void main(String[] args) {
        String start = "AAAAABBBBB";
        BallotCounting bc = new BallotCounting();
        int result = bc.count(start);
        System.out.println(result);
    }

    public int count(String votes) {
        int av = 0;
        int bv = 0;
        int read = votes.length() / 2 + 1;
        ;
        int result = 0;

        for (int i = 0; i < votes.length(); i++) {
            if (votes.charAt(i) == 'A') {
                av++;
            }
            if (votes.charAt(i) == 'B') {
                bv++;
            }
            result = i;
            if (av == read || bv == read) {
                break;
            }
        }
        return result + 1;
    }
}