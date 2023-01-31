package day16proboscideavolcanium;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Input {

    public List<String> labels;
    public List<Integer> flowRates;
    public List<String[]> allEdgesLabels;

    Input(){
        this.labels = new ArrayList();
        this.flowRates = new ArrayList();
        this.allEdgesLabels = new ArrayList();
    }

    public void readInputRound1DinamicProgramming() throws IOException {
        String fileName = "/Users/andreloboteixeira/coding/swe-training/advent-of-code/day16proboscideavolcanium/app/src/main/java/day16proboscideavolcanium/day16-input.txt";
//        String fileName = "/Users/andreloboteixeira/coding/swe-training/advent-of-code/day16proboscideavolcanium/app/src/main/java/day16proboscideavolcanium/day16-input-test.txt";

        System.out.println(">> Reading file " + fileName + " ...");

        BufferedReader br = null;
        try {

            br = new BufferedReader(new FileReader(fileName));

            String line;
            while ((line = br.readLine()) != null) {
                String[] aux = line.split(";");

                String[] nodeAndFlow = aux[0].split(" ");
                String[] edges = aux[1].split(",");

                String label = nodeAndFlow[0];
                Integer flowRate = Integer.parseInt(nodeAndFlow[1]);

                labels.add(label);
                flowRates.add(flowRate);
                allEdgesLabels.add(edges);
            }

        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (br != null) {
                br.close();
            }
            this.printInput();
        }

    }

    public void printInput(){
        System.out.println(">> Print input");
        for(int i = 0; i < labels.size(); i++){
            System.out.println(labels.get(i) + ": " + flowRates.get(i));

            for(String edge: allEdgesLabels.get(i)) {
                System.out.print(edge + ", ");
            }

            System.out.print("\n\n");
        }
    }
}