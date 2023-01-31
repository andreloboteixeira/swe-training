package day2rockpaperscissors;

import java.util.*;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.stream.Collectors;

public class App {

    public static void main(String[] args) {

//        App.round1(args);
        App.round2(args);

    }

    public static void round1(String[] args){
        try{
            List<List<Character>> inputRounds = App.readInput();

            Map<Character, Long> shapeScore = Map.of(
                    'A', 1L,
                    'B', 2L,
                    'C', 3L,
                    'X', 1L,
                    'Y', 2L,
                    'Z', 3L
            );


            List<List<Long>> scoresRounds = new ArrayList<>();
            Long myFinalScore = 0L;
            Long opponentsFinalScore = 0L;

            for(List<Character> round: inputRounds){

                List<Long> playersScores = new ArrayList<>();
                char opponentWillPlay = round.get(0); // A B C
                char myNextPlay = round.get(1);       // X Y Z
                // 1 2 3
                Long myScore = shapeScore.get(myNextPlay), opponentScore = shapeScore.get(opponentWillPlay);
                if(opponentWillPlay == 'A' && myNextPlay == 'X' || opponentWillPlay == 'B' && myNextPlay == 'Y' || opponentWillPlay == 'C' && myNextPlay == 'Z') {
                    myScore += 3;
                    opponentScore += 3;
                } else if(opponentWillPlay == 'A' && myNextPlay == 'Y' || opponentWillPlay == 'B' && myNextPlay == 'Z' || opponentWillPlay == 'C' && myNextPlay == 'X') {
                    myScore += 6;
                    opponentScore += 0;
                } else {
                    myScore += 0;
                    opponentScore += 6;
                }
                scoresRounds.add(List.of(myScore, opponentScore));
                myFinalScore += myScore;
                opponentsFinalScore += opponentScore;
            }

            System.out.println("Scores per round: ");
            System.out.println(scoresRounds);


            System.out.println("myFinalScore: ");
            System.out.println(myFinalScore);
            System.out.println("opponentsFinalScore: ");
            System.out.println(opponentsFinalScore);

            Boolean didIWin = myFinalScore > opponentsFinalScore ? true : false;

            System.out.println("Did I win ");
            System.out.println(didIWin);


        } catch (Exception error){
            System.out.println(error);
        }

    };

    public static void round2(String[] args){
        try{
            List<List<Character>> inputRounds = App.readInput();

            Map<Character, Long> shapeScore = Map.of(
                    'A', 1L,
                    'B', 2L,
                    'C', 3L,
                    'X', 1L,
                    'Y', 2L,
                    'Z', 3L
            );


            List<List<Long>> scoresRounds = new ArrayList<>();
            Long myFinalScore = 0L;
            Long opponentsFinalScore = 0L;

            for(List<Character> round: inputRounds){

                List<Long> playersScores = new ArrayList<>();
                char opponentWillPlay = round.get(0); // A B C
                char roundOutcome = round.get(1);       // X Y Z

                char myNextPlay = 'X';
                if(roundOutcome == 'Y'){ // draw
                    if(opponentWillPlay == 'A') myNextPlay = 'X';
                    if(opponentWillPlay == 'B') myNextPlay = 'Y';
                    if(opponentWillPlay == 'C') myNextPlay = 'Z';
                } else if(roundOutcome == 'X'){ // I lose
                    if(opponentWillPlay == 'A') myNextPlay = 'Z';
                    if(opponentWillPlay == 'B') myNextPlay = 'X';
                    if(opponentWillPlay == 'C') myNextPlay = 'Y';
                } else { // I win
                    if(opponentWillPlay == 'A') myNextPlay = 'Y';
                    if(opponentWillPlay == 'B') myNextPlay = 'Z';
                    if(opponentWillPlay == 'C') myNextPlay = 'X';
                }
                // 1 2 3
                Long myScore = shapeScore.get(myNextPlay), opponentScore = shapeScore.get(opponentWillPlay);
                if(opponentWillPlay == 'A' && myNextPlay == 'X' || opponentWillPlay == 'B' && myNextPlay == 'Y' || opponentWillPlay == 'C' && myNextPlay == 'Z') {
                    myScore += 3;
                    opponentScore += 3;
                } else if(opponentWillPlay == 'A' && myNextPlay == 'Y' || opponentWillPlay == 'B' && myNextPlay == 'Z' || opponentWillPlay == 'C' && myNextPlay == 'X') {
                    myScore += 6;
                    opponentScore += 0;
                } else {
                    myScore += 0;
                    opponentScore += 6;
                }


                        scoresRounds.add(List.of(myScore, opponentScore));
                myFinalScore += myScore;
                opponentsFinalScore += opponentScore;
            }

            System.out.println("Scores per round: ");
            System.out.println(scoresRounds);


            System.out.println("myFinalScore: ");
            System.out.println(myFinalScore);
            System.out.println("opponentsFinalScore: ");
            System.out.println(opponentsFinalScore);

            Boolean didIWin = myFinalScore > opponentsFinalScore ? true : false;

            System.out.println("Did I win ");
            System.out.println(didIWin);


        } catch (Exception error){
            System.out.println(error);
        }

    };

    public static List<List<Character>> readInput() throws IOException {
        String fileName = "/Users/andreloboteixeira/coding/swe-training/advent-of-code/day2rockpaperscissors/app/src/main/java/day2rockpaperscissors/day2-input.txt";
//        String fileName = "/Users/andreloboteixeira/coding/swe-training/advent-of-code/day2rockpaperscissors/app/src/main/java/day2rockpaperscissors/day2-input-test.txt";
        List<List<Character>> result = new ArrayList<>();
        List<Character> round = new ArrayList<>();


        BufferedReader br = null;
        try {

            br = new BufferedReader(new FileReader(fileName));

            String line;
            while ((line = br.readLine()) != null) {
                System.out.println(line);
                round = List.of(line.charAt(0), line.charAt(2));
                result.add(round);
            }

        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (br != null) {
                br.close();
            }
        }
        			System.out.println(result);
        return result;
    }
}
