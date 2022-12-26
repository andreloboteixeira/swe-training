package day16proboscideavolcanium;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Collections;
import java.util.stream.Collectors;
import java.util.stream.Collectors;

import day16proboscideavolcanium.InputReader.Input;

public class DynamicProgrammingSolver {

    Input input;
    Map<Long, Integer> statesMaxPressure;

    DinamicProgrammingSolver(Input input) {
        this.input = input;
        this.statesMaxPressure = new HashMap<Long, Integer>();
    }

    public Integer solve(String startingPosition, List<Boolean> openValves, Integer timeAvailable, Boolean isElephantPlaying){
        return this.maxPressureFromAState(startingPosition, openValves, timeAvailable, isElephantPlaying);
    }

    public Integer maxPressureFromAState(String currPositionLabel, List<Boolean> openValves, Integer time, Boolean isElephantPlaying){
        // stop condition when time is up. For when elephant is present, recurse the algorithm with the elephant starting from AA with 26 min
        if(time == 0) {
            return isElephantPlaying ? this.maxPressureFromAState("AA", openValves, 26, false) : 0;
        }

        Integer currPositionIndex = this.input.labels.indexOf(currPositionLabel);
        Integer currPositionFlowRate = this.input.flowRates.get(currPositionIndex);

        // the state id
        Long stateId = this.computeStateId(currPositionLabel, openValves, time, isElephantPlaying);
        // access previous states
        if(this.statesMaxPressure.containsKey(stateId)) {
            return this.statesMaxPressure.get(stateId);
        }

        Integer maxPressure = 0; // keep track of the max value found from the current position
        // if current valve not already open and and curr valve flow not zero, open valve and recurse to next action
        Boolean isCurrValveOpen = openValves.get(currPositionIndex);
        if(!isCurrValveOpen && currPositionFlowRate > 0){
            List<Boolean> newOpenValves = new ArrayList<>();
            for (Boolean valve: openValves) {
                newOpenValves.add(valve);
            }
            newOpenValves.set(currPositionIndex, true);

            Integer configPressure = (time-1) * currPositionFlowRate + this.maxPressureFromAState(currPositionLabel, newOpenValves, time - 1, isElephantPlaying);

            maxPressure = Integer.max(maxPressure, configPressure);

        }
        // for each connected node, go to it and recurse to compute the maxPressure
        for(String connectedPositionLabel: this.input.allEdgesLabels.get(currPositionIndex)){
            maxPressure = Integer.max(maxPressure, this.maxPressureFromAState(connectedPositionLabel, openValves, time-1, isElephantPlaying));
        }

        // save the state by its id with the maxPressure for future use
        this.statesMaxPressure.put(stateId, maxPressure);

        return maxPressure;
    }

    private Long computeStateId(String currPositionLabel, List<Boolean> openValves, Integer time, Boolean isElephantPlaying){
        String valveBitsRepresentation = openValves.stream()
                                            .map(open -> open ? "1" : "0")
                                            .reduce("", (total, curr) -> total + curr);
        Long valveIntRepresentation = Long.parseLong(valveBitsRepresentation, 2);
        Long positionIndex = Long.valueOf(this.input.labels.indexOf(currPositionLabel));
        Long elephant = isElephantPlaying ? 1L : 0L;
        return valveIntRepresentation*this.input.flowRates.size()*31L*2L + positionIndex*31L*2L + time.longValue()*2L + elephant;
    }

}