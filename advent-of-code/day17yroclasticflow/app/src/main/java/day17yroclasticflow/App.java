package day17yroclasticflow;

public class App {
    public static void main(String[] args) {

        try{                // simulate where the rock will stop to create the rocks in the chamber
            System.out.println("Solution 1, tower size after 2022 rocks have stopped");
            System.out.println(App.round1());
        } catch(Exception error){
            System.out.println(error);
        }

    }

    public static Long round1(){
        Long towerHeight = 0L;
        try{
            Input input = new Input();
            input.readInputRound1();
            input.printInput();

            Game game = new Game(input.jetPattern);

            game.run(2022L);

            towerHeight = game.getCurrChamberHeight();

        } catch(Exception error){
            System.out.println(error);
        }

        return towerHeight;
    }

}
