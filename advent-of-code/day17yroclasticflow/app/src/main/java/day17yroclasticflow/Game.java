package day17yroclasticflow;

import java.util.ArrayList;
import java.util.List;

public class Game {


    List<List<Character>> chamber;
    Long currChamberHeight;
    Long currStep;
    Long currRocksStopped;
    Long currPatternIdx

    List<String> rocksOrder;
    List<Character> jetPattern;

    Game(List<Character> inputJetPattern){
        this.jetPattern = inputJetPattern;
        this.resetGame();
    }


    void run(Long rocksStopped){

        while(currRocksStopped < rocksStopped){
            this.nextStep();
            currStep++;

            System.out.println(">>> curr step" + this.currStep + ", rocks stopped: " + this.currRocksStopped + ", curr height: " + this.getCurrChamberHeight());
        }
        this.resetGame();
    }

    private Long getCurrRock(){
        return this.currRocksStopped%5;
    }

    private Character getCurrPattern(){
        return this.jetPattern.get(this.currPatternIdx.intValue());
    }

    public void nextStep(){
        Long currRock = this.getCurrRock();


        char currPattern = this.getCurrPattern();
        Long currTop = this.getCurrChamberHeight();
        Long currRockBottom = this.currChamberHeight + 3;
        Long currRockLeft = 2L;

        // rock starts falling
        // compute position where the rock will stop to update the chamber state and its current height
        Boolean stopped = false;
        while(!stopped){
            // change rock lateral and vertical until it get to the top

            while(currRockBottom > currTop){
                if(currPattern == '>' && ){


                } else {


                }

            }

            // last line from cur left and righ from piece, if allclear than the rock keeps falling
            List<Character> last = this.chamber.get(this.getCurrChamberHeight().intValue());
            last.get() currRockLeft

        }
    }


    public Long getCurrChamberHeight(){
        return this.currChamberHeight;
    }

    private void resetGame() {
        this.chamber = new ArrayList<>();
        this.currChamberHeight = 0L;

        this.currStep = 0L;
        this.currRocksStopped = 0L;
        this.currPatternIdx = 0L;

        this.rocksOrder = List.of("horizontal", "cross", "mirrored-L", "vertical", "square");
    }

}
