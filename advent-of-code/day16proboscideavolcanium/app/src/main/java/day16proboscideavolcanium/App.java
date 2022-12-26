package day16proboscideavolcanium;

import java.util.*;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.stream.Collectors;

public class App {

    public static void main(String[] args) {

        App.round1HeuristicsExploringPaths();

    }

    public static class Action{
        String label;
        Boolean open;
        String moveTo;
        Action(String label, String moveTo, Boolean open){
            // you either move or open
            this.label = label;
            this.moveTo = moveTo;
            this.open = open;
        }

    }

    private static Graph readInputRound1() throws IOException {
        String fileName = "/Users/andreloboteixeira/coding/swe-training/advent-of-code/day16proboscideavolcanium/app/src/main/java/day16proboscideavolcanium/day16-input.txt";
//        String fileName = "/Users/andreloboteixeira/coding/swe-training/advent-of-code/day16proboscideavolcanium/app/src/main/java/day16proboscideavolcanium/day16-input-test.txt";

        Graph result = new Graph();

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

            for(int i = 0; i < labels.size(); i++){
                result.addVertex(labels.get(i), flowRates.get(i));
            }

            for(int i = 0; i < labels.size(); i++){
                String[] currEdges = allEdgesLabels.get(i);
                for(int j = 0; j < currEdges.length; j++){
                    result.addEdge(labels.get(i), currEdges[j]);
                }
            }

            return result;


        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (br != null) {
                br.close();
            }
        }
        return result;
    }

    // never open a 0 flow rate valve
    // compute the paths from the current node to the non zero flow nodes(N-Nzero), O(N-Nzero) + O(VE)()
    public static void round1HeuristicsExploringPaths(){
        try{
            Graph graph = App.readInputRound1();

            System.out.println(graph.printGraph());
            System.out.println("\n\n");
            for(String label: graph.getVertexesLabels()){
                System.out.println(label + ": " + graph.getVertexFlowRate(label));
            }

            String currVertex = "AA";
            List<Action> actions = new ArrayList<>();
            Integer min = 0;
            Integer totalPressure = 0;
            Integer currFlow = 0;
            while(true){

                List<String> vertexesNonZeroFlow = new ArrayList<>();
                for(String label: graph.getVertexesLabels()){
                    if(graph.getVertexFlowRate(label) != 0){
                        vertexesNonZeroFlow.add(label);
                    }
                }

                if(vertexesNonZeroFlow.size() == 0 || min == 30) break; // no more to open or time is up

                // compute minimal paths from curr vertex to nonzero ones
                List<List<String>> paths = new ArrayList<>();
                for(String nonZeroFlowVertex: vertexesNonZeroFlow){
                    // find path, the last element should be the destination

                    List<String> path = graph.findShortestPath(graph.getVertexesLabels().indexOf(currVertex), graph.getVertexesLabels().indexOf(nonZeroFlowVertex));
                    System.out.println("path from " + currVertex + " to " + nonZeroFlowVertex);
                    System.out.println(path);
                    System.out.println("\n");
                    paths.add(path);
                }

                List<String> pathToVertexWithHighestGain = new ArrayList<>();
                String vertexWithHighestGain = "";
                Integer maxGain = Integer.MIN_VALUE;
                for(int i = 0; i < vertexesNonZeroFlow.size(); i++){
                    Integer costToMoveToVertex = paths.get(i).size();
                    Integer vertexFlowRate = graph.getVertexFlowRate(vertexesNonZeroFlow.get(i));
                    Integer gain = (30 - min - costToMoveToVertex - 1) * vertexFlowRate ;

                    System.out.println("vertex: " + vertexesNonZeroFlow.get(i) + ", flow: " + vertexFlowRate + ", gain: " + gain);
                    System.out.println(paths.get(i));
                    System.out.println("\n");

                    if(gain > maxGain) {
                        maxGain = gain;
                        pathToVertexWithHighestGain = paths.get(i);
                        vertexWithHighestGain = vertexesNonZeroFlow.get(i);
                    }
                }

                System.out.println("Pasth to vertex with highest gain");
                System.out.println(pathToVertexWithHighestGain);
                System.out.println("\n");

                // greedy algorithm, go to the vertex with highest gain and open the valve
                for(String vertex: pathToVertexWithHighestGain){
                    actions.add(new Action(currVertex, vertex, false));
                    min++;
                    currVertex = vertex;
                }

                totalPressure += currFlow * 1; // action is either 1 min to walk or to open
                currFlow += graph.getVertexFlowRate(currVertex);

                actions.add(new Action(currVertex, null, true));
                graph.setVertexFlowRate(currVertex, 0);// open valve

                System.out.println(currVertex + " -> null, ");
                min++;
            }


            System.out.println("Actions size ");
            System.out.println(actions.size());
            for(Action action: actions){
                System.out.println(action.label + " -> " + action.moveTo + ", " + action.open);
                totalPressure += currFlow * 1; // action is either 1 min to walk or to open
                System.out.println(graph.getVertexFlowRate(action.label));
                System.out.println("Current flow: " + currFlow + ", totalPresure: " + totalPressure);
                System.out.println(totalPressure);
            }
            totalPressure += (30 - actions.size()) * currFlow; // remaining minutes

            System.out.println("total pressure ");
            System.out.println(totalPressure);

        } catch (Exception error){
            System.out.println(error);
        }
    }
}
