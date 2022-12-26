package day16proboscideavolcanium;

import java.util.*;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.stream.Collectors;

import day16proboscideavolcanium.InputReader;
import day16proboscideavolcanium.InputReader.Input;

public class App {

    public static void main(String[] args) {

        try{
            Input input = InputReader.readInputRound1DinamicProgramming();
            DynamicProgrammingSolver solver = new DinamicProgrammingSolver(input);
            for(int i = 0; i < input.labels.size(); i++){
                System.out.println(input.labels.get(i) + ": " + input.flowRates.get(i));
            for(String edge: input.allEdgesLabels.get(i)) System.out.print(edge + ", ");
                System.out.print("\n\n");
            }

            List<Boolean> openValvesRound1 = input.labels.stream().map(valve -> false).collect(Collectors.toList());

            System.out.println("Solution first round: ");
            Integer sol1 = solver.solve("AA", openValvesRound1, 30, false);
            System.out.println(sol1);

            List<Boolean> openValvesRound2 = input.labels.stream().map(valve -> false).collect(Collectors.toList());

            System.out.println("Solution second round: ");
            Integer sol2 = solver.solve("AA", openValvesRound2, 26, true);
            System.out.println(sol2);

        } catch (Exception error){
            System.out.println(error);
        }

    }
}
