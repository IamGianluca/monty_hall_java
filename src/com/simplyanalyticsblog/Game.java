package com.simplyanalyticsblog;

import java.util.ArrayList;

public class Game {

    public static void main(String[] args) {

        // if no arguments are passed, start a single player game
        if (args.length == 0) {
            play(1, true, false);
        } else if ("--simulation".equals(args[0])) {
            // if the "--simulation" argument is passed, run a simulation iterating `args[1]` times
            // the simulation mode has an optional `verbose` method. When verbose is called intermediate results
            //   for each game are printed
            boolean verbose = false;
            if (args.length == 3 && "--verbose".equals(args[2])) {
                verbose = true;
            } else if (args.length == 3 && !"--verbose".equals(args[2])) {
                System.out.println("Did you mean to call the `--verbose` method? If so, just add the optional " +
                        "argument `--verbose` at the end of your call. The verbose method is only available when " +
                        "running a simulation");
                System.exit(0);
            } else {
                verbose = false;
            }
            play(Integer.parseInt(args[1]), false, verbose);

        } else {
            System.out.println("You can play only on 'single player' or 'simulation' mode. If you want to play in " +
                    "single player do not add any argument when you run the program. If you want to use the " +
                    "simulation version of this game, type `--simulation` followed by the number of iterations " +
                    "you would like to run.");
        }
    }

    private static void play(int repetitions, boolean isRealPlayer, boolean verbose) {

        String NOSWITCH_LOST = "Player didn't switch door and lost";
        String NOSWITCH_WIN = "Player didn't switch door and won";
        String SWITCH_LOST = "Player switched door and lost";
        String SWITCH_WIN = "Player switched door and won";

        ArrayList<String> results = new ArrayList<String>(repetitions);

        for (int n = 0; n < repetitions; n++) {
            if (verbose) {
                System.out.println(n + 1 + " / " + repetitions);
            }

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
            monty.hidePrize(doors, verbose);
            player.makeFirstGuess(doors, verbose);

            // Monty Hall opens one door
            monty.openDoor(doors, verbose);

            // player has a chance to switch door
            player.makeSecondGuess(doors, verbose);

            // if not in simulation mode, print state after the player made his final choice
            if (isRealPlayer) {
                for (Door door : doors) {
                    System.out.println("Door " + door.getName() + " --> is winning door: " +
                            door.isWinningDoor() + ", is player choice : " + door.isPlayerGuess());
                }
            }
            results.add(monty.revealFinalResult(doors, verbose));
        }

        // print final results
        Integer wins = 0;
        for (String result : results) {
            if (result.equals("win")) {
                wins += 1;
            }
        }
        System.out.println("You won " + wins + " out of " + results.size() + " games");
    }
}
