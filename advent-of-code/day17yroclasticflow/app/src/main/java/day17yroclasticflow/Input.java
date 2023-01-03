package day17yroclasticflow;

import java.util.*;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class Input {
    public List<Character> jetPattern;

    Input(){
        this.jetPattern = new ArrayList<>();
    }

    public void readInputRound1() throws IOException {
//        String fileName = "/Users/andreloboteixeira/coding/swe-training/advent-of-code/day17yroclasticflow/app/src/main/java/day17yroclasticflow/day17-input.txt";
        String fileName = "/Users/andreloboteixeira/coding/swe-training/advent-of-code/day17yroclasticflow/app/src/main/java/day17yroclasticflow/day17-input-test.txt";

        System.out.println(">> Reading file " + fileName + " ...");

        BufferedReader br = null;
        try {

            br = new BufferedReader(new FileReader(fileName));

            String line = br.readLine();
            for (int i = 0; i < line.length(); i++) {
                char currchar = line.charAt(i);
                jetPattern.add(currchar);
            }

        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (br != null) {
                br.close();
            }
        }
//        this.printInput();
    }

    public void printInput(){
        System.out.println(">> Print input");
        for(int i = 0; i < jetPattern.size(); i++){
            System.out.print(jetPattern.get(i));
        }
    }
}