package day16proboscideavolcanium;

import java.util.*;
import java.util.stream.Collectors;

public class App {

    public static void main(String[] args) {

        try{
            Input input = new Input();
            input.readInputRound1DinamicProgramming();
            input.printInput();

            DynamicProgrammingSolver solver = new DynamicProgrammingSolver(input);

            List<Boolean> valvesInitialStateRound1 = input.labels.stream().map(valve -> false).collect(Collectors.toList());

            System.out.println("Solution first round: ");
            Integer sol1 = solver.solve("AA", valvesInitialStateRound1 , 30, false);
            System.out.println(sol1);

            List<Boolean> valvesInitialStateRound2 = input.labels.stream().map(valve -> false).collect(Collectors.toList());

            System.out.println("Solution second round: ");
            Integer sol2 = solver.solve("AA", valvesInitialStateRound2, 26, true);
            System.out.println(sol2);

        } catch (Exception error){
            System.out.println(error);
        }

    }
}
