package com.simplyanalyticsblog;

import java.util.ArrayList;

public class Game {

    public static void main(String[] args) {

        // if no arguments are passed, start a single player game
        if (args.length == 0) {
            play(1, true);
        } else if ("--simulation".equals(args[0])) {
            // if the "--simulation" argument is passed run a simulation using "args[1]" repetitions
            play(Integer.parseInt(args[1]), false);
        } else {
            System.out.println("You can play only on 'single player' or 'simulation' mode. If you want to play in " +
                    "single player do not add any argument when you run the program. If you want to use the " +
                    "simulation version of this game, type --simulation followed by the number of iterations of the " +
                    "game you would like to run.");
        }
    }

    private static void play(int repetitions, boolean isRealPlayer) {

        for (int n = 0; n < repetitions; n++) {
            System.out.println(n + 1 + " / " + repetitions);

            Door a = new Door("A");
            Door b = new Door("B");
            Door c = new Door("C");

            ArrayList<Door> doors = new ArrayList<Door>(3);
            doors.add(a);
            doors.add(b);
            doors.add(c);

            Host monty = new Host();
            Player player = new Player(isRealPlayer);

            // let Monty Hall hide the prize and the player pick its first guess
            monty.hidePrize(doors);
            player.makeFirstGuess(doors);

            // Monty Hall opens one door
            monty.openDoor(doors);

            // player has a chance to switch door
            player.makeSecondGuess(doors);

            // print state after the player made his final choice
            for (int i = 0; i < doors.size(); i++) {
                System.out.println("Door " + doors.get(i).getName() + " --> is winning door: " +
                        doors.get(i).isWinningDoor() + ", is player choice : " + doors.get(i).isPlayerGuess());
            }
            monty.revealFinalResult(doors);
        }
    }
}
