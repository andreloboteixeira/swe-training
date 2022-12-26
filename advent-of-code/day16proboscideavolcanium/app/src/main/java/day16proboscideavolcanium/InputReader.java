package day16proboscideavolcanium;

import java.util.*;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.stream.Collectors;

import day16proboscideavolcanium.InputReader;
import day16proboscideavolcanium.InputReader.Input;

public class InputReader {

    InputReader() {}

    public static class Input{
        public List<String> labels;
        public List<Integer> flowRates;
        public List<String[]> allEdgesLabels;

        Input(List<String> labels, List<Integer> flowRates, List<String[]> allEdgesLabels){
            this.labels = labels;
            this.flowRates = flowRates;
            this.allEdgesLabels = allEdgesLabels;
        }
    }

    public static Input readInputRound1DinamicProgramming() throws IOException {
        String fileName = "/Users/andreloboteixeira/coding/swe-training/advent-of-code/day16proboscideavolcanium/app/src/main/java/day16proboscideavolcanium/day16-input.txt";
//        String fileName = "/Users/andreloboteixeira/coding/swe-training/advent-of-code/day16proboscideavolcanium/app/src/main/java/day16proboscideavolcanium/day16-input-test.txt";

        Input result = null;

        List<String> labels = new ArrayList();
        List<Integer> flowRates = new ArrayList();
        List<String[]> allEdgesLabels = new ArrayList();

        BufferedReader br = null;
        try {

            br = new BufferedReader(new FileReader(fileName));

            String line;
            // read file and create graph
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

            result = new Input(labels, flowRates, allEdgesLabels);

        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (br != null) {
                br.close();
            }
        }
//        System.out.println(result);
        return result;
    }
}