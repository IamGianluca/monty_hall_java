package com.simplyanalyticsblog;

import java.util.ArrayList;

public class Game {

    public static void main(String[] args) {

        if (args.length < 2) {
            System.out.println("At the current stage the game runs only on a simulation mode. To use it you need to " +
                    "pass two arguments: --simulation and the number of times you want the simulation to run. ");
        }
        // if the "--simulation" argument is passed run a simulation using "args[1]" repetitions
        if ("--simulation".equals(args[0])) {
            simulate(Integer.parseInt(args[1]));
        } else {
            System.out.println("Sorry, at the moment this game to run just on simulation mode. Stay tuned, a single " +
                    "player version is coming soon!");
        }
    }

    public static void simulate(int repetitions) {

        for (int n = 0; n < repetitions; n++) {
            System.out.println(n+1 + " / " + repetitions);

            Door a = new Door("A");
            Door b = new Door("B");
            Door c = new Door("C");

            ArrayList<Door> doors = new ArrayList<Door>(3);
            doors.add(a);
            doors.add(b);
            doors.add(c);

            Host monty = new Host();
            Player player = new Player();

            // let Monty Hall hide the prize and the player pick its first guess
            monty.hidePrize(doors);
            player.makeFirstGuess(doors);

            // Monty Hall opens one door
            monty.openDoor(doors);

            // player has a chance to switch door
            player.makeSecondGuess(doors);

            // print state after the player made his final choice
            for (int i=0; i < doors.size(); i++) {
                System.out.println("Door " + doors.get(i).getName() + " --> is winning door: " +
                        doors.get(i).isWinningDoor() + ", is player choice : " + doors.get(i).isPlayerGuess());
            }
            monty.revealFinalResult(doors);
        }

    }
}
